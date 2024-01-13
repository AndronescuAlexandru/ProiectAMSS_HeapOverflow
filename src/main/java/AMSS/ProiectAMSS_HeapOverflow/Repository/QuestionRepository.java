package AMSS.ProiectAMSS_HeapOverflow.Repository;

import AMSS.ProiectAMSS_HeapOverflow.ExceptionHandling.QuestionNotFoundExceptionHandler;
import AMSS.ProiectAMSS_HeapOverflow.Models.Comment;
import AMSS.ProiectAMSS_HeapOverflow.Models.Question;

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
        question1.addComment(c);
        questionList.add(question1);
        questionList.add(question2);

    }

    public String addQuestion(Question newQuestion){
        questionList.add(newQuestion);

        return "Added question with success!";
    }

    public Question addComment(Question question, Comment comment){
        for (Question q:questionList) {
            if(q.getQuestionId() == question.getQuestionId()){
                q.addComment(comment);
            }

        }
        return question;
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
}
