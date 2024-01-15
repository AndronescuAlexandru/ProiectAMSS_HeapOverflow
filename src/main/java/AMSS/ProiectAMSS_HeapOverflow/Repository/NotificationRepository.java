package AMSS.ProiectAMSS_HeapOverflow.Repository;

import AMSS.ProiectAMSS_HeapOverflow.Models.Comment;
import AMSS.ProiectAMSS_HeapOverflow.Models.Notification;
import AMSS.ProiectAMSS_HeapOverflow.Models.Question;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificationRepository {
    private List<Notification> notificationList = new ArrayList<>();

    public NotificationRepository() {
    }
    public List<Notification> findAllNotifications() {
        return notificationList;
    }
    public String addNotification(Notification notification){
        notificationList.add(notification);
        return "notification added";
    }
}