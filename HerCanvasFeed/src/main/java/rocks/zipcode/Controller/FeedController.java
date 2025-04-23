package rocks.zipcode.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocks.zipcode.accessingdatamysql.Feed;
import rocks.zipcode.accessingdatamysql.FeedRepository;

import java.util.List;

@RestController
@RequestMapping("/api/Feed")
public class FeedController {
    public FeedController(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    private FeedRepository feedRepository;

@GetMapping
    public List<Feed> findAllFeeds (){

        return feedRepository.findAll();
    }
//List<Feed>
   // @GetMapping("/feedId")
    //    public List<Feed> findFeed(@PathVariable Integer feedId) {
    //    return  feedRepository.findById(feedId).orElse(null);
    //    }
}
