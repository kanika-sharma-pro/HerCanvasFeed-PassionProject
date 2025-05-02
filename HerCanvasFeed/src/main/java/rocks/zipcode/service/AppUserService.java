package rocks.zipcode.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import rocks.zipcode.accessingdatamysql.AppUser;
import rocks.zipcode.accessingdatamysql.AppUserRepository;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
        private AppUserRepository repository;
@Autowired
    public AppUserService(AppUserRepository repository){
    this.repository = repository;
}
public Iterable<AppUser> index() {
    return repository.findAll();
}
    public AppUser show (int userId) {
    return repository.findById(userId).get();
    }
        public AppUser create(AppUser user) {
    return repository.save(user);
        }
    public AppUser update(int userId, AppUser newUserData) {
        AppUser originalUser = repository.findById(userId).get();
    originalUser.setAppUserName(newUserData.getAppUserName());
        originalUser.setAppUserId(newUserData.getAppUserId());
        originalUser.setAppUserEmail(newUserData.getAppUserName());
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