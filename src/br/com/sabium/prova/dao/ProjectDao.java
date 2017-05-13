package br.com.sabium.prova.dao;

import java.util.List;

import br.com.sabium.prova.model.Project;
import br.com.sabium.prova.util.JPAUtil;

public class ProjectDao extends JPAUtil {
	
	public void save(Project project) {
		transaction.begin();
		entityManager.persist(project);
		transaction.commit();
	}
	
	public List<Project> findAll() {
		return entityManager.createQuery("select p from Project p", Project.class).getResultList();
	}
	
}
