package rentalsystem.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import rentalsystem.model.Location;
import rentalsystem.services.LocationService;

@Service
@FacesConverter(value = "locationConverter")
public class LocationConverter implements Converter<Location> {

	@Autowired
	LocationService locationService;
	
	
	@Override
	public Location getAsObject(FacesContext context, UIComponent component, String locationId) {
		int id = Integer.parseInt(locationId);
		var location = locationService.getById(id);
		return location.get();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Location location) {
		return location.getId().toString();
	}

}
