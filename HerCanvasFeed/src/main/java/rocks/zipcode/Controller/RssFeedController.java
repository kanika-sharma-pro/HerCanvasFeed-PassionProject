package rocks.zipcode.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rss")
@CrossOrigin(origins = "*") //allows frontend to comment
public class RssFeedController {

@GetMapping("/women-health")
    public List<Map<String,String>> getWomenHealthNews() {

    String rssUrl = "https://news.google.com/rss/search?q=women%27s+health+trends&hl=en-US&gl=US&ceid=US:en";
    List<Map<String, String>> articles = new ArrayList<>();

    try {
        URL url = new URL(rssUrl);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(url));
        for (SyndEntry entry : feed.getEntries()) {
            Map<String, String> item = new HashMap<>();
            item.put("title", entry.getTitle());
            item.put("link", entry.getLink());
            item.put("description", entry.getDescription() != null ? entry.getDescription().getValue() : "");
            articles.add(item);
        }
    }catch (Exception e) {
        e.printStackTrace();
    }
    return articles;
}

}
