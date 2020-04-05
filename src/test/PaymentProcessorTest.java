package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Payment.PaymentProcessor;

public class PaymentProcessorTest {

	@Test
	public void send_payments_should_pay_all_employee_salaries() {
		// arrange
		PaymentProcessor paymentProcessor = new PaymentProcessor();

		// act
		int result = paymentProcessor.sendPayments();

		// assert
		assertEquals(5440, result);
	}
}