import java.time.LocalDate;

import .history.Book;

public class Main {
    public static void main(String[] args){
        Book b = new Book(1,"Clean Code","Robert Martin");
        System.out.println(b);
        b.issue("Rahul", LocalDate.now());
System.out.println(b);
    }
}
