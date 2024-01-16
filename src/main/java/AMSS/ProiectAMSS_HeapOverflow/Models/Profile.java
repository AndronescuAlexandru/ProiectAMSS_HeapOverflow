package AMSS.ProiectAMSS_HeapOverflow.Models;

public class Profile {

    private int id;
    private String accountName;
    private String email;
    private Boolean emailVerified;
    private String description;
    private int engagementScore;
    private int highestAchievedBadge;
    
    public Profile(int _id, String _accountName) {
        this.id = _id;
        this.accountName = _accountName;
        this.email = "no_mail_added@gmail.com";
        this.emailVerified = false;
        this.description = "no description";
        this.engagementScore = 0;
        this.highestAchievedBadge = 0;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public Boolean getEmailVerified() {
        return this.emailVerified;
    }

    public void setEmailVerified() {
        this.emailVerified = true;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String _description) {
        this.description = _description;
    }

    public int getEngagementScore() {
        return this.engagementScore;
    }

    public void increaseEngagementScore(int increasePoints) {
        this.engagementScore += increasePoints;
    }

    public int getHighestAchievedBadge() {
        checkForUpdateBadge();
        return this.highestAchievedBadge;
    }

    private void checkForUpdateBadge() {
        int[] levelBadge = {0, 1, 5, 10, 50, 100, 500, 1000, 2500, 5000, 10000};

        int currentLevel = 0;
        while(currentLevel + 1 < 11) {
            if(levelBadge[currentLevel + 1] <= this.engagementScore) {
                currentLevel += 1;
            }
            else break;
        }

        this.highestAchievedBadge = currentLevel;
    }
}
