import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        return "Issued\""+b.getTitle()+"\""
    }
}