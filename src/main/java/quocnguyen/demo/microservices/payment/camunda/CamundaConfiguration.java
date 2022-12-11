package quocnguyen.demo.microservices.payment.camunda;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
@Profile("camunda") // Beans initialized in this class are available only when this profile is active
public class CamundaConfiguration {

	@PostConstruct
	void init() {
		log.info("Service is running with Camunda integration");
	}

	@Bean
	ProcessPaymentHandler processPaymentHandler() {
		return new ProcessPaymentHandler();
	}

}
