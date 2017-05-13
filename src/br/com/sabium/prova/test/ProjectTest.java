package br.com.sabium.prova.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.sabium.prova.dao.ProjectDao;
import br.com.sabium.prova.model.Project;

public class ProjectTest {
	
	@Test
	public void testSaveProject() {
		ProjectDao dao = new ProjectDao();
		Project project = new Project("NFe");
		dao.save(project);
		List<Project> projects = dao.findAll();
		Assert.assertNotNull(projects);
		Assert.assertFalse(projects.isEmpty());
		Assert.assertEquals("NFe", projects.get(0).getName());
	}

}
