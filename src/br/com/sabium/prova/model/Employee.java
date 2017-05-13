package br.com.sabium.prova.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name="SEQ_EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_EMPLOYEE")
	private long id;
	
	@Column(nullable=false, length=300)
	@Size(min=2, max=300)
	private String name;
	
	@Column
	private BigDecimal salary;

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
