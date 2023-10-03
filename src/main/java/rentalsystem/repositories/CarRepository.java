package rentalsystem.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rentalsystem.model.Car;
import rentalsystem.model.Location;

public interface CarRepository extends AbstractRepository<Car, Integer> {

	List<Car> findCarsByLocation(Location location);
	
	@Query("""
			SELECT c
			  FROM Car c
			  LEFT OUTER JOIN Rental r ON r.car = c
			 WHERE c.location = :location
			   AND (( r.agreedEndDateTime = (SELECT MAX(l.agreedEndDateTime) FROM Rental l WHERE l.car = c)
			   AND    r.agreedEndDateTime IS NOT NULL AND r.actualEndDateTime IS NOT NULL
			   AND    r.agreedEndDateTime < :search_date AND r.actualEndDateTime < :search_date)
			    OR    r.agreedEndDateTime IS NULL)
			""")
	List<Car> findAvailableCarsByLocationAndDate(@Param("location") Location location,@Param("search_date")  Date searchDate);
}