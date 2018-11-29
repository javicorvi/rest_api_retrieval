package es.bsc.inb.limtox.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EntityInstance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(length=120,nullable=false)
	private String value="";
	
	@Column(length=50,nullable=false)
	private String taggerName;
	
	@ManyToOne(optional=false)
	private EntityType entityType;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "entityInstance", orphanRemoval = true)
	private List<ReferenceValue> referenceValues;
	
	public EntityInstance() {
		super();
	}

	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public List<ReferenceValue> getReferenceValues() {
		return referenceValues;
	}

	public void setReferenceValues(List<ReferenceValue> referenceValues) {
		this.referenceValues = referenceValues;
	}

	

	public String getTaggerName() {
		return taggerName;
	}

	public void setTaggerName(String taggerName) {
		this.taggerName = taggerName;
	}
	
	
	
}
