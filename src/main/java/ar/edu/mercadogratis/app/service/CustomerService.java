package ar.edu.mercadogratis.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.mercadogratis.app.dao.CustomerDaoImpl;
import ar.edu.mercadogratis.app.model.Customer;


@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerDaoImpl customerDao;

	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDao.list();
	}

	@Transactional
	public Customer getCustomer(Long id) {
		return customerDao.get(id);
	}

	@Transactional
	public void addCustomer(Customer customer) {
		customerDao.save(customer);
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);

	}

	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDao.delete(customer);
	}
}
