package AMSS.ProiectAMSS_HeapOverflow.Controller;

import AMSS.ProiectAMSS_HeapOverflow.Models.Question;
import AMSS.ProiectAMSS_HeapOverflow.Service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    public final QuestionService questionService;


    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questionList")
    public ResponseEntity<List<Question>> questionList() {
        return ResponseEntity.ok().body(questionService.findAllQuestions());
    }

    @GetMapping("/byTitle/{questionTitle}")
    public ResponseEntity<?> questionByTitle(@PathVariable String questionTitle) {
        return ResponseEntity.ok().body(questionService.findQuestionByTitle(questionTitle));
    }

    @PostMapping("/new")
    public ResponseEntity<Question> newQuestion(@RequestBody Question question) {
        return ResponseEntity.ok().body(questionService.addQuestion(question));
    }
}
