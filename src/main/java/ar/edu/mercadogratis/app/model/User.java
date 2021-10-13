package ar.edu.mercadogratis.app.model;

import javax.mail.internet.AddressException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class User extends BaseEntity {
	
	private String name;
	private String lastName;
	//@Column(name = "email", nullable = false, unique = true)
	private String email;
	private String password;
	
	
	

}
