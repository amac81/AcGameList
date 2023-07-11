package pt.bitclinic.AcGameList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class AcGameListApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcGameListApplication.class, args);
	}

}
