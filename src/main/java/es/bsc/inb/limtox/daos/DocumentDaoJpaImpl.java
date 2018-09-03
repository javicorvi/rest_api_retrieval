package es.bsc.inb.limtox.daos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.bsc.inb.limtox.model.Document;

@Repository
@Transactional(readOnly=false)
public class DocumentDaoJpaImpl implements DocumentDao{

    @PersistenceContext(unitName="modelPersistenceUnit")
    protected EntityManager em;

	@Override
	public List<Document> findAll() {
		@SuppressWarnings("unchecked")
		Collection<Document> collection = em.createQuery("from Document x").getResultList();
    	return new ArrayList<Document> (collection);
	}

	
}
