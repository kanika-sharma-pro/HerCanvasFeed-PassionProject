package rocks.zipcode.accessingdatamysql;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`app_user`")
public class AppUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;
    private String appUserName;
    private String appUserEmail;
    //private String password;

    public AppUser() {

    }
    public AppUser(String userName) {
        this.appUserName = userName;
    }
    public AppUser (Integer appUserId, String appUserName, String appUserEmail ) {
        this.appUserName = appUserName;
        this.appUserEmail = appUserEmail;
        this.appUserId = appUserId;
    }
    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer id) {
        this.appUserId = id;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public String getAppUserEmail() {
        return appUserEmail;
    }

    public void setAppUserEmail(String appUserEmail) {
        this.appUserEmail = appUserEmail;
    }

//@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//@JoinTable ( name = "User_feed", joinColumns = @JoinColumn (name = "User_id"),
//    inverseJoinColumns = @JoinColumn(name = "feed_id")
//)
//    private Set <Feed> feeds = new HashSet<>();
//    @Column(name = "User_Name")
//    private String userName;
//
//  @Column(name = "User_Email")
//   private String userEmail;
//
//  @Column(name = "User_Password")
//    private String password;



 // @ManyToMany
    //       @JoinTable (
    //             name = "user_liked_feeds",
    //             joinColumns = @JoinColumn(name = "user_id"),
    //             inverseJoinColumns = @JoinColumn (name = "feed_id")
    //      )
    //  private Set<Feed> likedFeeds = new HashSet<>();





        //this.password = password;
    //String password





    // Getters and Setters
    //public Set<Feed> getFeeds(){
    //    return feeds;
    //    }
    //
    //    public void setFeeds(Set<Feed> feeds) {
    //        this.feeds = feeds;
    //    }
    //
    //    public void addFeed (Feed feed){
    //    this.feeds.add(feed);
    //    //feed.getUsers().add(feed);
    //    }


    //public String getPassword() {
    //        return password;
    //    }
    //
    //    public void setPassword(String password) {
    //        this.password = password;
    //    }



    }


//

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


//
//    @ManyToMany(mappedBy = "savedByUser")
//    @JoinTable (
//            name = "user_saved_feeds",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn (name = "feed_id")
//    )
//    private Set<Feed> savedFeeds = new HashSet<>();
//public User(UserRepository userRepository, String userName) {
//    this.userRepository = userRepository; // constructor without id to create new users
//    this.userName = userName;
//}
//public User(UserRepository userRepository, Integer userId, String userName, String userEmail, String password) {
//    this.userRepository = userRepository;
//    this.userId = userId;
//        this.userName = userName;
//        this.userEmail = userEmail;
//this.password = password;
//    }
//public void UserController(UserRepository userRepository) {
//    this.userRepository = userRepository;
//}
//
//
//public User(UserRepository userRepository) {
//
//    this.userRepository = userRepository;
//}
//package rocks.zipcode.Controller;
//
