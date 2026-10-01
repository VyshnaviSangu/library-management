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
            if(b.getInd()==id){
                return b;
            }
        }
        return null;
    }
    public List<Book> search(String keyword){
        List<Book> result = new ArrayList<>();
        String k = keyword.toLowerCase();
        for(Book b : books){
            if(b.getTitle().toLowerCase().contains(k) || b.getAuthor().to)
        }
    }
}