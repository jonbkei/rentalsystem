package rentalsystem.model;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

import jakarta.persistence.*;

@Entity
public class Car implements Serializable, Persistable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer carId;
	
	@Column
	private String licensePlate;
	@Column
	private String make;
	@Column
	private String model;
	@Column(length=8192)
	private String notes;
	@Column
	private double costPerDay;
	@Column
	private double costPerKm;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public Integer getId() {
		return this.carId;
	}

	@Override
	public boolean isNew() {
		return this.carId == null;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getCostPerDay() {
		return costPerDay;
	}

	public void setCostPerDay(double costPerDay) {
		this.costPerDay = costPerDay;
	}

	public double getCostPerKm() {
		return costPerKm;
	}

	public void setCostPerKm(double costPerKm) {
		this.costPerKm = costPerKm;
	}

}
