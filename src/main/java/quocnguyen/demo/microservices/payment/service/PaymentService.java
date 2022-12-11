package quocnguyen.demo.microservices.payment.service;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quocnguyen.demo.microservices.payment.entity.PaymentTO;
import quocnguyen.demo.microservices.payment.repository.PaymentRepository;
import quocnguyen.demo.microservices.payment.type.PaymentStatus;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentRepository paymentRepository;

	public synchronized String charge(PaymentTO paymentTO) {
		// Making the charge method run a little bit slow for demo purpose
		sleepFor2Second();
		paymentTO.setPaymentStatus(PaymentStatus.PAID);
		paymentTO.setPayedOn(LocalDateTime.now());
		return paymentRepository.create(paymentTO);
	}

	private void sleepFor2Second() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public PaymentTO getByOrderId(String orderId) {
		return paymentRepository.getByOrderId(orderId);
	}
}
