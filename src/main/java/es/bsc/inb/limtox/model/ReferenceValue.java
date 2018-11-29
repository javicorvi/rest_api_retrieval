package es.bsc.inb.limtox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ReferenceValue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Transient
	@JsonIgnore
	private String referenceName;
	
	@Column(length=3000)
	private String value="";
	
	@ManyToOne
	@JsonIgnore
	private EntityInstance entityInstance;
	
	@ManyToOne(optional=false)
	@JsonIgnore
	private Reference reference;

	
	public ReferenceValue() {
		super();
	}

	public ReferenceValue(String value, String name) {
		super();
		this.value = value;
		//this.reference = reference;
		this.referenceName=name;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public EntityInstance getEntityInstance() {
		return entityInstance;
	}

	public void setEntityInstance(EntityInstance entityInstance) {
		this.entityInstance = entityInstance;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	
	
}
