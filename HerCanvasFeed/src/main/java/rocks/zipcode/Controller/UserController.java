package rocks.zipcode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.accessingdatamysql.Feed;
import rocks.zipcode.accessingdatamysql.FeedRepository;
import rocks.zipcode.accessingdatamysql.User;
import rocks.zipcode.accessingdatamysql.UserRepository;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
       private UserRepository userRepository;
    public UserController(UserRepository userRepository) {
            this.userRepository = userRepository;
      }
@Autowired
    private FeedRepository feedRepository;

    public UserController(FeedRepository feedRepository) {
           this.feedRepository = feedRepository;
    }
    @GetMapping
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    @PostMapping
    public User createUser (@RequestBody User user) {
        return userRepository.save(user);
    }

}




 //@PostMapping("/userId/feed/feedId")
  // public ResponseEntity<String> addFeedToUser(@PathVariable Integer userId, @PathVariable Integer feedId) {
    //  User.getFeeds().add(Feed);
//      userRepository.save(User);
//
//       return ResponseEntity.ok("Feed added to user");
//    }
//@GetMapping("/userId/feed")
//    public Set<Feed> getUserFeed(@PathVariable Integer userId) {
//       return User.getFeed();

//    @GetMapping("/{userId}")
//    public ResponseEntity<User>
//    getUser (@PathVariable Integer userId) {
//        // User user = UserRepository.findById(userId).orElseThrow();
//@PostMapping
//    public User saveUserWithFeed (@ResponseBody User user){
//return userRepository.save(user);