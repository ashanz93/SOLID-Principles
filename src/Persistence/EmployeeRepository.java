package Persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import Personnel.Employee;
import Personnel.FullTimeEmployee;
import Personnel.PartTimeEmployee;
import Personnel.Subcontractor;

/*
Helper method to perform CRUD operations on employees. In a production
application we could use the database for persistence. In this demo,
we are storing employees in the file system.
 */

public class EmployeeRepository {
	private EmployeeFileSerializer serializer;

	public EmployeeRepository(EmployeeFileSerializer serializer) {
		this.serializer = serializer;
	}

	public List<Employee> findAll() {

		// Employees are kept in memory for simplicity
		Employee anna = new FullTimeEmployee("Anna Smith", 2000);
		Employee billy = new FullTimeEmployee("Billy Leech", 920);

		Employee steve = new PartTimeEmployee("Steve Jones", 800);
		Employee magda = new PartTimeEmployee("Magda Iovan", 920);

		Employee subcontractor = new Subcontractor("Rebekah Jackson", 3000);

		return Arrays.asList(anna, billy, steve, magda, subcontractor);
	}

	public void save(Employee employee) throws IOException {

		String serializedString = this.serializer.serialize(employee);

		Path path = Paths.get(employee.getFullName().replace(" ", "_") + ".rec");
		Files.write(path, serializedString.getBytes());

		System.out.println("Saved employee " + employee.toString());
	}
}
