package com.em.entities.reference.country;

import com.em.entities.common.Description;
import com.em.entities.constants.SchemaConstant;
import com.em.entities.reference.language.Language;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRY_DESCRIPTION", schema= SchemaConstant.EM_SCHEMA, uniqueConstraints={
	@UniqueConstraint(columnNames={
			"COUNTRY_ID",
			"LANGUAGE_ID"
		})
	}
)
public class CountryDescription extends Description {
	private static final long serialVersionUID = 9048940117896071174L;
	
	@ManyToOne(targetEntity = Country.class)
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	private Country country;
	
	public CountryDescription() {
	}
	
	public CountryDescription(Language language, String name) {
		this.setLanguage(language);
		this.setName(name);
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
