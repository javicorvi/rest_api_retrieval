package es.bsc.inb.limtox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.bsc.inb.limtox.daos.DocumentDao;
import es.bsc.inb.limtox.model.Document;
import es.bsc.inb.limtox.model.QueryFilter;
import es.bsc.inb.limtox.model.Sentence;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	DocumentDao documentDao;
	
	@Override
	public List<Document> findAll() {
		return documentDao.findAll();
	}

	@Override
	public List<Object> search(String endPoint, String chemical_compound) {
		return documentDao.search(endPoint, chemical_compound);
	}

	@Override
	public List<Sentence> searchSentences(String endPoint, String chemical_compound) {
		return documentDao.searchSentences(endPoint, chemical_compound);
	}
	
	@Override
	public List<Sentence> searchSentencesByFilter(QueryFilter queryFilter) {
		return documentDao.searchSentencesByFilter(queryFilter);
	}
}
