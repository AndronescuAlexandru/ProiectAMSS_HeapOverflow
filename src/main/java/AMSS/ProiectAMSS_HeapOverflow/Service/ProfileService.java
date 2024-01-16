package AMSS.ProiectAMSS_HeapOverflow.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import AMSS.ProiectAMSS_HeapOverflow.Models.Profile;
import AMSS.ProiectAMSS_HeapOverflow.Repository.ProfileRepository;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository _profileRepository) {
        this.profileRepository = _profileRepository;
    }

    public Profile loadProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return profileRepository.findProfileByAccountName(username);
    }

    public Profile findProfileByAccountName(String username) {
        return profileRepository.findProfileByAccountName(username);
    }

    public Profile editProfileDescription(String _description) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return profileRepository.changeDescription(_description, username);
    }

    public Profile editProfileEmail(String _email) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return profileRepository.changeEmail(_email, username);
    }

    public Profile increaseScoreBy(int score) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return profileRepository.increaseScoreBy(score, username);
    }
}
