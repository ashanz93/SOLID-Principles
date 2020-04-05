package Main;

import java.time.Month;
import java.util.List;

import Documents.Payslip;
import Logging.ConsoleLogger;
import Persistence.EmployeeFileSerializer;
import Persistence.EmployeeRepository;
import Personnel.Employee;

public class ExportPayslipMain {
	public static void main(String[] args) {
		// Create dependencies
		ConsoleLogger consoleLogger = new ConsoleLogger();
		EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
		EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

		// Grab employees
		List<Employee> employees = repository.findAll();

		for (Employee employee : employees) {
			Payslip payslip = new Payslip(employee, Month.AUGUST);

			byte[] exportablePdf = payslip.toPdf();
			System.out.println(exportablePdf);
		}
	}
}
