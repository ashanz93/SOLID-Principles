package Main;

import java.io.IOException;
import java.util.List;

import Logging.ConsoleLogger;
import Persistence.EmployeeFileRepository;
import Persistence.EmployeeFileSerializer;
import Personnel.Employee;

public class SaveEmployeesMain {
	public static void main(String[] args) {
		// Grab employees
		EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
		ConsoleLogger consoleLogger = new ConsoleLogger();

		EmployeeFileRepository repository = new EmployeeFileRepository(employeeFileSerializer);
		List<Employee> employees = repository.findAll();

		// Save all
		for (Employee e : employees) {
			try {
				repository.save(e);
				consoleLogger.writeInfo("saved Employee" + e.toString());
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				consoleLogger.writeError("Error saving Employee", ex);
			}
		}
	}
}