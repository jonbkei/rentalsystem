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
			   AND ( r.agreedEndDateTime IS NULL
			    OR   CASE WHEN r.agreedEndDateTime < CURRENT_TIMESTAMP
			   		 THEN r.actualEndDateTime IS NOT NULL AND r.actualEndDateTime < :search_date
			   		 ELSE r.agreedEndDateTime < :search_date END)
			""")
	List<Car> findAvailableCarsByLocationAndDate(@Param("location") Location location,@Param("search_date")  Date searchDate);
}
