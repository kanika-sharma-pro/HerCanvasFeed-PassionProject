package rocks.zipcode.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.accessingdatamysql.Feed;
import rocks.zipcode.accessingdatamysql.FeedRepository;
import rocks.zipcode.accessingdatamysql.User;
import rocks.zipcode.accessingdatamysql.UserRepository;
import rocks.zipcode.service.UserService;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("/User")
public class UserController {
    private UserRepository userRepository;
private FeedRepository feedRepository;
private UserService userService;

    @Autowired
  public UserController (UserRepository userRepository, FeedRepository feedRepository, UserService userService) {
        this.userRepository = userRepository;
        this.feedRepository = feedRepository;
        this.userService = userService;
    }

    @GetMapping("/tables")
    public List<String> getTables() {
        return userService.showTables();
    }


    @GetMapping("/AllUser")
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


//    private final UserRepository userRepository;
//    private final FeedRepository feedRepository;
//   private final UserService userService;

//   @Autowired
//   public UserController(UserRepository userRepository, FeedRepository feedRepository, UserService userService) {
//        this.userRepository = userRepository;
//        this.feedRepository = feedRepository;
//        this.userService = userService;
//    }

//    @GetMapping("/tables")
//    public List<String> getTables() {
//        return userService.showTables();
//    }

//    @GetMapping
//   public List<User> getAllUser() {
//       return userRepository.findAll();
//    }

//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userRepository.save(user);
//    }
//}