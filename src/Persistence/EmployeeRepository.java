package Persistence;

import java.io.IOException;
import java.util.List;

import Personnel.Employee;

public interface EmployeeRepository {
	List<Employee> findAll();

	void save(Employee employee) throws IOException;
}