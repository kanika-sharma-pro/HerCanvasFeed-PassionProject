package rocks.zipcode.accessingdatamysql;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends JpaRepositoryImplementation<User, Integer> {

}
