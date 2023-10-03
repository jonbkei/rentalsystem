package rentalsystem.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import rentalsystem.model.Customer;
import rentalsystem.services.CustomerService;

@Service
@FacesConverter(value = "customerConverter")
public class CustomerConverter implements Converter<Customer> {

	@Autowired
	CustomerService customerService;
	
	
	@Override
	public Customer getAsObject(FacesContext context, UIComponent component, String customerId) {
		int id = Integer.parseInt(customerId);
		var customer = customerService.getById(id);
		return customer.get();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Customer customer) {
		return customer.getId().toString();
	}

}
