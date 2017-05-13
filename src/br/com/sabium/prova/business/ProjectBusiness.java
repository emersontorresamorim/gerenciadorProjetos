package br.com.sabium.prova.business;

import br.com.sabium.prova.dao.EmployeeDao;
import br.com.sabium.prova.dao.ProjectDao;
import br.com.sabium.prova.model.Employee;
import br.com.sabium.prova.model.Project;

public class ProjectBusiness {
	
	private ProjectDao projectDao = new ProjectDao();
	private EmployeeDao employeeDao = new EmployeeDao();
	
	public Project addEmployeeToProject(Long employeeId, String projectName) {
		Employee employee = employeeDao.findById(employeeId);
		Project project = projectDao.findProjectByName(projectName);
		if (project.getEmployees() != null && project.getEmployees().contains(employee)) {
			throw new IllegalArgumentException("The Employee already is part of the Project.");
		} else if (employee.getProjects() != null && employee.getProjects().size() == 2) {
			throw new IllegalArgumentException("The Employee already is part of 2 Projects.");
		} else {
			project.getEmployees().add(employee);
			return projectDao.update(project);
		}
	}

}
