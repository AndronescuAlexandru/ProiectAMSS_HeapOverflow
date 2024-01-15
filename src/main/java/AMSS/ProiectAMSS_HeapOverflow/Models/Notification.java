package AMSS.ProiectAMSS_HeapOverflow.Models;

public class Notification {

    private int id_notif;
    private String notif;
    private String username;

    private int id_question;

    public Notification(int id_notif, String username, int id_question) {
        this.id_notif = id_notif;
        this.username = username;
        this.id_question = id_question;
    }

    public int getId_notif() {
        return id_notif;
    }

    public void setId_notif(int id_notif) {
        this.id_notif = id_notif;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
