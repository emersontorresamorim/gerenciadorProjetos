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

//	@Test
//	public void testFindEmployeesOnSeveralProjects() {
//		ProjectBusiness business = new ProjectBusiness();
//
//		ProjectDao projectDao = new ProjectDao();
//		Project project1 = new Project("Facebook ads");
//		projectDao.save(project1);
//
//		EmployeeDao employeeDao = new EmployeeDao();
//		Employee employee1 = new Employee("Claudia Silva", new BigDecimal(500.0));
//		Employee savedEmployee1 = employeeDao.save(employee1);
//
//		business.addEmployeeToProject(savedEmployee1.getId(), project1.getName());
//		
//		Project project2 = new Project("UX and UI");
//		projectDao.save(project2);
//		
//		Project project3 = new Project("Web Services");
//		projectDao.save(project3);
//		
//		Employee employee2 = new Employee("Luciana Borges", new BigDecimal(700.0));
//		Employee savedEmployee2 = employeeDao.save(employee2);
//		
//		business.addEmployeeToProject(savedEmployee2.getId(), project2.getName());
//		business.addEmployeeToProject(savedEmployee2.getId(), project3.getName());
//		
//		List<Employee> employees = employeeDao.findEmployeesOnSeveralProjects();
//		Assert.assertNotNull(employees);
//		Assert.assertFalse(employees.isEmpty());
//		Assert.assertEquals(savedEmployee2.getName(), employees.get(0).getName());
//	}

}
