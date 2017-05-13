package br.com.sabium.prova.dao;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sabium.prova.model.Employee;

public class EmployeeDao extends GenericDao<Employee, Long> {

	public EmployeeDao() {
		super(Employee.class);
	}
	
	public List<Employee> findEmployeesOnSeveralProjects() {
		List<Employee> employees = findAll();
		List<Employee> filteredList = employees.stream()
				 .filter(e -> e.getProjects().size() > 1)
				 .collect(Collectors.toList());
		return filteredList;
	}
	
}
