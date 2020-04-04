package Main;

import java.util.List;

import Logging.ConsoleLogger;
import Persistence.EmployeeFileSerializer;
import Persistence.EmployeeRepository;
import Personnel.Employee;
import Personnel.ServiceLicenseAgreement;
import Personnel.Subcontractor;

public class ApproveSLAMain {
	public static void main(String[] args) {
		// Create dependencies
		ConsoleLogger consoleLogger = new ConsoleLogger();
		EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
		EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

		// Define SLA
		int minTimeOffPercent = 98;
		int maxResolutionDays = 2;
		ServiceLicenseAgreement companySla = new ServiceLicenseAgreement(minTimeOffPercent, maxResolutionDays);

		// Grab subcontractors
		List<Employee> subcontractors = repository.findAll();

		// Employee not substitutable by Subcontractor.Type checking
		for (Employee e : subcontractors) {
			if (e instanceof Subcontractor) {
				Subcontractor s = (Subcontractor) e;
				s.approveSLA(companySla);
			}
		}
	}
}
