package rocks.zipcode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.accessingdatamysql.User;
import rocks.zipcode.accessingdatamysql.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserController {


    @Autowired
       private UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }







}

//    @GetMapping("/{userId}")
//    public ResponseEntity<User>
//    getUser (@PathVariable Integer userId) {
//        // User user = UserRepository.findById(userId).orElseThrow();
//@PostMapping
//    public User saveUserWithFeed (@ResponseBody User user){
//return userRepository.save(user);