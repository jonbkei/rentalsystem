package rentalsystem.model;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

import jakarta.persistence.*;


@Entity
public class Location implements Serializable, Persistable<Integer> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer locationId;
	@Column
	private String name;

	@Override
	public Integer getId() {
		return this.locationId;
	}

	@Override
	public boolean isNew() {
		return this.locationId == null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
