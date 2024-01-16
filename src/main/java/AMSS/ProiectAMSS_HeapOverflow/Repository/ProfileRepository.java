package AMSS.ProiectAMSS_HeapOverflow.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import AMSS.ProiectAMSS_HeapOverflow.Models.Profile;

@Repository
public class ProfileRepository {
    private List<Profile> profileList = new ArrayList<>();

    public ProfileRepository() {
        Profile profile1 = new Profile(1, "admin");
        profile1.setDescription("Hi there! I'm the admin!!!");
        profile1.setEmailVerified();
        profile1.setEmail("admin_min@gmail.com");
        profile1.increaseEngagementScore(999999999);
        profileList.add(profile1);

        Profile profile2 = new Profile(2, "damino");
        profile2.increaseEngagementScore(400);
        profile2.setEmail("damino.am@gmail.com");
        profileList.add(profile2);
    }

    public String addProfile(Profile _profile) {
        profileList.add(_profile);

        return "Added profile with success!";
    }

    public Profile findProfileById(int id) {
        for(int i = 0; i < profileList.size(); ++i) {
            if(profileList.get(i).getId() == id) {
                return profileList.get(i);
            }
        }

        Profile notFoundProfile = new Profile(-1, "not found");
        return notFoundProfile;
    }

    public Profile findProfileByAccountName(String accountName) {
        int biggestId = 0;
        for(int i = 0; i < profileList.size(); ++i) {
            biggestId = Math.max(biggestId, profileList.get(i).getId());
            if(profileList.get(i).getAccountName().equals(accountName)) {
                return profileList.get(i);
            }
        }

        Profile newProfile = new Profile(biggestId + 1, accountName);
        updateProfile(newProfile);
        return newProfile;
    }

    public Profile changeDescription(String _description, String username) {
        Profile ansProfile = findProfileByAccountName(username);
        ansProfile.setDescription(_description);
        updateProfile(ansProfile);
        return ansProfile;
    }

    public Profile changeEmail(String _email, String username) {
        Profile ansProfile = findProfileByAccountName(username);
        ansProfile.setEmail(_email);
        updateProfile(ansProfile);
        return ansProfile;
    }
    
    public Profile increaseScoreBy(int score, String username) {
        Profile ansProfile = findProfileByAccountName(username);
        ansProfile.increaseEngagementScore(score);
        updateProfile(ansProfile);
        return ansProfile;
    }

    private void updateProfile(Profile profile) {
        for(int i = 0; i < profileList.size(); ++i) {
            if(profileList.get(i).getAccountName().equals(profile.getAccountName())) {
                profileList.set(i, profile);
                return;
            }
        }

        profileList.add(profile);
    }
}
