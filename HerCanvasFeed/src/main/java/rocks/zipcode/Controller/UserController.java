package rocks.zipcode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocks.zipcode.accessingdatamysql.User;
import rocks.zipcode.accessingdatamysql.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
   // @Autowired
    //    private UserRepository userRepository;
    //    @GetMapping("/{userId}")
    //    public ResponseEntity<User>
    //    getUser (@PathVariable Integer userId) {
    //        // User user = UserRepository.findById(userId).orElseThrow();

    }
