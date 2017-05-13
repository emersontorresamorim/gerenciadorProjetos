package br.com.sabium.prova.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	@SequenceGenerator(name = "employee_generator", sequenceName = "SEQ_EMPLOYEE", allocationSize = 20)
	private long id;

	@Column(nullable = false, length = 300)
	@Size(min = 2, max = 300)
	private String name;
	
	@ManyToMany(mappedBy="employees")
	List<Project> projects;

	@Column
	private BigDecimal salary;

	public Employee(String name) {
		this.name = name;
	}

	public Employee(String name, BigDecimal salary) {
		this.name = name;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

}
