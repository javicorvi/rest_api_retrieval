package es.bsc.inb.limtox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.bsc.inb.limtox.daos.DocumentDao;
import es.bsc.inb.limtox.model.Document;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	DocumentDao documentDao;
	
	@Override
	public List<Document> findAll() {
		return documentDao.findAll();
	}

}
