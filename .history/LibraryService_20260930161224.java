import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
public class LibraryService{
    private List<Book> books = new ArrayList<>();

    public void addBook(String title,String author){
        int id = books.isEmpty()?1:books.get(books.size()-1).getId()+1;
        books.add()
    }
}