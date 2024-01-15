package AMSS.ProiectAMSS_HeapOverflow.Controller;
import AMSS.ProiectAMSS_HeapOverflow.Models.Comment;
import AMSS.ProiectAMSS_HeapOverflow.Models.Notification;
import AMSS.ProiectAMSS_HeapOverflow.Service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/notifications")
public class NotificationController {
    public final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Notification>> listAllNotifications() {
        return ResponseEntity.ok().body(notificationService.findAllNotifications());
    }

    @PostMapping("/new/{notificationId}/{username}/{questionId}")
    public ResponseEntity<?> newNotification( @PathVariable int notificationId,@PathVariable String username, @PathVariable int questionId) {
        return ResponseEntity.ok().body(notificationService.addNotification(notificationId, username, questionId));
    }
}