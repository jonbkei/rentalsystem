package rentalsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import rentalsystem.model.Location;
import rentalsystem.repositories.LocationRepository;

@Component
@Scope("application")
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}
	
	public void deleteLocation(Location location) {
		locationRepository.delete(location);
	}
	
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}
	
	public Optional<Location> getById(Integer id) {
		return locationRepository.findById(id);
	}
	
}