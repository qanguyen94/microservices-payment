package quocnguyen.demo.microservices.payment.repository;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import quocnguyen.demo.microservices.payment.entity.PaymentTO;
import quocnguyen.demo.microservices.payment.exception.NotFoundException;
import quocnguyen.demo.microservices.payment.type.PaymentStatus;

@Repository
public class PaymentRepository {

	private int currentId = 1;
	private final Map<String, PaymentTO> repository = new HashMap<>();

	public PaymentRepository() {
		for (; currentId <= 5; currentId++) {
			PaymentTO initialPayment = createInitialPayment(currentId);
			repository.put(initialPayment.getId(), initialPayment);
		}
	}

	public String create(PaymentTO paymentTO) {
		currentId++;
		String paymentId = "payment-" + currentId;
		paymentTO.setId(paymentId);
		repository.put(paymentId, paymentTO);
		return paymentId;
	}

	public PaymentTO getByOrderId(String orderId) {
		return repository.keySet()
				.stream()
				.map(repository::get)
				.filter(paymentTO -> paymentTO.getOrderId().equals(orderId))
				.findFirst()
				.orElseGet(() -> createDummyPayment(orderId));
	}

	private PaymentTO createInitialPayment(int currentId) {
		return PaymentTO.builder()
				.id("payment-" + currentId)
				.orderId("order-" + currentId)
				.payedAmount(BigDecimal.valueOf(100L * currentId))
				.currency("VND")
				.paymentStatus(PaymentStatus.PAID)
				.payedOn(LocalDateTime.now())
				.build();
	}

	private PaymentTO createDummyPayment(String orderId) {
		return PaymentTO.builder()
				.id("payment-" + currentId)
				.orderId(orderId)
				.payedAmount(BigDecimal.valueOf(100L * currentId))
				.currency("VND")
				.paymentStatus(PaymentStatus.PAID)
				.payedOn(LocalDateTime.now())
				.build();
	}

}
