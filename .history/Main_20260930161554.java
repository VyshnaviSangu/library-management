import java.time.LocalDate;
public class Main {
    public static void main(String[] args){
        Book b = new Book(1,"Clean Code","Robert Martin");
        LibraryService library = new LibraryService();
        library.addBook("Clean Code", "Robert Martin");
        library.addBook("Java Basics", "Herbert");

        for (b : library.getAll()) {
            System.out.println(b);
        }
    }
}
