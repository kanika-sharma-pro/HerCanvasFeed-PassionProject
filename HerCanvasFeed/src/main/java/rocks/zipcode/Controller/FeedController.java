package rocks.zipcode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocks.zipcode.accessingdatamysql.Feed;
import rocks.zipcode.accessingdatamysql.FeedRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/Feed")
public class FeedController {
    private FeedRepository feedRepository;
    @Autowired
    public FeedController(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }
    @GetMapping
    public List<Feed> findAllFeeds() {

        return feedRepository.findAll();
    }
    @GetMapping("/{feedId}")
   public Optional<Feed> findFeed(@PathVariable Integer feedId) {
       return feedRepository.findById(feedId);
    }
}


//List<Feed>
   // @GetMapping("/feedId")
    //       public List<Feed> findFeed(@PathVariable Integer feedId) {
    //       //return  feedRepository.findById(feedId).orElse(null);
    //       // return Feed.getFeedId();
    //        return List.of(feedId);
    //    }

