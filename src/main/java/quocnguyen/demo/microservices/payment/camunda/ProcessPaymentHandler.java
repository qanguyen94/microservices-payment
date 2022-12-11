package quocnguyen.demo.microservices.payment.camunda;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

@Slf4j
@ExternalTaskSubscription("ProcessPayment") // create a subscription for this topic name
public class ProcessPaymentHandler implements ExternalTaskHandler {

	@SneakyThrows
	@Override
	public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

		String orderId = externalTask.getVariable("orderId");
		log.info("Start processing payment for order with id {}", orderId);

		VariableMap variables = Variables.createVariables();
		variables.put("orderId", orderId);
		variables.put("status", "successful");

		// To be able to see the process running in Camunda. Let make the process stay here for a while
		Thread.sleep(5000);

		// complete the external task
		externalTaskService.complete(externalTask, variables);
		log.info("Payment charge for order with id {} has been processed successfully", orderId);
	}

}
