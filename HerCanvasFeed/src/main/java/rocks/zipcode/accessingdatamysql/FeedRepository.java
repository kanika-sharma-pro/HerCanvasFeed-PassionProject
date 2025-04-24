package rocks.zipcode.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FeedRepository extends JpaRepository<Feed, Integer> {
}
