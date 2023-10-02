package rentalsystem.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import rentalsystem.model.Car;
import rentalsystem.model.Location;
import rentalsystem.repositories.CarRepository;

@Component
@Scope("application")
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}
	
	public void deleteCar(Car car) {
		carRepository.delete(car);
	}
	
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	public List<Car> getCarsByLocation(Location location) {
		return carRepository.findCarsByLocation(location);
	}
	
	public List<Car> getCarsCurrentlyAvailableByLocation(Location location) {
		return carRepository.findAvailableCarsByLocationAndDate(location, new Date());
	}

}
