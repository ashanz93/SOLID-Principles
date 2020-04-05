package Main;

import java.time.Month;
import java.util.List;

import Documents.Payslip;
import Logging.ConsoleLogger;
import Persistence.EmployeeFileRepository;
import Persistence.EmployeeFileSerializer;
import Personnel.Employee;

public class ExportPayslipMain {
	public static void main(String[] args) {
		// Create dependencies
		ConsoleLogger consoleLogger = new ConsoleLogger();
		EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
		EmployeeFileRepository repository = new EmployeeFileRepository(employeeFileSerializer);

		// Grab employees
		List<Employee> employees = repository.findAll();

		for (Employee employee : employees) {
			Payslip payslip = new Payslip(employee, Month.AUGUST);

			String exportableText = payslip.toTxt();
			System.out.println(exportableText);
		}
	}
}
