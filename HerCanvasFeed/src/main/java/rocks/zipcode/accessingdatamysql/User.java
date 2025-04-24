package rocks.zipcode.accessingdatamysql;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String userEmail;
    private String password;

@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable ( name = "user_feed", joinColumns = @JoinColumn (name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "feed_id")
)
    private Set <Feed> feeds = new HashSet<>();

public User(String userName) { // constructor without id to create new users
    this.userName = userName;
}
public User(Integer userId, String userName, String userEmail, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
this.password = password;
    }




    public User() {

    }

    //public static String getFeeds() {
       // String Feeds;
       // return Feeds;
   // }

    // Getters and Setters
    public Set<Feed> getFeeds(){
    return feeds;
    }

    public void setFeeds(Set<Feed> feeds) {
        this.feeds = feeds;
    }

    public void addFeed (Feed feed){
    this.feeds.add(feed);
    feed.getUsers().add(feed);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    }


//
//public void addFeed(Feed feed) {
//    this.feeds.add(feed);
//    feed.getUsers().add(this);
//}
//
//public void removeFeed(Feed feed) {
//    this.feeds.remove(feed);
//    feed.getUsers().remove(this);
//}

// @Column(name = "user_Name")
//    private String userName;
//
//    @Column(name = "user_Email")
//    private String userEmail;
//
//    @Column(name = "first_Name")
//    private String firstName;
//
//    @Column(name = "last_Name")
//    private String lastName;

// private String firstName;
//    private String lastName;
//public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//this.firstName = firstName;
//        this.lastName = lastName;


//@ManyToMany(mappedBy = "likedByUser")
//    @JoinTable (
//            name = "user_liked_feeds",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn (name = "feed_id")
//    )
//    private Set<Feed> likedFeeds = new HashSet<>();
//
//    @ManyToMany(mappedBy = "savedByUser")
//    @JoinTable (
//            name = "user_saved_feeds",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn (name = "feed_id")
//    )
//    private Set<Feed> savedFeeds = new HashSet<>();