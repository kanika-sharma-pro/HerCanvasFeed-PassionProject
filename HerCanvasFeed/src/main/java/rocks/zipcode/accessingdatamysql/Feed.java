package rocks.zipcode.accessingdatamysql;

import jakarta.persistence.*;


@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedId;

    private String feedName;
    private String feedLink;
    private String title;
    private String description;

    //@ManyToMany(mappedBy = "feeds", fetch = FetchType.LAZY)
//    private Set<User> users = new HashSet<>();
    public Feed() {

    }

    public Feed(Integer feedId, String feedName, String feedLink, String title, String description) {
        this.feedId = feedId;
        this.feedName = feedName;
        this.feedLink = feedLink;
        this.title = title;
        this.description = description;
    }

    public Feed(String title, String description) {
        this.title = title;
        this.description = description;
    }


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}