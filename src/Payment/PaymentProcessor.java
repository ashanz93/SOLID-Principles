package Payment;

import java.util.List;

import Persistence.EmployeeFileRepository;
import Persistence.EmployeeFileSerializer;
import Personnel.Employee;

public class PaymentProcessor {

	private EmployeeFileRepository employeeRepository;

	public PaymentProcessor() {
		// Creation of dependencies done here
		EmployeeFileSerializer serializer = new EmployeeFileSerializer();
		this.employeeRepository = new EmployeeFileRepository(serializer);
	}

	public int sendPayments() {
		// Dependent on EmployeeRepository and EmailSender.
		List<Employee> employees = this.employeeRepository.findAll();
		int totalPayments = 0;

		for (Employee employee : employees) {
			totalPayments += employee.getMonthlyIncome();
			// Static method calls are sign of coupling
			// EmailSender.notify(employee);
		}

		return totalPayments;
	}
}
