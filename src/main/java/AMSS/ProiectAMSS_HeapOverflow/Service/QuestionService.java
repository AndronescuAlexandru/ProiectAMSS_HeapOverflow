package AMSS.ProiectAMSS_HeapOverflow.Service;

import AMSS.ProiectAMSS_HeapOverflow.ExceptionHandling.QuestionNotFoundExceptionHandler;
import AMSS.ProiectAMSS_HeapOverflow.Models.Comment;
import AMSS.ProiectAMSS_HeapOverflow.Models.Question;
import AMSS.ProiectAMSS_HeapOverflow.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public String addQuestion(String title, String content){
        int generatedId =  (int)(Math.random() * 100000);
        Date dateTime = new Date();

        Question newQuestion = new Question(generatedId, dateTime.toString(), title, content, "Guest" + generatedId);
        return questionRepository.addQuestion(newQuestion);
    }

    public List<Question> findQuestionById(int questionId){
        return questionRepository.findQuestionById(questionId);
    }

    public List<Question> findQuestionByTitle(String questionTitle){
        return questionRepository.findQuestionByTitle(questionTitle);
    }

    public Question findQuestionByAcc(String accName){
        return questionRepository.findQuestionByAcc(accName);
    }

    public List<Question> findAllQuestions(){
        return questionRepository.findAllQuestions();
    }

    public String addComment(int questionId, String commentContent){
        return questionRepository.addComment(questionId, commentContent);
    }

    public List<Comment> findAllComments(int questionId){
        return questionRepository.findAllComments(questionId);
    }
}
