package ar.edu.mercadogratis.app.dao;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.mercadogratis.app.model.User;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl extends GenericDaoImp<User>{

	private final SessionFactory sessionFactory;
	
	@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}
	public User getUser(String mail){
		Session session = this.sessionFactory.getCurrentSession();
		return (User) session.createQuery("from User where email = :mail").setParameter("mail", mail)
				.uniqueResult();
	}
}
