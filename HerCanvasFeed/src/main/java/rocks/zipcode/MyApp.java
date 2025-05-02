package rocks.zipcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "rocks.zipcode.accessingdatamysql")
public class MyApp {

    public static void main(String[] args) {
            SpringApplication.run(MyApp.class, args);
        }

    }

