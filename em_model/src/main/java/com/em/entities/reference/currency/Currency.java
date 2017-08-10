package com.em.entities.reference.currency;

import com.em.entities.constants.SchemaConstant;
import com.em.entities.generic.EMEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CURRENCY", schema= SchemaConstant.EM_SCHEMA)
@Cacheable
public class Currency extends EMEntity<Long, Currency> implements Serializable {
	private static final long serialVersionUID = -999926410367685145L;
	
	@Id
	@Column(name = "CURRENCY_ID")
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "CURRENCY_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;
	
	@Column(name = "CURRENCY_CURRENCY_CODE" ,nullable = false, unique = true)
	private java.util.Currency currency;
	
	@Column(name = "CURRENCY_SUPPORTED")
	private Boolean supported = true;
	
	@Column(name = "CURRENCY_CODE", unique = true)
	private String code;
	
	@Column(name = "CURRENCY_NAME", unique = true)
	private String name;
	
	public Currency() {
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public java.util.Currency getCurrency() {
		return currency;
	}

	public void setCurrency(java.util.Currency currency) {
		this.currency = currency;
		this.code = currency.getCurrencyCode();
	}

	public Boolean getSupported() {
		return supported;
	}

	public void setSupported(Boolean supported) {
		this.supported = supported;
	}
	
	public String getCode() {
		if (currency.getCurrencyCode() != code) {
			return currency.getCurrencyCode();
		}
		return code;
	}
	
	public String getSymbol() {
		return currency.getSymbol();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}