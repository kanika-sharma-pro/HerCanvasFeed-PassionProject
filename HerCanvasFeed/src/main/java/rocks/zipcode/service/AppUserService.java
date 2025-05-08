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
    public AppUser show (int appUserId) {
    return repository.findById(appUserId).get();
    }
        public AppUser create(AppUser appUser) {
    return repository.save(appUser);
        }
    public AppUser update(int appUserId, AppUser newAppUserData) {
        AppUser originalAppUser = repository.findById(appUserId).get();
        originalAppUser.setAppUserName(newAppUserData.getAppUserName());
        originalAppUser.setAppUserId(newAppUserData.getAppUserId());
        originalAppUser.setAppUserEmail(newAppUserData.getAppUserName());
        return repository.save(originalAppUser);
    }
    public Boolean delete(int appUserId){
    repository.deleteById(appUserId);
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