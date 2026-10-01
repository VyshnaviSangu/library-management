import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import .history.Book;

import java.time.temporal.ChronoUnit;
import java.io.*;
public class LibraryService{
    private List<Book> books = new ArrayList<>();
    public LibraryService() {
    load();
    }
    public void addBook(String title,String author){
        int id = books.isEmpty()?1:books.get(books.size()-1).getId()+1;
        books.add(new Book(id,title.replace(","," "),author.replace(","," ")));
        save();
    }
    public List<Book> getAll(){
        return books;
    }
    public Book findById(int id){
        for(Book b:books){
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }
    private void save() {
    try (PrintWriter out = new PrintWriter(new FileWriter("books.csv"))) {
        for (Book b : books) {
            out.println(b.toCsv());
        }
    } catch (IOException e) {
        System.out.println("Could not save data: " + e.getMessage());
    }
}

private void load() {
    File f = new File("books.csv");
    if (!f.exists()) return;
    try (BufferedReader in = new BufferedReader(new FileReader(f))) {
        String line;
        while ((line = in.readLine()) != null) {
            if (!line.isBlank()) books.add(Book.fromCsv(line));
        }
    } catch (IOException e) {
        System.out.println("Could not read saved data: " + e.getMessage());
    }
}
    public List<Book> search(String keyword){
        List<Book> result = new ArrayList<>();
        String k = keyword.toLowerCase();
        for(Book b : books){
            if(b.getTitle().toLowerCase().contains(k) || b.getAuthor().toLowerCase().contains(k)){
                result.add(b);
            }
        }
        return result;
    }

    public String issueBook(int id,String member){
        Book b = findById(id);
        if(b==null) return "No book found with id "+id;
        if(!b.isAvailable()) return "Already issued to "+b.getIssuedTo();
        b.issue(member,LocalDate.now());
        return "Issued\""+b.getTitle()+"\"to"+member;
        save();
    }
    public String returnBook(int id){
        Book b = findById(id);
        if(b==null) return "No book found with id "+id;
        if(b.isAvailable()) return "This book was not issued";
        
        long days = ChronoUnit.DAYS.between(b.getIssueDate(),LocalDate.now());
        long lateDays = Math.max(0,days-7);
        b.giveBack();

        if(lateDays == 0) return "Book returned on time. No fine.";
        return "Returned "+lateDays+"day(s) late. Fine: Rs."+(lateDays*2);
        save();
    }
    public boolean deleteBook(int id){
        Book b = findById(id);
        if(b==null) return false;
        books.remove(b);
        return true;
        save();
    }
}