package com.em.entities.reference.geozone;

import com.em.entities.common.Description;
import com.em.entities.constants.SchemaConstant;

import javax.persistence.*;

@Entity
@Table(name="GEOZONE_DESCRIPTION", schema= SchemaConstant.EM_SCHEMA, uniqueConstraints={
		@UniqueConstraint(columnNames={
			"GEOZONE_ID",
			"LANGUAGE_ID"
		})
	}
)
public class GeoZoneDescription extends Description {
	private static final long serialVersionUID = 7759498146450786218L;
	
	@ManyToOne(targetEntity = GeoZone.class)
	@JoinColumn(name = "GEOZONE_ID")
	private GeoZone geoZone;
	
	public GeoZoneDescription() {
	}

	public GeoZone getGeoZone() {
		return geoZone;
	}

	public void setGeoZone(GeoZone geoZone) {
		this.geoZone = geoZone;
	}
}
