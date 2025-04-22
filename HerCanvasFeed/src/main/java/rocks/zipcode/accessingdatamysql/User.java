package rocks.zipcode.accessingdatamysql;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;



    @ManyToMany //(mappedBy = "likedFeeds")
    @JoinTable (
            name = "feed_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "feed_id")
    )
    Set<Feed> savedFeed = new HashSet<>();
    @Column(name = "user_Name")
    private String userName;

    @Column(name = "user_Email")
    private String userEmail;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    public User(Integer userId, String userName, String userEmail, String firstName, String lastName) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public User() {

    }

    // Getters and Setters
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}