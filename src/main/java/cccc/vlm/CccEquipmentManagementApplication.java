package cccc.vlm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CccEquipmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CccEquipmentManagementApplication.class, args);
    }

}
