package rocks.zipcode.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocks.zipcode.accessingdatamysql.FeedRepository;

@RestController
@RequestMapping("/api/Feed")
public class FeedController {
    public FeedController(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    private FeedRepository feedRepository;




}
