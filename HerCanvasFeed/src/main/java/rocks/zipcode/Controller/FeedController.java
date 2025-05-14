package rocks.zipcode.Controller;

import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocks.zipcode.accessingdatamysql.Feed;
import rocks.zipcode.accessingdatamysql.FeedRepository;
import rocks.zipcode.service.FeedService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {


    FeedRepository feedRepository;
    private final FeedService feedService;

    @Autowired
    public FeedController(FeedRepository feedRepository, FeedService feedService) {

        this.feedRepository = feedRepository;
        this.feedService = feedService;
    }

    @PostMapping(value = "/feeds")
    ResponseEntity<Feed> createFeed(@RequestBody Feed p) {
        return new ResponseEntity<>(feedRepository.save(p), HttpStatus.CREATED);
    }

    @GetMapping(value = "/feeds/{id}")
    ResponseEntity<Optional<Feed>> getFeed(@PathVariable("id") int feedId) {
        return new ResponseEntity<>(feedRepository.findById(feedId), HttpStatus.OK);
    }

    @GetMapping(value = "/feeds")
    ResponseEntity<Iterable<Feed>> getFeedList() {
        return new ResponseEntity<>(feedRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/feeds/{id}")
    ResponseEntity<Feed> updateFeed(@PathVariable("id") @RequestBody Feed p) {
        return new ResponseEntity<>(feedRepository.save(p), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/feeds/{id}")
    void deleteFeed(@PathVariable("id") int feedId) {
        feedRepository.deleteById(feedId);
    }

   // @GetMapping("/")
    //    public String index(Model model) {
    //        List<Feed> feeds = feedService.fetchFeeds();
    //        model.addAttribute("feeds", feeds);
    //        return "index";
    //    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<Feed>> getArticlesAsXml() {
        List<String> rssUrls = List.of(
                "https://news.google.com/rss/search?q=women%27s+health+trends&hl=en-US&gl=US&ceid=US:en",
                "https://rss.nytimes.com/services/xml/rss/nyt/Health.xml"
        );
        List<Feed> feeds = feedService.fetchFeeds(rssUrls);
        return ResponseEntity.ok(feeds);
    }
   // @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    //    public List<Feed> getArticlesAsXml() {
    //        return List.of(
    //                new Feed(null, "Java News", "http://example.com", "Latest in Spring Boot & OpenAPI", "It works"),
    //                new Feed("Tech Tips", "RSS and XML with REST APIs")
    //        );


    @GetMapping(value = "/rss", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getRssFeed() throws FeedException {
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_2.0");
        feed.setTitle("Feed Aggregator");
        feed.setLink("http://localhost:8080/api/feeds/rss");
        feed.setDescription("RSS feed of latest tech updates");

        List<SyndEntry> entries = new ArrayList<>();

        SyndEntry entry = new SyndEntryImpl();
        entry.setTitle("Spring Boot RSS");
        entry.setLink("http://example.com/spring-boot-rss");
        entry.setPublishedDate(new Date());

        SyndContent description = new SyndContentImpl();
        description.setType("text/plain");
        description.setValue("Learn to serve RSS in Spring Boot using OpenAPI.");
        entry.setDescription(description);

        entries.add(entry);
        feed.setEntries(entries);

        SyndFeedOutput output = new SyndFeedOutput();
        String rssOutput = output.outputString(feed);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(rssOutput);
    }
}
   // } catch (com.rometools.rome.io.FeedException e)
        //
        //    {
        //        e.printStackTrace();
        //        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        //                .body("<error>Could not generate RSS feed: FeedException</error>");
        //
        //    } catch (Exception e) {
        //        e.printStackTrace();
        //        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        //                .body("<error>Could not generate RSS feed</error>");
        //    }
        //}














// @GetMapping
// public Iterable<Feed> findAllFeeds() {
//
// return feedRepository.findAll();
// }
// @GetMapping("/{feedId}")
// public Optional<Feed> findFeed(@PathVariable Integer feedId) {
// return feedRepository.findById(feedId);
// }
//}


//List<Feed>
// @GetMapping("/feedId")
// public List<Feed> findFeed(@PathVariable Integer feedId) {
// //return feedRepository.findById(feedId).orElse(null);
// // return Feed.getFeedId();
// return List.of(feedId);
// }
