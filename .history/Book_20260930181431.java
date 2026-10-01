import java.time.LocalDate;

public class Book{
    private int id;
    private String title;
    private String author;
    private String issuedTo;
    private LocalDate issueDate;
    public Book(int id,String title,String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public String getIssuedTo(){return issuedTo;}
    public LocalDate getIssueDate(){return issueDate;}
    public boolean isAvailable(){
        return issuedTo == null;
    }
    public void issue(String member,LocalDate date){
        this.issuedTo = member;
        this.issueDate = date;
    }
    public void giveBack(){
        this.issuedTo = null;
        this.issueDate = null;
    }
    @Override 
    public String toString(){
        String status = isAvailable()?"Available":"Issued to "+issuedTo+" on "+issueDate;
        return "#"+id+" "+title+" by "+author+" - "+status;
    }
    public String toCsv(){
        return id+","+title+","+author+","
        +(issuedTo == null ? "":issuedTo)+","
        
    }
}
