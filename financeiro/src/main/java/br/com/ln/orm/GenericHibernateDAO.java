package br.com.ln.orm;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

@SuppressWarnings("unchecked")
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	
	@PersistenceContext( unitName = "financeiroUP" )
	private EntityManager entityManager;

	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public T findById(ID id) {
		return (T) getSession().load(getPersistentClass(), id);
	}

	public List<T> findAll() {
		return findByCriteria();
	}

	public List<T> findByExample(T exampleInstance) {
		return findByExample(exampleInstance, null);
	}

	
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example = Example.create(exampleInstance);
		if (excludeProperty != null){
			for (String exclude : excludeProperty) {
				example.excludeProperty(exclude);
			}
		}
		crit.add(example);
		return crit.list();
	}

	public T makePersistent(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	public void makeTransient(T entity) {
		getSession().delete(entity);
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	protected Session getSession() {
		if ( ( entityManager instanceof org.hibernate.ejb.HibernateEntityManager ) ) {
			return ( (org.hibernate.ejb.HibernateEntityManager) entityManager ).getSession();
		} else {
			if ( entityManager.getDelegate() instanceof org.hibernate.ejb.HibernateEntityManager ) {
				return ( (org.hibernate.ejb.HibernateEntityManager) entityManager.getDelegate() ).getSession();
			} else {
				return (Session) entityManager.getDelegate();
			}
		}
	}

}
