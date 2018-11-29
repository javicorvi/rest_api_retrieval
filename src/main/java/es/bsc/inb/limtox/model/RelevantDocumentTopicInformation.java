package es.bsc.inb.limtox.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@DiscriminatorValue("1")
public class RelevantDocumentTopicInformation extends RelevantTopicInformation {
	
	@ManyToOne(optional=true)
	@JsonIgnore
	private Document document;
	
	public RelevantDocumentTopicInformation() {
		super();
	}
	
	public RelevantDocumentTopicInformation(String topicName, Float score) {
		super(topicName, score);
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	
}
