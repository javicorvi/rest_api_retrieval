package es.bsc.inb.limtox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EntityAssociationSentence {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional=false)
	private EntityInstanceFound entityInstanceFoundOrigin;
	
	@ManyToOne(optional=false)
	private EntityInstanceFound entityInstanceFoundAssociated;
	
	private String keyword;
	
	private String patternName;
	
	@ManyToOne(optional=false)
	@JsonIgnore
	private Sentence sentence;
	
	
	
	public EntityAssociationSentence() {
		super();
	}

	

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPatternName() {
		return patternName;
	}

	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}


	
	

	public EntityInstanceFound getEntityInstanceFoundOrigin() {
		return entityInstanceFoundOrigin;
	}



	public void setEntityInstanceFoundOrigin(EntityInstanceFound entityInstanceFoundOrigin) {
		this.entityInstanceFoundOrigin = entityInstanceFoundOrigin;
	}



	public EntityInstanceFound getEntityInstanceFoundAssociated() {
		return entityInstanceFoundAssociated;
	}



	public void setEntityInstanceFoundAssociated(EntityInstanceFound entityInstanceFoundAssociated) {
		this.entityInstanceFoundAssociated = entityInstanceFoundAssociated;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sentence getSentence() {
		return sentence;
	}

	public void setSentence(Sentence sentence) {
		this.sentence = sentence;
	}
	
	
	
	

	
	
}
