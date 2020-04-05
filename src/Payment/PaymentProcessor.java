package Payment;

import java.util.List;

import Notifications.EmployeeNotifier;
import Persistence.EmployeeRepository;
import Personnel.Employee;

public class PaymentProcessor {

	private EmployeeRepository employeeRepository;
	private EmployeeNotifier employeeNotifier;

	// EmployeeRepository can be file, sql etc. EmployeeNotifier can be email,
	// slack, sms etc.
	public PaymentProcessor(EmployeeRepository employeeRepository, EmployeeNotifier employeeNotifier) {
		// Inject Dependencies
		this.employeeRepository = employeeRepository;
		this.employeeNotifier = employeeNotifier;
	}

	public int sendPayments() {
		// Dependent on EmployeeRepository and EmailSender.
		List<Employee> employees = this.employeeRepository.findAll();
		int totalPayments = 0;

		for (Employee employee : employees) {
			totalPayments += employee.getMonthlyIncome();
			this.employeeNotifier.notify(employee);
		}

		return totalPayments;
	}
}
