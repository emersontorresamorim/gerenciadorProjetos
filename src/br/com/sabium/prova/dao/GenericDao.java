package br.com.sabium.prova.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;

import br.com.sabium.prova.util.JPAUtil;

public abstract class GenericDao<T, I> extends JPAUtil {

	private Class<T> persistedClass;

	protected GenericDao(Class<T> persistedClass) {
		this.persistedClass = persistedClass;
	}

	public T save(@Valid T entity) {
		transaction.begin();
		entityManager.persist(entity);
		entityManager.flush();
		transaction.commit();
		return entity;
	}

	public T update(@Valid T entity) {
		transaction.begin();
		entityManager.merge(entity);
		entityManager.flush();
		transaction.commit();
		return entity;
	}

	public void remove(I id) {
		T entity = findById(id);
		transaction.begin();
		T mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
		transaction.commit();
	}

	public T findById(I id) {
		return entityManager.find(persistedClass, id);
	}
	
	public List<T> findAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return entityManager.createQuery(query).getResultList();
	}

}
