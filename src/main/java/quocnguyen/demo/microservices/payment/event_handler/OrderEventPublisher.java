package quocnguyen.demo.microservices.payment.event_handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import quocnguyen.demo.microservices.payment.entity.PaymentTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventPublisher {

	private static final String TOPIC_EXCHANGE_NAME = "order";
	private static final String ORDER_RECEIVE_ROUTING_KEY = "order.received";

	private final RabbitTemplate rabbitTemplate;

	public void publishReceiving(PaymentTO paymentTO) {
		rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, ORDER_RECEIVE_ROUTING_KEY, paymentTO.getId());
		log.info("Order with id {} has been published", paymentTO.getId());
	}

}