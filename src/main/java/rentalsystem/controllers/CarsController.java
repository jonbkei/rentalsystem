package rentalsystem.controllers;

import java.util.List;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import rentalsystem.model.Car;
import rentalsystem.services.CarService;

@Component
@Scope("view")
public class CarsController {
	
	@Autowired
	private CarService carService;
	
	private Car selectedCar;
	
	public List<Car> getAllCars() {
		return this.carService.getAllCars();
	}
	
	public void newCar() {
		this.selectedCar = new Car();
	}
	
	public void saveCar() {
		this.carService.saveCar(selectedCar);
		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-all-cars");
	}
	
	public void deleteCar() {
		this.carService.deleteCar(selectedCar);
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}
	
	
	

}
