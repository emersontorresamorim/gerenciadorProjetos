package br.com.sabium.prova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name="SEQ_PROJECT")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PROJECT")
	private long id;
	
	@Column(nullable=false, length=300, unique=true)
	@Size(min=2, max=300)
	private String name;

	public Project(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
