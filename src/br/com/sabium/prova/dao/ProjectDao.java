package br.com.sabium.prova.dao;

import javax.persistence.TypedQuery;

import br.com.sabium.prova.model.Project;

public class ProjectDao extends GenericDao<Project, Long> {
	
	public ProjectDao() {
		super(Project.class);
	}

	public Project findProjectByName(String projectName) {
		TypedQuery<Project> query = entityManager.createQuery("select p from Project p where p.name = :projectName", Project.class);
		query.setParameter("projectName", projectName);
		return query.getSingleResult();
	}
	
}
