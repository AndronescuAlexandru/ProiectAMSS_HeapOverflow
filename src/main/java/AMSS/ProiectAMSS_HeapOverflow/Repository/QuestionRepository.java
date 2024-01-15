package AMSS.ProiectAMSS_HeapOverflow.Repository;

import AMSS.ProiectAMSS_HeapOverflow.ExceptionHandling.QuestionNotFoundExceptionHandler;
import AMSS.ProiectAMSS_HeapOverflow.Models.Comment;
import AMSS.ProiectAMSS_HeapOverflow.Models.Question;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class QuestionRepository {
    private List<Question> questionList = new ArrayList<>();

    public QuestionRepository(){
        Comment c = new Comment(0,1,"Maria",
                "Use #include <fstream> header and use fstream file to create a file similar to how you would create a variable"
                ,"2/1/2024");
        Question question1 = new Question(1, "1/1/2024","How to create files in C++", "How can I make files in my C++ program?",
                "Alex");
        Question question2 = new Question(2, "21/5/2023","How to generate random numbers in Java",
                "How can I generate random int, double numbers in my Java program?",
                "NewUser12345");
        Question question3 = new Question(3, "21/5/2023","Recursion is losing previous information when it comes back",
                "I am trying to create a recursive function, but I am having issues where to be what I believe is how the result of g_resource_enumerate_children is being returned/stored."
                + "As seen, I have two .css files and only one was shown in the output, and only the css folder was processed and even so, only partially." +
                        "I am thinking that the issue lies with g_resource_enumerate_children in that since it returns a pointer that it is overwriting the data that " +
                        "was there on each recursion (or maybe I am wrong). Anyway is there a way for me to keep the data persistent so it can go through all the files?",
                "NewUser12345");
        question1.addComment(c);
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);

    }

    public String addQuestion(Question newQuestion){
        questionList.add(newQuestion);

        return "Added question with success!";
    }

    public List<Question> findQuestionById(int questionId){
        List<Question> questions = new ArrayList<>();
        for(Question q : questionList){
            if(q.getQuestionId() == questionId){
                questions.add(q);
            }
        }
        return questions;
    }

    public List<Question> findQuestionByTitle(String questionTitle){
        List<Question> questions = new ArrayList<>();
        Question q1 = questionList.stream().filter(question -> question.getTitle().equalsIgnoreCase(questionTitle))
                .findFirst().orElseThrow(() -> new QuestionNotFoundExceptionHandler("Question for the given title was not found"));
        questions.add(q1);
        return questions;
    }

    public Question findQuestionByAcc(String accName){
        return questionList.stream().filter(question -> question.getAccountName().equalsIgnoreCase(accName))
                .findFirst().orElseThrow(() -> new QuestionNotFoundExceptionHandler("Question for the given account name was not found"));
    }

    public List<Question> findAllQuestions(){
        return questionList;
    }

    public String  addComment(int questionId, String commentContent){
        int generatedId =  (int)(Math.random() * 100000);
        Date dateTime = new Date();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Comment newComment = new Comment(generatedId, questionId, authentication.getName(), commentContent, dateTime.toString());
        for (Question q:questionList) {
            if(q.getQuestionId() == questionId){
                q.addComment(newComment);
            }

        }
        return "Comment added!";
    }

    public List<Comment> findAllComments(int questionId){
        List<Comment> commentList = new ArrayList<>();
        for(Question q : questionList){
            if(q.getQuestionId() == questionId){
                commentList = q.getCommentList();
            }
        }
        return commentList;
    }
}
