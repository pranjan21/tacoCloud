package tacos.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tacos.data.UserRepository;
import tacos.security.RegistrationForm;

@RestController
@RequestMapping(path = "/register", consumes = "application/json")
@CrossOrigin("*")
public class RegistrationController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepo,
                                  PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = encoder;
    }

    @GetMapping("/")
    @ResponseBody
    public String registrationForm() {
        return "registration";
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String processRegistration(@RequestBody RegistrationForm form) {

        this.userRepo.save(form.toUser(this.passwordEncoder));
        return "redirect:/design";
    }
}
