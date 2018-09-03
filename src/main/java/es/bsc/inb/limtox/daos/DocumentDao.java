package es.bsc.inb.limtox.daos;

import java.util.List;

import es.bsc.inb.limtox.model.Document;

public interface DocumentDao {

	List<Document> findAll();

}
