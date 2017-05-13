package br.com.sabium.prova.dao;

import java.util.List;

import br.com.sabium.prova.model.Employee;
import br.com.sabium.prova.util.JPAUtil;

public class EmployeeDao extends JPAUtil {
	
	public void save(Employee employee) {
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
	}
	
	public List<Employee> findAll() {
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	
}
