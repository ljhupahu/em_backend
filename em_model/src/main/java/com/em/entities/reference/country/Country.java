package com.em.entities.reference.country;

import com.em.entities.constants.SchemaConstant;
import com.em.entities.generic.EMEntity;
import com.em.entities.reference.geozone.GeoZone;
import com.em.entities.reference.zone.Zone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COUNTRY", schema= SchemaConstant.EM_SCHEMA)
@Cacheable
public class Country extends EMEntity<Integer, Country> {
	private static final long serialVersionUID = -7388011537255588035L;

	@Id
	@Column(name="COUNTRY_ID")
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
	pkColumnValue = "COUNTRY_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Integer id;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private List<CountryDescription> descriptions = new ArrayList<CountryDescription>();
	
	@OneToMany(mappedBy = "country")
	private List<Zone> zones = new ArrayList<Zone>();
	
	@ManyToOne(targetEntity = GeoZone.class)
	@JoinColumn(name = "GEOZONE_ID")
	private GeoZone geoZone;
	
	@Column(name = "COUNTRY_SUPPORTED")
	private boolean supported = true;
	
	@Column(name = "COUNTRY_ISOCODE", unique=true, nullable = false)
	private String isoCode;
	
	@Transient
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country() {
	}
	
	public Country(String isoCode) {
		this.setIsoCode(isoCode);
	}
	
	public boolean getSupported() {
		return supported;
	}

	public void setSupported(boolean supported) {
		this.supported = supported;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}


	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Zone> getZones() {
		return zones;
	}

	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}

	public List<CountryDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<CountryDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public GeoZone getGeoZone() {
		return geoZone;
	}

	public void setGeoZone(GeoZone geoZone) {
		this.geoZone = geoZone;
	}

/*	public GeoZone getGeoZone() {
		return geoZone;
	}

	public void setGeoZone(GeoZone geoZone) {
		this.geoZone = geoZone;
	}*/
}
