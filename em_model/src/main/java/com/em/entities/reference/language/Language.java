package com.em.entities.reference.language;

import com.em.entities.common.audit.AuditListener;
import com.em.entities.common.audit.AuditSection;
import com.em.entities.common.audit.Auditable;
import com.em.entities.constants.SchemaConstant;
import com.em.entities.generic.EMEntity;
import com.em.entities.merchant.MerchantStore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "LANGUAGE", schema= SchemaConstant.EM_SCHEMA)
@Cacheable
public class Language extends EMEntity<Integer, Language> implements Auditable {
	private static final long serialVersionUID = -7676627812941330669L;
	

	
	@Id
	@Column(name="LANGUAGE_ID")
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
	pkColumnValue = "LANG_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Integer id;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();

	@Column(name="CODE", nullable = false)
	private String code;
	
	@Column(name="SORT_ORDER")
	private Integer sortOrder;
	
	@SuppressWarnings("unused")
	@OneToMany(mappedBy = "defaultLanguage", targetEntity = MerchantStore.class)
	private List<MerchantStore> storesDefaultLanguage;
	
	@SuppressWarnings("unused")
	@ManyToMany(mappedBy = "languages", targetEntity = MerchantStore.class)
	private List<MerchantStore> stores = new ArrayList<MerchantStore>();
	
	public Language() {
	}
	
	public Language(String code) {
		this.setCode(code);
	}
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	@Override
	public AuditSection getAuditSection() {
		return auditSection;
	}
	
	@Override
	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof Language)) {
			return false;
		} else {
			Language language = (Language) obj;
			return (this.id == language.getId());
		}
	}
}
