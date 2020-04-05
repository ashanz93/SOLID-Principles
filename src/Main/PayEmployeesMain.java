package Main;

import Notifications.EmailSender;
import Notifications.EmployeeNotifier;
import Payment.PaymentProcessor;
import Persistence.EmployeeFileRepository;
import Persistence.EmployeeFileSerializer;
import Persistence.EmployeeRepository;

public class PayEmployeesMain {

	/*
	 * Will take a couple of seconds to execute due to the sending of mails.
	 */

	public static void main(String[] args) {

		EmployeeFileSerializer serializer = new EmployeeFileSerializer();
		EmployeeRepository employeeRepository = new EmployeeFileRepository(serializer);
		EmployeeNotifier employeeNotifier = new EmailSender();
		PaymentProcessor paymentProcessor = new PaymentProcessor(employeeRepository, employeeNotifier);

		int totalPayments = paymentProcessor.sendPayments();
		System.out.println("Total payments " + totalPayments);
	}
}