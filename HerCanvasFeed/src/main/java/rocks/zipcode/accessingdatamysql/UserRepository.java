package rocks.zipcode.accessingdatamysql;
import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

}
