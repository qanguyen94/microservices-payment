package quocnguyen.demo.microservices.payment.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import quocnguyen.demo.microservices.payment.type.PaymentStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PaymentTO {
	private String id;
	private String orderId;
	private BigDecimal payedAmount;
	private String currency;
	private PaymentStatus paymentStatus;
	private LocalDateTime payedOn;
}
