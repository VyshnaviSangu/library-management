import java.time.LocalDate;
public class Main {
    public static void main(String[] args){
        LibraryService library = new LibraryService();
        library.addBook("Clean Code", "Robert Martin");
        library.addBook("Java Basics", "Herbert");
        
    }
}
