package ar.edu.mercadogratis.app.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.mercadogratis.app.model.Customer;

@Repository
public class CustomerDaoImpl extends GenericDaoImp<Customer>{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	protected Class<Customer> getDomainClass() {
		return Customer.class;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

}
