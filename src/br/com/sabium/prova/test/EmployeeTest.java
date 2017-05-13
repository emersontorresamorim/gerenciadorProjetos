package br.com.sabium.prova.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.sabium.prova.dao.EmployeeDao;
import br.com.sabium.prova.model.Employee;

public class EmployeeTest {

	@Test
	public void testSaveEmployee() {
		EmployeeDao employeeDao = new EmployeeDao();
		BigDecimal salary = new BigDecimal(4400.75);
		Employee employee = new Employee("Joana Santos", salary);
		employeeDao.save(employee);
		List<Employee> employees = employeeDao.findAll();
		Assert.assertNotNull(employees);
		Assert.assertFalse(employees.isEmpty());
		Assert.assertEquals("Joao Silva", employees.get(0).getName());
		Assert.assertEquals(salary, employees.get(0).getSalary());
	}
	
}
