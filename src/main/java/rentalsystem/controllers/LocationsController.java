package rentalsystem.controllers;

import java.io.IOException;
import java.util.List;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpServletRequest;
import rentalsystem.model.Location;
import rentalsystem.services.LocationService;

@Component
@Scope("view")
public class LocationsController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private CurrentLocationBean currentLocationBean;
	
	private Location tempLocation;
	
	public void updateLocation() {
		currentLocationBean.setCurrentLocation(tempLocation);
		PrimeFaces.current().executeScript("PF('pickLocationDialog').hide()");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Location> getAllLocations() {
		return this.locationService.getAllLocations();
	}

	public Location getTempLocation() {
		return tempLocation;
	}

	public void setTempLocation(Location tempLocation) {
		this.tempLocation = tempLocation;
	}
	
}
