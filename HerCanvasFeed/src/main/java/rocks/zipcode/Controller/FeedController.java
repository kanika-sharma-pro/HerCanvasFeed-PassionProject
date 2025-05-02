package rocks.zipcode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocks.zipcode.accessingdatamysql.Feed;
import rocks.zipcode.accessingdatamysql.FeedRepository;
import java.util.Optional;

@Controller
//@RequestMapping("/api/Feed")
public class FeedController {

    FeedRepository feedRepository;

    @Autowired
    public FeedController(FeedRepository feedRepository) {

        this.feedRepository = feedRepository;
    }

    @PostMapping(value = "/feed")
    ResponseEntity<Feed> createFeed(@RequestBody Feed p) {
        return new ResponseEntity<>(feedRepository.save(p), HttpStatus.CREATED);
    }

    @GetMapping(value = "/feed/{ID}")
    ResponseEntity<Optional<Feed>> getFeed (@PathVariable int feedId) {
        return new ResponseEntity<>(feedRepository.findById(feedId), HttpStatus.OK);
    }

    @GetMapping(value ="/feed")
    ResponseEntity<Iterable<Feed>> getFeedList(){
        return new ResponseEntity<>(feedRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/feed/{id}")
    ResponseEntity<Feed> updateFeed (@PathVariable("id") @RequestBody Feed p){
        return new ResponseEntity<>(feedRepository.save(p), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/feed/{ID}")
    void deleteFeed(@PathVariable ("id") int feedId) {
        feedRepository.deleteById(feedId);
    }








}







    // @GetMapping
//    public Iterable<Feed> findAllFeeds() {
//
//        return feedRepository.findAll();
//    }
//    @GetMapping("/{feedId}")
//   public Optional<Feed> findFeed(@PathVariable Integer feedId) {
//       return feedRepository.findById(feedId);
//    }
//}


//List<Feed>
   // @GetMapping("/feedId")
    //       public List<Feed> findFeed(@PathVariable Integer feedId) {
    //       //return  feedRepository.findById(feedId).orElse(null);
    //       // return Feed.getFeedId();
    //        return List.of(feedId);
    //    }

