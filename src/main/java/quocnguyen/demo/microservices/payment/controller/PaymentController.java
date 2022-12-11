package quocnguyen.demo.microservices.payment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quocnguyen.demo.microservices.payment.entity.PaymentTO;
import quocnguyen.demo.microservices.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;

	@GetMapping
	public PaymentTO get(@RequestParam String orderId) {
		return paymentService.getByOrderId(orderId);
	}

	@PostMapping
	public String charge(@RequestBody PaymentTO paymentTO) {
		return paymentService.charge(paymentTO);
	}

}
