package AMSS.ProiectAMSS_HeapOverflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ProiectAmssHeapOverflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProiectAmssHeapOverflowApplication.class, args);
	}

}
