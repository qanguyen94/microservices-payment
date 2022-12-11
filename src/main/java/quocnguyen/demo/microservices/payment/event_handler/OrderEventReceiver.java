package quocnguyen.demo.microservices.payment.event_handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderEventReceiver {

	public void onEvent(String orderId) {
		log.info("orderId {} received.", orderId);
	}

}