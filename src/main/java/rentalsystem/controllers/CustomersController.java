package rentalsystem.controllers;

import java.util.List;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import rentalsystem.model.Customer;
import rentalsystem.services.CustomerService;

@Component
@Scope("view")
public class CustomersController {
	
	@Autowired
	private CustomerService customerService;
	
	private Customer selectedCustomer;
	
	public List<Customer> getAllCustomers() {
		return this.customerService.getAllCustomers();
	}
	
	public void newCustomer() {
		this.selectedCustomer = new Customer();
	}
	
	public void saveCustomer() {
		this.customerService.saveCustomer(selectedCustomer);
		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-all-customers");
	}
	
	public void deleteCustomer() {
		this.customerService.deleteCustomer(selectedCustomer);
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}
	
	
	

}
