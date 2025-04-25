package rocks.zipcode.accessingdatamysql;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Feed {
private String feedName;
private String feedLink;
private String title;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedId;

    @ManyToMany(mappedBy = "feeds", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();


//   @JoinTable (
//            name = "user_liked_feeds",
//              joinColumns = @JoinColumn(name = "user_id"),
//              inverseJoinColumns = @JoinColumn (name = "feed_id")
//       )


    public Feed(Integer feedId, String feedName, String feedLink, String title) {
        this.feedId = feedId;
        this.feedName = feedName;
        this.feedLink = feedLink;
        this.title = title;
    }

    //  public Feed(Set<User> users) {
    //        this.users = users;
    //    }
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsers() {

        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

   // @ManyToMany(mappedBy = "likedfeeds", fetch = FetchType.LAZY )
    //    private Set<User> likedByUser = new HashSet<>();

}


//@Column(name = "feed_Name")
//    private String feedName;
//
//    @Column (name = "feed_Link")
//    private String feedLink;
//
//    @Column (name = "feed_Title")
//    private String title;
//
//
//    @ManyToMany(mappedBy = "savedFeeds")
//    //@JoinTable (
//    //            name = "user_saved_feeds",
//    //            joinColumns = @JoinColumn(name = "user_id"),
//    //            inverseJoinColumns = @JoinColumn (name = "feed_id")
//    //    )
//    private Set<User> savedByUser = new HashSet<>();


