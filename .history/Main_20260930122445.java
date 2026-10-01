import .history.Book;

public class Main {
    public static void main(String[] args){
        Book b = new Book(1,"Clean Code","Robert Martin");
        System.out.println("Book created");
        System.out.println(b.getTitle());
        System.out.println(b.getAuthor());
        System.out.println(b.getId());
    }
}
