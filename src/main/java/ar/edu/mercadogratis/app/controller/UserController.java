package ar.edu.mercadogratis.app.controller;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.mercadogratis.app.model.User;
import ar.edu.mercadogratis.app.service.UserService;


@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/register", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity addUser(@RequestBody User user) {	
		User userLogin=userService.getUserForMail(user.getEmail());
			if (userLogin == null){
				try {
					return ResponseEntity.ok().body(userService.addUser(user));
				} catch (EmailException e) {
					return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("1");
				}
			}
			return null;
	}
	@RequestMapping(value = "/user/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity login(@RequestBody User user) {	
			User userLogin=userService.getUserForMail(user.getEmail());
			if (userLogin!=null && user.getPassword().equals(userLogin.getPassword())){
				return ResponseEntity.ok().body(userLogin.getId());
			}
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	@RequestMapping(value = "/user/forgetPassword", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity forgetPassword(@RequestBody User user) {	
		try {
			userService.forgetPassword(user.getEmail());
			return ResponseEntity.ok().body(null);

		} catch (EmailException e) {
			
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);

	}
	
	
}
