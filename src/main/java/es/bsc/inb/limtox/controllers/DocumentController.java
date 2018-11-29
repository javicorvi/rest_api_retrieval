package es.bsc.inb.limtox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.bsc.inb.limtox.model.Document;
import es.bsc.inb.limtox.model.QueryFilter;
import es.bsc.inb.limtox.model.Sentence;
import es.bsc.inb.limtox.services.DocumentService;

@RestController
public class DocumentController {
	
	@Autowired
	public DocumentService documentService;
	
	@RequestMapping("/documents/{endPoint}")
    public List<Document> findAll() {
        return documentService.findAll();
    }

	@RequestMapping("/search/{endPoint}")
    public List<Object> search(@PathVariable(value="endPoint") String endPoint, @RequestParam String chemical_compound) {
        return documentService.search(endPoint, chemical_compound);
    }
	
	
	@RequestMapping("/searchSentences/{endPoint}")
    public List<Sentence> searchSentences(@PathVariable(value="endPoint") String endPoint, @RequestParam String chemical_compound) {
        return documentService.searchSentences(endPoint, chemical_compound);
    }
	
	@RequestMapping("/searchSentencesQueryFilte/{endPoint}")
    public List<Sentence> searchSentencesQueryFilte(@PathVariable(value="endPoint") String endPoint) {
        //QueryFilter queryFilter = new QueryFilter (endPoint, keyWordToSearch, keyWordSearchEntityType, pageSize, pageNumber);
		//return documentService.searchSentencesByFilter(queryFilter);
		return null;
    }
	
	@RequestMapping("/searchSentencesQueryFilter/{endPoint}")
    public List<Sentence> searchSentencesQueryFilter(@PathVariable(value="endPoint") String endPoint,  @RequestParam String keyWordToSearchEntityType, @RequestParam String keyWordToSearch, 
    		@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
        QueryFilter queryFilter = new QueryFilter (endPoint, keyWordToSearch, keyWordToSearchEntityType, pageSize, pageNumber);
		return documentService.searchSentencesByFilter(queryFilter);
    }
	
	@RequestMapping("/searchSentencesQueryFilterJSON/{endPoint}")
    public List<Sentence> searchSentencesQueryFilterJSON(@PathVariable(value="endPoint") String endPoint,  @RequestParam String keyWordToSearchEntityType, @RequestParam String keyWordToSearch, 
    		@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
        QueryFilter queryFilter = new QueryFilter (endPoint, keyWordToSearch, keyWordToSearchEntityType, pageSize, pageNumber);
		return documentService.searchSentencesByFilter(queryFilter);
    }
	
//	@RequestMapping("/search")
//    public List<Document> search(@RequestParam(value="endPoint", defaultValue="hepatotoxicity") String endPoint ) {
//        return documentService.findAll();
//    }
}