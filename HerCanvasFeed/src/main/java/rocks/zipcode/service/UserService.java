package rocks.zipcode.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
        private JdbcTemplate jdbcTemplate;

        public List<String> showTables() {

            return jdbcTemplate.queryForList("SHOW TABLES", String.class);
        }
    }

