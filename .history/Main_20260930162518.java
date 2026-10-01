import java.time.LocalDate;
public class Main {
    public static void main(String[] args){
        Book b = new Book(1,"Clean Code","Robert Martin");
        
        System.out.println(library.findById(2));
        System.out.println(library.findById(99));   // null

        for (Book book : library.search("clean")) {
         System.out.println(book);
        }
    }
}
