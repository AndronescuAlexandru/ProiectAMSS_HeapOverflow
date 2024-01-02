package AMSS.ProiectAMSS_HeapOverflow.Repository;

import AMSS.ProiectAMSS_HeapOverflow.ExceptionHandling.QuestionNotFoundExceptionHandler;
import AMSS.ProiectAMSS_HeapOverflow.Models.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionRepository {
    private List<Question> questionList = new ArrayList<>();

    public QuestionRepository(){
        Question question1 = new Question(1, "1/1/2024","How to create files in C++?", "How can I make files in my C++ program?",
                "Alex");
        Question question2 = new Question(2, "21/5/2023","How to generate random numbers in Java?",
                "How can I generate random int, double numbers in my Java program?",
                "NewUser12345");
        questionList.add(question1);
        questionList.add(question2);

    }

    public Question addQuestion(Question question){
        //int generatedId =  (int)(Math.random() * 100000)
        //question.setQuestionId(generatedId);
        questionList.add(question);
        return question;
    }

    public Question findQuestionByTitle(String questionTitle){
        return questionList.stream()
                .filter(question -> question.getTitle().equalsIgnoreCase(questionTitle))
                .findFirst()
                .orElseThrow(() -> new QuestionNotFoundExceptionHandler("Question for the given title was not found"));
    }

    public List<Question> findAllQuestions(){
        return questionList;
    }
}
