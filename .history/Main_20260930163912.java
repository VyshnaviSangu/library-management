import java.time.LocalDate;

import .history.Book;
import .history.LibraryService;
public class Main {
    public static void main(String[] args){
        LibraryService library = new LibraryService();
        library.addBook("Clean Code", "Robert Martin");
        library.addBook("Java Basics", "Herbert");
        
    Book b = library.findById(1);
    b.issue("Rahul", LocalDate.now().minusDays(10));
    System.out.println(library.returnBook(1));    
    }
}
