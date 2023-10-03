package rentalsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import rentalsystem.exception.CarAlreadyRentedException;
import rentalsystem.model.Car;
import rentalsystem.model.Customer;
import rentalsystem.model.Location;
import rentalsystem.model.Rental;
import rentalsystem.repositories.RentalRepository;

@Component
@Scope("application")
public class RentalService {
	
	@Autowired
	private RentalRepository rentalRepository;
	
	public Rental saveRental(Rental rental) throws CarAlreadyRentedException {
		if(rental.isNew()) {
			if(isCarRented(rental.getCar())) {
				throw new CarAlreadyRentedException(rental.getCar());
			}
		}
		return rentalRepository.save(rental);
	}

	
	public void deleteRental(Rental rental) {
		rentalRepository.delete(rental);
	}
	
	public List<Rental> getAllRentals() {
		return rentalRepository.findAll();
	}
	
	public boolean isCarRented(Car car) {
		return rentalRepository.findActiveRentalsForCar(car).size() > 0;
	}
	
	public List<Rental> getRentalsByCar(Car car) {
		return rentalRepository.findRentalsByCar(car);
	}
	
	public List<Rental> getRentalsByCustomer(Customer customer) {
		return rentalRepository.findRentalsByCustomer(customer);
	}
	

	public List<Rental> getActiveRentalsByLocation(Location location) {
		return rentalRepository.findActiveRentalsByLocation(location);
	}
	

}