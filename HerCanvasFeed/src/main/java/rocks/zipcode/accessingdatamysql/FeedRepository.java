package rocks.zipcode.accessingdatamysql;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;


public interface FeedRepository extends JpaRepositoryImplementation<Feed, Integer> {
}
