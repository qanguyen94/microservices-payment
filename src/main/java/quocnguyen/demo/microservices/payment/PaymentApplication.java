package quocnguyen.demo.microservices.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import quocnguyen.demo.microservices.payment.config.WebSecurityConfiguration;

@Import({WebSecurityConfiguration.class})
@SpringBootApplication
public class PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

}
