package AMSS.ProiectAMSS_HeapOverflow.Models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question {

    private int id;

    private String datePosted;
    private String title;
    private String content;
    private String accountName;

    private List<Comment> commentList = new ArrayList<>();

    public Question(int id, String date, String title, String content, String accountName){
        this.id = id;
        this.datePosted = date;
        this.title = title;
        this.content = content;
        this.accountName = accountName;
    }

    public int getQuestionId(){return this.id;}
    public void setQuestionId(int id) {this.id = id;}

    public String getDatePosted(){return this.datePosted;}
    public void setDatePosted(String newDate) {this.datePosted = newDate;}

    public String getTitle(){return this.title;}
    public void setTitle(String questionTitle) {this.title = questionTitle;}

    public String getContent(){return this.content;}
    public void setContent(String newContent){this.content = newContent;}

    public String getAccountName(){return this.accountName;}
    public void setAccountName(String newAccountName){this.accountName = newAccountName;}

}
