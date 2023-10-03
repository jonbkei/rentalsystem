package rentalsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rentalsystem.model.Car;
import rentalsystem.model.Customer;
import rentalsystem.model.Location;
import rentalsystem.model.Rental;

public interface RentalRepository extends AbstractRepository<Rental, Integer> {
	
	List<Rental> findRentalsByCar(Car car);
	
	List<Rental> findRentalsByCustomer(Customer customer);
	
	@Query("""
			SELECT r
			  FROM Rental r
			  JOIN Car c ON r.car = c
			 WHERE r.actualEndDateTime IS NULL
			   AND c.location = :location""")
	List<Rental> findActiveRentalsByLocation(@Param("location") Location location);
	
	@Query("""
			SELECT r
			  FROM Rental r
			 WHERE r.actualEndDateTime IS NULL
			   AND r.car = :car
			""")
	List<Rental> findActiveRentalsForCar(@Param("car") Car car);

}
