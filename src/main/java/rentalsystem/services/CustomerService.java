package rentalsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import rentalsystem.model.Customer;
import rentalsystem.repositories.CustomerRepository;

@Component
@Scope("application")
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
}