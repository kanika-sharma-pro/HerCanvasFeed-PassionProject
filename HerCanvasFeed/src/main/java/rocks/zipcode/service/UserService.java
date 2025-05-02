package rocks.zipcode.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import rocks.zipcode.accessingdatamysql.User;
import rocks.zipcode.accessingdatamysql.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
        private UserRepository repository;
@Autowired
    public UserService(UserRepository repository){
    this.repository = repository;
}
public Iterable<User> index() {
    return repository.findAll();
}
    public User shhow (int userId) {
    return repository.findById(userId).get();
    }
        public User create(User user) {
    return repository.save(user);
        }
    public User update(int userId, User newUserData) {
    User originalUser = repository.findById(userId).get();
    originalUser.setUserName(newUserData.getUserName());
        originalUser.setUserId(newUserData.getUserId());
        originalUser.setUserEmail(newUserData.getUserName());
        return repository.save(originalUser);
    }
    public Boolean delete(int userId){
    repository.deleteById(userId);
    return true;
    }
    }


//   public List<String> showTables() {
//
//            return jdbcTemplate.queryForList("SHOW TABLES", String.class);
//        }
//    public Boolean delete(Long id) {
//        repository.deleteById(id);
//        return true;
//    }
//}