package es.bsc.inb.limtox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.bsc.inb.limtox.model.Document;
import es.bsc.inb.limtox.services.DocumentService;

@RestController
public class DocumentController {
	
	@Autowired
	public DocumentService documentService;
	
	@RequestMapping("/documents")
    public List<Document> findAll() {
        return documentService.findAll();
    }
	
}
