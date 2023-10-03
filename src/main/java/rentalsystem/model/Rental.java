package rentalsystem.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.domain.Persistable;

import jakarta.persistence.*;

@Entity
public class Rental implements Serializable, Persistable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rentalId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "car_id", nullable = false)
	private Car car;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	@Column
	private Date startDateTime;
	@Column
	private Date agreedEndDateTime;
	@Column
	private Date actualEndDateTime;
	@Column
	private Double startMileageKm;
	@Column
	private Double kmLimit;
	@Column
	private Double endMileageKm;
	@Column
	private Double finalCost;
	
	@Override
	public Integer getId() {
		return this.rentalId;
	}

	@Override
	public boolean isNew() {
		return this.rentalId == null;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getAgreedEndDateTime() {
		return agreedEndDateTime;
	}

	public void setAgreedEndDateTime(Date agreedEndDateTime) {
		this.agreedEndDateTime = agreedEndDateTime;
	}

	public Date getActualEndDateTime() {
		return actualEndDateTime;
	}

	public void setActualEndDateTime(Date actualEndDateTime) {
		this.actualEndDateTime = actualEndDateTime;
	}

	public Double getStartMileageKm() {
		return startMileageKm;
	}

	public void setStartMileageKm(Double startMileageKm) {
		this.startMileageKm = startMileageKm;
	}

	public Double getKmLimit() {
		return kmLimit;
	}

	public void setKmLimit(Double kmLimit) {
		this.kmLimit = kmLimit;
	}

	public Double getEndMileageKm() {
		return endMileageKm;
	}

	public void setEndMileageKm(Double endMileageKm) {
		this.endMileageKm = endMileageKm;
	}

	public Double getFinalCost() {
		return finalCost;
	}

	public void setFinalCost(Double finalCost) {
		this.finalCost = finalCost;
	}

}
