package rocks.zipcode.accessingdatamysql;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
//@BeforeAll
//        public static void init() {
//     user = new User();
//
//}


    @Test
    void getuserId() {
        User user = new User();
        user.setUserId (101);
assertEquals(101, user.getUserId(),"Your UserId number" );
    }

    @Test
    void setId() {

    }

    @Test
    void getUserName() {
        User user = new User();
user.setUserName("Jane Frost");
assertEquals("Jane Frost", user.getUserName(), "Your User name" );
    }

    @Test
    void setUserName() {

    }

    @Test
    void getUserEmail() {
        User user = new User();
        user.setUserEmail("JaneFrost@gmail.com");
        assertEquals("JaneFrost@gmail.com", user.getUserEmail(), "Your User Email" );

    }

    @Test
    void setUserEmail() {

    }

   // @Test
    //    void getFirstName() {
    //        User user = new User();
    //        user.setFirstName("Jane");
    //        assertEquals("Jane", user.getFirstName(), "Your first name" );


    }

   // @Test
//    void setFirstName() {
//
//    }
//
//    @Test
//    void getLastName() {
//        User user = new User();
//        user.setLastName("Jane");
//        assertEquals("Jane", user.getLastName(), "Your last name" );
//
   // }//
//
//@Test
//void setLastName() {
//}
//}