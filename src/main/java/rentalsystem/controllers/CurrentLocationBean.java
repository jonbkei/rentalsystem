package rentalsystem.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import rentalsystem.model.Location;
import rentalsystem.services.LocationService;

@Component
@Scope("session")
public class CurrentLocationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LocationService locationService;
	
	private Location currentLocation;
	
	
	public Location getCurrentLocation() {
		if(this.currentLocation == null) {
			this.currentLocation = locationService.getAllLocations().get(0);
		}
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	
	
	
}
