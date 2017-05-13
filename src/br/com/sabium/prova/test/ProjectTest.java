package br.com.sabium.prova.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.sabium.prova.business.ProjectBusiness;
import br.com.sabium.prova.dao.EmployeeDao;
import br.com.sabium.prova.dao.ProjectDao;
import br.com.sabium.prova.model.Employee;
import br.com.sabium.prova.model.Project;

public class ProjectTest {
	
	@Test
	public void testSaveProject() {
		ProjectDao projectDao = new ProjectDao();
		Project project = new Project("NF-e");
		projectDao.save(project);
		List<Project> projects = projectDao.findAll();
		Assert.assertNotNull(projects);
		Assert.assertFalse(projects.isEmpty());
		Assert.assertEquals(project.getName(), projects.get(0).getName());
	}

	@Test
	public void testAddEmployeeToProject() {
		ProjectBusiness business = new ProjectBusiness();
		
		ProjectDao projectDao = new ProjectDao();
		Project project = new Project("E-commerce");
		projectDao.save(project);
		
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = new Employee("Maria Aparecida", new BigDecimal(2000.50));
		Employee savedEmployee = employeeDao.save(employee);
		
		Project updatedProject = business.addEmployeeToProject(savedEmployee.getId(), project.getName());
		Assert.assertNotNull(updatedProject);
		Assert.assertEquals(project.getName(), updatedProject.getName());
	}
	
	@Test
	public void testAddEmployeeToProjects() {
		ProjectBusiness business = new ProjectBusiness();
		
		ProjectDao projectDao = new ProjectDao();
		Project project1 = new Project("MacOS software");
		projectDao.save(project1);
		
		Project project2 = new Project("Linux software");
		projectDao.save(project2);
		
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = new Employee("Bruna Almeida", new BigDecimal(3280));
		Employee savedEmployee = employeeDao.save(employee);
		
		Project updatedProject1 = business.addEmployeeToProject(savedEmployee.getId(), project1.getName());
		Assert.assertNotNull(updatedProject1);
		Assert.assertEquals(project1.getName(), updatedProject1.getName());
		
		Project updatedProject2 = business.addEmployeeToProject(savedEmployee.getId(), project2.getName());
		Assert.assertNotNull(updatedProject2);
		Assert.assertEquals(project2.getName(), updatedProject2.getName());
	}
	
//	@Test
//	public void testAddEmployeeBeyondMaxProjectLimit() {
//		ProjectBusiness business = new ProjectBusiness();
//		
//		ProjectDao projectDao = new ProjectDao();
//		Project project1 = new Project("iOS Mobile App");
//		projectDao.save(project1);
//		
//		Project project2 = new Project("Android Mobile App");
//		projectDao.save(project2);
//		
//		Project project3 = new Project("Windows Mobile App");
//		projectDao.save(project3);
//		
//		EmployeeDao employeeDao = new EmployeeDao();
//		Employee employee = new Employee("Jessica Souza", new BigDecimal(1999.99));
//		Employee savedEmployee = employeeDao.save(employee);
//		
//		Project updatedProject1 = null;
//		Project updatedProject2 = null;
//		Project updatedProject3 = null;
//		try {
//			updatedProject1 = business.addEmployeeToProject(savedEmployee.getId(), project1.getName());
//			Assert.assertNotNull(updatedProject1);
//			Assert.assertEquals(project1.getName(), updatedProject1.getName());
//			
//			updatedProject2 = business.addEmployeeToProject(savedEmployee.getId(), project2.getName());
//			Assert.assertNotNull(updatedProject2);
//			Assert.assertEquals(project2.getName(), updatedProject2.getName());
//			
//			updatedProject3 = business.addEmployeeToProject(savedEmployee.getId(), project3.getName());
//			Assert.assertNotNull(updatedProject3);
//			Assert.assertEquals(project3.getName(), updatedProject3.getName());
//		} catch (IllegalArgumentException e) {
//			Assert.fail(e.getMessage());
//		}
//	}
	
}
