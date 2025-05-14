package rocks.zipcode.Controller;

import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rocks.zipcode.accessingdatamysql.Feed;
import rocks.zipcode.service.FeedService;

import java.util.List;

@Controller
public class HomeController {
    private final FeedService feedService;

    @Autowired
    public HomeController(FeedService feedService) {
        this.feedService = feedService;
    }
@GetMapping("/")
    public String homePage(Model model) {
    List<String> rssUrls = List.of(
            "https://news.google.com/rss/search?q=women%27s+health+trends&hl=en-US&gl=US&ceid=US:en",
            "https://rss.nytimes.com/services/xml/rss/nyt/Health.xml"
    );
    List<Feed> feeds = feedService.fetchFeeds(rssUrls);
    System.out.println("Fetched articles count: " + feeds.size());
    model.addAttribute("feeds", feeds);
    return "Home";
}






}
