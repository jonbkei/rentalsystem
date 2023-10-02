package rentalsystem.model;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

import jakarta.persistence.*;

@Entity
public class Customer implements Serializable, Persistable<Integer> {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String licenseNumber;
	@Column
	private String licenseCountry;
	

	@Override
	public Integer getId() {
		return this.customerId;
	}

	@Override
	public boolean isNew() {
		return this.customerId == null;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getLicenseCountry() {
		return licenseCountry;
	}

	public void setLicenseCountry(String licenseCountry) {
		this.licenseCountry = licenseCountry;
	}

}
