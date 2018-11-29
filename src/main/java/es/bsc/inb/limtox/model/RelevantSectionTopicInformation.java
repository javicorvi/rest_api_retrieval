package es.bsc.inb.limtox.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@DiscriminatorValue("2")
public class RelevantSectionTopicInformation extends RelevantTopicInformation {
	
	@ManyToOne
	@JsonIgnore
	private Section section;
	
	public RelevantSectionTopicInformation() {
		super();
	}
	
	public RelevantSectionTopicInformation(String topicName, Float score) {
		super(topicName, score);
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	
	
}
