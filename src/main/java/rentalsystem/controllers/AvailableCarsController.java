package rentalsystem.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import rentalsystem.model.Car;
import rentalsystem.services.CarService;

@Component
@Scope("view")
public class AvailableCarsController implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Autowired
	private CarService carService;
	
	@Autowired
	private CurrentLocationBean currentLocationBean;
	
	
	private Car selectedCar;
	
	
	public List<Car> getAvailableCars() {
		return carService.getCarsCurrentlyAvailableByLocation(currentLocationBean.getCurrentLocation());
	}
	
	public int getNoOfCarsCurrentlyAvailable() {
		return carService.getCarsCurrentlyAvailableByLocation(currentLocationBean.getCurrentLocation()).size();
	}
	
	public int getNoOfCarsAtLocation() {
		return carService.getCarsByLocation(currentLocationBean.getCurrentLocation()).size();
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}
	
	
	
	
}
