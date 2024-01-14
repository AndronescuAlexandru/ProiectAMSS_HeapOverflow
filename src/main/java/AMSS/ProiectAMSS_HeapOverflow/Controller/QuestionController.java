package AMSS.ProiectAMSS_HeapOverflow.Controller;

import AMSS.ProiectAMSS_HeapOverflow.Models.Comment;
import AMSS.ProiectAMSS_HeapOverflow.Models.Question;
import AMSS.ProiectAMSS_HeapOverflow.Service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    public final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Question>> listAllQuestions() {
        return ResponseEntity.ok().body(questionService.findAllQuestions());
    }
    @GetMapping("/byId/{questionId}")
    public ResponseEntity<List<Question>> findQuestionById(@PathVariable int questionId) {
        return ResponseEntity.ok().body(questionService.findQuestionById(questionId));
    }
    @GetMapping("/byTitle/{questionTitle}")
    public ResponseEntity<List<Question>> findQuestionByTitle(@PathVariable String questionTitle) {
        return ResponseEntity.ok().body(questionService.findQuestionByTitle(questionTitle));
    }

    @GetMapping("/byAcc/{accName}")
    public ResponseEntity<?> findQuestionByAcc(@PathVariable String accName){
        return ResponseEntity.ok().body(questionService.findQuestionByAcc(accName));
    }

    @GetMapping("/{questionId}/listComments")
    public ResponseEntity<List<Comment>> listAllComments(@PathVariable int questionId) {
        return ResponseEntity.ok().body(questionService.findAllComments(questionId));
    }

    @PostMapping("/new/{questionId}/{questionTitle}/{questionContent}")
    public ResponseEntity<?> newQuestion( @PathVariable int questionId,@PathVariable String questionTitle, @PathVariable String questionContent) {
        return ResponseEntity.ok().body(questionService.addQuestion(questionId, questionTitle, questionContent));
    }

    @PostMapping("/addComment/{questionId}/{commentContent}")
    public ResponseEntity<?> addComment( @PathVariable int questionId, @PathVariable String commentContent) {
        return ResponseEntity.ok().body(questionService.addComment(questionId, commentContent));
    }
}
