package Main;

import java.util.List;

import Logging.ConsoleLogger;
import Persistence.EmployeeFileSerializer;
import Persistence.EmployeeRepository;
import Personnel.Employee;
import Personnel.FullTimeEmployee;

public class NatHolidayEmployeeTimeOffMain {

	public static void main(String[] args) {
		// Create dependencies
		ConsoleLogger consoleLogger = new ConsoleLogger();
		EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
		EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

		// Grab employees
		List<Employee> employees = repository.findAll();
		Employee manager = new FullTimeEmployee("Steve Jackson", 5000);

		// Request time off for each employee on
		// national holiday

		// Exception thrown for subcontractor as sc can't take timeoff.
		for (Employee employee : employees) {
			employee.requestTimeOff(1, manager);
		}
	}

}
