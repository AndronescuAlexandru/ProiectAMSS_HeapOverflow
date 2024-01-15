package AMSS.ProiectAMSS_HeapOverflow.Service;

import AMSS.ProiectAMSS_HeapOverflow.Models.Notification;
import AMSS.ProiectAMSS_HeapOverflow.Repository.NotificationRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public String addNotification(int id_notif, String username, int id_question){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Notification newNotification = new Notification(id_notif, authentication.getName(),id_question);
        return notificationRepository.addNotification(newNotification);
    }

    public List<Notification> findAllNotifications(){
        return notificationRepository.findAllNotifications();
    }
}
