package AMSS.ProiectAMSS_HeapOverflow.Models;


import java.util.Date;

public class Comment {

    private int id;
    private int questionId;

    private String accountName;
    private String content;
    private Date datePosted;

    public Comment(){

    }

    public int getCommentId(){ return id;}
    public void setCommentId(int newId){ this.id = newId;}

    public int getQuestionId(){ return questionId;}
    public void setQuestionId(int newId){ this.questionId = newId;}

    public String getAccountName(){ return accountName;}
    public void setAccountName(String accountName) {this.accountName = accountName;}

    public String getContent(){ return content;}
    public void setContent(String content) {this.content = content;}

    public Date getDatePosted(){ return datePosted;}
    public void setDatePosted(Date date){this.datePosted = date;}
}
