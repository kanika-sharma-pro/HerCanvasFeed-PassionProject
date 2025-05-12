package rocks.zipcode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocks.zipcode.accessingdatamysql.Feed;
import rocks.zipcode.accessingdatamysql.FeedRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {

    FeedRepository feedRepository;

    @Autowired
    public FeedController(FeedRepository feedRepository) {

        this.feedRepository = feedRepository;
    }

    @PostMapping(value = "/feeds")
    ResponseEntity<Feed> createFeed(@RequestBody Feed p) {
        return new ResponseEntity<>(feedRepository.save(p), HttpStatus.CREATED);
    }

    @GetMapping(value = "/feeds/{ID}")
    ResponseEntity<Optional<Feed>> getFeed (@PathVariable int feedId) {
        return new ResponseEntity<>(feedRepository.findById(feedId), HttpStatus.OK);
    }

    @GetMapping(value ="/feeds")
    ResponseEntity<Iterable<Feed>> getFeedList(){
        return new ResponseEntity<>(feedRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/feeds/{id}")
    ResponseEntity<Feed> updateFeed (@PathVariable("id") @RequestBody Feed p){
        return new ResponseEntity<>(feedRepository.save(p), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/feeds/{ID}")
    void deleteFeed(@PathVariable ("id") int feedId) {
        feedRepository.deleteById(feedId);
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Feed> getArticlesAsXml() {
        return List.of(
                new Feed("Java News", "Latest in Spring Boot & OpenAPI"),
        new Feed("Tech Tips", "RSS and XML with REST APIs")
        );
    }

    @GetMapping(value = "/rss", produces = MediaType.APPLICATION_XML_VALUE)
    public SyndFeed getRssFeed() {
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

        return feed;
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

