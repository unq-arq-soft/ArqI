package ar.edu.mercadogratis.app.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.mercadogratis.app.model.*;

@Repository
public abstract class GenericDaoImp<T extends BaseEntity> implements GenericDao<T> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	protected Class<T> persistentClass = this.getDomainClass();

	public Long save(T object) {
		sessionFactory.getCurrentSession().save(object);
		return object.getId();
	}

	public void update(T object) {
		sessionFactory.getCurrentSession().update(object);
	}

	protected abstract Class<T> getDomainClass();

	public T get(Long id) {
		return sessionFactory.getCurrentSession().get(persistentClass, id);
	}

	public List<T> list() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from " + persistentClass.getName()).list();
	}
	
	public void delete(T object) {
		sessionFactory.getCurrentSession().delete(object);
	}
}