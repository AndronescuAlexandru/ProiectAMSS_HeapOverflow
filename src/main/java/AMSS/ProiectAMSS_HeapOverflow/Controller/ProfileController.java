package AMSS.ProiectAMSS_HeapOverflow.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import AMSS.ProiectAMSS_HeapOverflow.Models.Profile;
import AMSS.ProiectAMSS_HeapOverflow.Service.ProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    public final ProfileService profileService;

    public ProfileController(ProfileService _profileService) {
        this.profileService = _profileService;
    }

    @GetMapping("/user")
    public ResponseEntity<Profile> loadUserProfile() {
        return ResponseEntity.ok().body(profileService.loadProfile());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<Profile> loadProfileWanted(@PathVariable String username) {
        return ResponseEntity.ok().body(profileService.findProfileByAccountName(username));
    }

    @PostMapping("/description/{description}")
    public ResponseEntity<?> changeDescription(@PathVariable String description) {
        return ResponseEntity.ok().body(profileService.editProfileDescription(description));
    }
}
