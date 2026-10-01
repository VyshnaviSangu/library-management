import java.time.LocalDate;
public class Main {
    public static void main(String[] args){
        

        System.out.println(library.findById(2));
        System.out.println(library.findById(99));   // null

        for (Book book : library.search("clean")) {
         System.out.println(book);
        }
    }
}
