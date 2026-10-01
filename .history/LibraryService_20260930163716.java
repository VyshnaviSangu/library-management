import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;
public class LibraryService{
    private List<Book> books = new ArrayList<>();

    public void addBook(String title,String author){
        int id = books.isEmpty()?1:books.get(books.size()-1).getId()+1;
        books.add(new Book(id,title,author));
    }
    public List<Book> getAll(){
        return books;
    }
    public Book findById(int id){
        for(Book b:books){
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }
    public List<Book> search(String keyword){
        List<Book> result = new ArrayList<>();
        String k = keyword.toLowerCase();
        for(Book b : books){
            if(b.getTitle().toLowerCase().contains(k) || b.getAuthor().toLowerCase().contains(k)){
                result.add(b);
            }
        }
        return result;
    }
    public String issueBook(int id,String member){
        Book b = findById(id);
        if(b==null) return "No book found with id "+id;
        if(!b.isAvailable()) return "Already issued to "+b.getIssuedTo();
        b.issue(member,LocalDate.now());
        return "Issued\""+b.getTitle()+"\"to"+member;
    }
    public String returnBook(int id){
        Book b = findById(id);
        if(b==null) return "No book found with id "+id;
        if(b.isAvailable()) return "This book was not issued";
        
        long days = ChronoUnit.DAYS.between(b.getIssueDate(),LocalDate.now());
        long lateDays = Math.max(0,days-7);
        b.giveBack();
    }
    public boolean deleteBook(int id){
        Book b = findById(id);
        if(b==null) return false;
        books.remove(b);
        return true;
    }
}