import java.util.Scanner;
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final LibraryService library = new LibraryService();
    public static void main(String[] args){
       while(true){
        System.out.println("\n1. Add book");
        System.out.println("2. View all books");
        System.out.println("0. Exit");
        int choice = readInt("Choose an option: ");
        switch (choice) {
            case 1{
                String title = readInt("Title: ");
                String author = readText("Author: ");
                library.addBook(title,author);
                System.out.println("Book added.");
                break;
            }
            default:
                break;
        }
       }
    }
}
