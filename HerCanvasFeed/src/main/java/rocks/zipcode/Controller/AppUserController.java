package rocks.zipcode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import rocks.zipcode.accessingdatamysql.Feed;
//import rocks.zipcode.accessingdatamysql.FeedRepository;
import rocks.zipcode.accessingdatamysql.AppUser;

import rocks.zipcode.accessingdatamysql.AppUserRepository;
//import rocks.zipcode.accessingdatamysql.UserRepository;

import java.util.Optional;
//import rocks.zipcode.service.UserService;
//import java.util.List;
//import java.util.Set;
//import org.springframework.beans.factory.annotation.Autowired;


@Controller
//@RequestMapping("/api/users")
public class AppUserController {

    AppUserRepository appUserRepository;
    @Autowired
    public  AppUserController(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @PostMapping(value = "/appuser")
    ResponseEntity<AppUser> createAppUser(@RequestBody AppUser p) {
        return new ResponseEntity<>(appUserRepository.save(p), HttpStatus.CREATED);
    }
    @GetMapping(value = "/appuser/{ID}")
    ResponseEntity<Optional<AppUser>> getAppUser (@PathVariable int appUserId) {
        return new ResponseEntity<>(appUserRepository.findById(appUserId), HttpStatus.OK);
    }

    @GetMapping(value ="/appuser")
    ResponseEntity<Iterable<AppUser>> getAppUserList(){
        return new ResponseEntity<>(appUserRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/appuser/{id}")
    ResponseEntity<AppUser> updateAppUser (@PathVariable("id") @RequestBody AppUser p){
        return new ResponseEntity<>(appUserRepository.save(p), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/appuser/{ID}")
    void deleteAppUser(@PathVariable ("id") int appUserId) {
        appUserRepository.deleteById(appUserId);
    }

}


//private FeedRepository feedRepository;
//private UserService userService;

//    @Autowired
//    public UserController(UserRepository userRepository, FeedRepository feedRepository, UserService userService) {
//        this.userRepository = userRepository;
//        this.feedRepository = feedRepository;
//        this.userService = userService;
//    }

// @GetMapping("/tables")
//    public List<String> getTables() {
//
//        return userService.showTables();
//    }

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