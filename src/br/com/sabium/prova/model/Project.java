package br.com.sabium.prova.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
	@SequenceGenerator(name = "project_generator", sequenceName = "SEQ_PROJECT")
	private Long id;

	@Column(nullable = false, length = 300, unique = true)
	@Size(min = 2, max = 300)
	private String name;

	@ManyToMany
	@JoinTable(name = "project_employee", 
	joinColumns = { @JoinColumn(name = "project_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "employee_id") })
	private Set<Employee> employees = new HashSet<>();

	public Project() {}
	
	public Project(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
