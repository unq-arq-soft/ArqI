package mercadogratis;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.mercadogratis.app.model.Customer;

public class CustomerTest {

	@Test
	public void test() {
		Customer customer = new Customer();
		customer.setEmail("diazmaxi");
		assertEquals(customer.getEmail(), "diazmaxi");
	}

}
