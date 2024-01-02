package AMSS.ProiectAMSS_HeapOverflow.Service;

import AMSS.ProiectAMSS_HeapOverflow.ExceptionHandling.QuestionNotFoundExceptionHandler;
import AMSS.ProiectAMSS_HeapOverflow.Models.Question;
import AMSS.ProiectAMSS_HeapOverflow.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question addQuestion(Question question){
        if(Objects.isNull(question.getTitle())){
            throw new RuntimeException("Question title cannot be null");
        }
        return questionRepository.addQuestion(question);
    }

    public Question findQuestionByTitle(String questionTitle){
        return questionRepository.findQuestionByTitle(questionTitle);
    }

    public List<Question> findAllQuestions(){
        return questionRepository.findAllQuestions();
    }
}
