package mercadogratis;


import ar.edu.mercadogratis.app.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

	@Test
	public void test() {
		Customer customer = new Customer();
		customer.setEmail("diazmaxi");
		assertEquals(customer.getEmail(), "diazmaxi");
	}

}
