package com.em.entities.reference.zone;

import com.em.entities.constants.SchemaConstant;
import com.em.entities.generic.EMEntity;
import com.em.entities.reference.country.Country;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ZONE", schema= SchemaConstant.EM_SCHEMA)
public class Zone extends EMEntity<Long, Zone> {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ZONE_ID")
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
	pkColumnValue = "ZONE_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;
	
	@OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
	private List<ZoneDescription> descriptions = new ArrayList<ZoneDescription>();
	
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID", nullable = false)
	private Country country;
	
	@Transient
	private String name;
	

	
	@Column(name = "ZONE_CODE", nullable = false)
	private String code;
	
	public Zone() {
	}
	
	public Zone(Country country, String name, String code) {
		this.setCode(code);
		this.setCountry(country);
		this.setCode(name);
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public List<ZoneDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptons(List<ZoneDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
