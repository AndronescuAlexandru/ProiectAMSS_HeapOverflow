package AMSS.ProiectAMSS_HeapOverflow.Service;

import AMSS.ProiectAMSS_HeapOverflow.ExceptionHandling.QuestionNotFoundExceptionHandler;
import AMSS.ProiectAMSS_HeapOverflow.Models.Comment;
import AMSS.ProiectAMSS_HeapOverflow.Models.Question;
import AMSS.ProiectAMSS_HeapOverflow.Repository.NotificationRepository;
import AMSS.ProiectAMSS_HeapOverflow.Repository.QuestionRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository, NotificationRepository notificationRepository) {

        this.questionRepository = questionRepository;
    }

    public String addQuestion(int questionId,String title, String content){
        Date dateTime = new Date();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Question newQuestion = new Question(questionId, dateTime.toString(), title, content, authentication.getName());
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
