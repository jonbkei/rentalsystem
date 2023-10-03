package rentalsystem.controllers;

import java.util.List;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import rentalsystem.exception.CarAlreadyRentedException;
import rentalsystem.model.Car;
import rentalsystem.model.Rental;
import rentalsystem.services.RentalService;

@Component
@Scope("view")
public class RentalsController {

	
	@Autowired
	private RentalService rentalService;
	
	@Autowired
	private CurrentLocationBean currentLocationBean;
	
	private Rental selectedRental;
	
	
	public void startRental(Car car) {
		this.selectedRental = new Rental();
		this.selectedRental.setCar(car);
	}
	
	public void saveRental() throws CarAlreadyRentedException {
		this.rentalService.saveRental(selectedRental);
		PrimeFaces.current().executeScript("PF('startRentalDialog').hide()");
		PrimeFaces.current().executeScript("PF('endRentalDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-avail-cars");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-active-rentals");
	}
	
	
	public void deleteRental() {
		this.rentalService.deleteRental(selectedRental);
		PrimeFaces.current().executeScript("PF('deleteRentalDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-all-rentals");
	}
	
	public List<Rental> getAllRentals() {
		return this.rentalService.getAllRentals();
	}
	
	public List<Rental> getActiveRentals() {
		return this.rentalService.getActiveRentalsByLocation(currentLocationBean.getCurrentLocation());
	}
	

	public Rental getSelectedRental() {
		return selectedRental;
	}

	public void setSelectedRental(Rental selectedRental) {
		this.selectedRental = selectedRental;
	}
	
}
