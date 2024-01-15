package AMSS.ProiectAMSS_HeapOverflow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.regex.*;

@Controller
public class AuthenticationController {
    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @PostMapping("/registration")
    public String newUser(@RequestParam String username, @RequestParam String password) {
        boolean hasUpperCase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLowerCase = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasNumbers = Pattern.compile("\\d").matcher(password).find();
        boolean hasSpecialChars = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find();

        if (!hasUpperCase || !hasLowerCase || !hasNumbers || !hasSpecialChars || password.length() < 8) {
            return "redirect:/registration?passwordNotValid";
        }

        if (inMemoryUserDetailsManager.userExists(username))
        {
            return "redirect:/registration?usernameInUse";
        }

        UserDetails userDetails = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles("USER")
                .build();
        inMemoryUserDetailsManager.createUser(userDetails);
        return "redirect:/login?accountCreated";
    }
}
