package es.bsc.inb.limtox.daos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.bsc.inb.limtox.model.Document;
import es.bsc.inb.limtox.model.QueryFilter;
import es.bsc.inb.limtox.model.Sentence;

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

	@Override
	public List<Object> search(String endPoint, String chemical_compound) {
		Query query = em.createQuery("select x.id, x.sentenceId, x.text, x.speciesQuantity, x.diseasesQuantity, x.genesQuantity, x.chemicalCompoundsQuantity, "
				+ "relevantTopic.classifierScore,  relevantTopic.customWeightScore, relevantTopic.numberOfTermsScore, instanceFound.entityInstance.value,"
				+ " instanceFound.start, instanceFound.end from Sentence x inner join x.relevantTopicsInformation relevantTopic inner join  "
				+ "x.entitiesInstanceFound instanceFound where "
				+ " instanceFound.entityInstance.entityType.name='chemical_compound' and instanceFound.entityInstance.value=:chemical_compound and relevantTopic.topicName=:endPoint order by relevantTopic.numberOfTermsScore desc ");
		query.setParameter("endPoint", endPoint);
		query.setParameter("chemical_compound", chemical_compound);
		List<Object> list = query.getResultList();
		return list;
	}

	@Override
	public List<Sentence> searchSentences(String endPoint, String chemical_compound) {
		Query query = em.createQuery("select  x from Sentence x inner join x.relevantTopicsInformation relevantTopic inner join  "
				+ "x.entitiesInstanceFound instanceFound inner join x.entitiesAssociationsInstanceFound asociation where "
				+ " instanceFound.entityInstance.entityType.name='chemical_compound' and instanceFound.entityInstance.value=:chemical_compound and relevantTopic.topicName=:endPoint order by relevantTopic.numberOfTermsScore desc ");
		query.setParameter("endPoint", endPoint);
		query.setParameter("chemical_compound", chemical_compound);
		List<Sentence> list = query.getResultList();
		return list;
	}
	
	@Override
	public List<Sentence> searchSentencesByFilter(QueryFilter queryFilter) {
		Query query = em.createQuery("select  x from Sentence x inner join x.relevantTopicsInformation relevantTopic inner join  "
				+ "x.entitiesInstanceFound instanceFound where "
				+ " instanceFound.entityInstance.entityType.name=:keyWordToSearchEntityType and instanceFound.entityInstance.value=:keyWordToSearch and relevantTopic.topicName=:endPoint order by relevantTopic.numberOfTermsScore desc ");
		query.setParameter("endPoint", queryFilter.getEndPoint());
		query.setParameter("keyWordToSearch", queryFilter.getKeyWordToSearch());
		query.setParameter("keyWordToSearchEntityType", queryFilter.getKeyWordSearchEntityType());
		query.setFirstResult((queryFilter.getPageNumer()-1) * queryFilter.getPageSize()); 
		query.setMaxResults(queryFilter.getPageSize());
		List<Sentence> list = query.getResultList();
		return list;
	}
	
}
