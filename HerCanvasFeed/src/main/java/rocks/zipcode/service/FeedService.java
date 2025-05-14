package rocks.zipcode.service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;
import rocks.zipcode.accessingdatamysql.Feed;

import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedService {
    private final String FEED_URL = "https://news.google.com/rss/search?q=women%27s+health+trends&hl=en-US&gl=US&ceid=US:en";


    public List<Feed> fetchFeeds(List<String> rssUrls) {
            List<Feed> feeds = new ArrayList<>();

            try {
                URL feedSource = new URL("https://news.google.com/rss/search?q=women%27s+health+trends&hl=en-US&gl=US&ceid=US:en");
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed syndFeed = input.build(new XmlReader(feedSource));

                for (SyndEntry entry : syndFeed.getEntries()) {
                    Feed feed = new Feed();
                    feed.setTitle(entry.getTitle());
                    feed.setFeedLink(entry.getLink());
                    feed.setDescription(entry.getDescription() != null ? entry.getDescription().getValue() : "");
                    feed.setAuthor(entry.getAuthor());
                    if (entry.getPublishedDate() != null) {
                        feed.setPublishedDate(entry.getPublishedDate().toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDateTime());
                    }
                    feeds.add(feed);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return feeds;
        }

    }


// public List<SyndEntry> fetchFeed(String feedUrl) {
//        try {
//            URL url = new URL(feedUrl);
//            SyndFeedInput input = new SyndFeedInput();
//            SyndFeed feed = input.build(new XmlReader(url));
//            return feed.getEntries();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//    }
//
//
//    public List<SyndEntry> fetchMultipleFeeds(List<String> rssUrls) {
//        List<SyndEntry> allEntries = new ArrayList<>();
//        for (String url : feedUrls) {
//            allEntries.addAll(fetchFeed(url));
//        }
//        return allEntries;
//    }
//    }




