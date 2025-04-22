package rocks.zipcode.accessingdatamysql;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Feed {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedId;

    @ManyToMany
    @JoinTable (
            name = "user_like",
            joinColumns = @JoinColumn(name = "feed_id"),
            inverseJoinColumns = @JoinColumn (name = "user_feed")
    )

    Set<User> user = new HashSet<>();

    @Column(name = "feed_Name")
    private String feedName;

    @Column (name = "feed_link")
private String feedLink;


    public Feed(Integer feedId, String feedName, String feedLink) {
        this.feedId = feedId;
        this.feedName = feedName;
        this.feedLink = feedLink;
    }

    // Getters and Setters
    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    public String getFeedLink() {
        return feedLink;
    }

    public void setFeedLink(String feedLink) {
        this.feedLink = feedLink;
    }
    public Integer getFeedId() {
        return feedId;
    }

    public void setFeedId(Integer id) {
        this.feedId = id;
    }


    }




