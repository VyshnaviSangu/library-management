import java.time.LocalDate;

import .history.Book;
import .history.LibraryService;
public class Main {
    public static void main(String[] args){
        LibraryService library = new LibraryService();
library.addBook("Clean Code", "Robert Martin");
library.addBook("Java Basics", "Herbert");

        System.out.println(library.findById(2));
        System.out.println(library.findById(99));   // null

        for (Book book : library.search("clean")) {
         System.out.println(book);
        }
    }
}
