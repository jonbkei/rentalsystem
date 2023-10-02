package rentalsystem.exception;

import rentalsystem.model.Car;

public class CarAlreadyRentedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Car car;
	
	public CarAlreadyRentedException(Car car) {
		super("Car " + car.toString() + " already rented out!");
		this.setCar(car);
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
