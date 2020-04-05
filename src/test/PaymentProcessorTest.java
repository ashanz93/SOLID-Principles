package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Notifications.EmployeeNotifier;
import Payment.PaymentProcessor;
import Persistence.EmployeeRepository;
import Personnel.Employee;
import Personnel.FullTimeEmployee;
import Personnel.Intern;
import Personnel.PartTimeEmployee;

public class PaymentProcessorTest {

	private EmployeeRepository employeeRepositoryMock;
	private EmployeeNotifier employeeNotifierMock;

	@BeforeAll
	public void beforeAll() {
		// Income of all employees is 1700 $
		List<Employee> testEmployees = Arrays.asList(new FullTimeEmployee("Anna Smith", 1000),
				new PartTimeEmployee("John Doe", 500), new Intern("Gabriel Ortega", 200, 10));

		employeeRepositoryMock = Mockito.mock(EmployeeRepository.class);
		Mockito.when(employeeRepositoryMock.findAll()).thenReturn(testEmployees);

		employeeNotifierMock = Mockito.mock(EmployeeNotifier.class);
	}

	@Test
	public void send_payments_should_pay_all_employee_salaries() {
		// wrong approach. mock dependencies.
		/*
		 * EmployeeFileSerializer serializer = new EmployeeFileSerializer();
		 * EmployeeRepository employeeRepository = new
		 * EmployeeFileRepository(serializer); EmployeeNotifier employeeNotifier = new
		 * EmailSender();
		 */
		// arrange
		PaymentProcessor paymentProcessor = new PaymentProcessor(employeeRepositoryMock, employeeNotifierMock);

		// act
		int result = paymentProcessor.sendPayments();

		// assert
		assertEquals(5440, result);
	}
}