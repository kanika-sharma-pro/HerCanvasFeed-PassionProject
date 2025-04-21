package rocks.zipcode.accessingdatamysql;
import jakarta.persistence.*;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//@Entity
public class User {
    //@Id
   // @GeneratedValue(strategy=GenerationType.AUTO);
        private String userName;
        private String userEmail;
    private Integer userId;
    private String firstName;
    private String lastName;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer id) {
        this.userId = id;
    }



        //@Column(name = "first_name")


       // @Column(name = "last_name")



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



















