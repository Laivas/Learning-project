package entities.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Invoice;
import entities.repositories.InvoiceRepository;


public class InvoiceDaoImpl implements InvoiceRepository{

	static final Logger log = LoggerFactory.getLogger(InvoiceDaoImpl.class);
	
	private EntityManagerFactory entityManagerFactory;

	
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public Invoice findByNumber(Long number) {
		
		EntityManager entityManager = getEntityManager();

		
		return null;
	}

	public List<Invoice> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Invoice newInvoice) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Invoice invoice) {
		// TODO Auto-generated method stub
		
	}
	
	private EntityManager getEntityManager(){
		
		return entityManagerFactory.createEntityManager();
	}

}
