package es.bsc.inb.limtox.daos;

import java.util.List;

import es.bsc.inb.limtox.model.Document;
import es.bsc.inb.limtox.model.QueryFilter;
import es.bsc.inb.limtox.model.Sentence;

public interface DocumentDao {

	List<Document> findAll();

	List<Object> search(String endPoint, String chemical_compound);

	List<Sentence> searchSentences(String endPoint, String chemical_compound);
	
	List<Sentence> searchSentencesByFilter(QueryFilter queryFilter);
}
