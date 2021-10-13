package ar.edu.mercadogratis.app.service;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.mercadogratis.app.dao.UserDaoImpl;
import ar.edu.mercadogratis.app.model.Email;
import ar.edu.mercadogratis.app.model.User;



@Service("userService")
public class UserService {

	@Autowired
	UserDaoImpl userDao;

	@Transactional
	public User getUser(Long id) {
		return userDao.get(id);
	}
	@Transactional
	public User getUserForMail(String mail) {
		return userDao.getUser(mail);
	}

	@Transactional
	public Long addUser(User user) throws EmailException {
		Email email = new Email();
			if (email.isValidEmailAddress(user.getEmail())){
				String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
				String pwd = RandomStringUtils.random( 15, characters );
				user.setPassword(pwd);
				Long idUser=userDao.save(user);
				email.send(user.getEmail(), "Bienvenido a MercadoGratis", "Tu password es: " + user.getPassword());
				return idUser;
			}
			return null;
		
	}

	@Transactional
	public void updateUser(User user) {
		userDao.update(user);

	}
	@Transactional
	public void forgetPassword(String mail) throws EmailException {
		 
		 Email	email = new Email();
			if (email.isValidEmailAddress(mail)){
				User user =this.getUserForMail(mail);
				if (user!=null){
					email.send(user.getEmail(), "Bienvenido a MercadoGratis", "Tu password es: " + user.getPassword());
				}
				
			}
		

	}
}
