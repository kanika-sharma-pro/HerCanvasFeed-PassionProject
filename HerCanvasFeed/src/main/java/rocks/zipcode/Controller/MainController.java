package rocks.zipcode.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.accessingdatamysql.User;
import rocks.zipcode.accessingdatamysql.UserRepository;

@Controller
@RequestMapping( "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String name , @RequestParam String email,
      @RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer userId ) {
        User n = new User();
n.setUserName(name);
n.setUserEmail(email);
n.setUserId(userId);
n.setFirstName(firstName);
n.setLastName(lastName);

userRepository.save(n);
return "Saved";
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();



    }

}
