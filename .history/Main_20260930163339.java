import java.time.LocalDate;

import .history.LibraryService;
public class Main {
    public static void main(String[] args){
        LibraryService library = new LibraryService();
        library.addBook("Clean Code", "Robert Martin");
        library.addBook("Java Basics", "Herbert");

        System.out.println(library.issueBook(1, "Rahul"));
        System.out.println(library.issueBook(1, "Anil"));   // already issued
        // System.out.println(library.returnBook(1));
System.out.println(library.deleteBook(2));          // true
System.out.println(library.deleteBook(99));         // false
    }
}
