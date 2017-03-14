package entities.repositories;

import java.util.List;

import entities.Invoice;

public interface InvoiceRepository {

	public Invoice findByNumber(Long number);
	
	public Invoice findById(Long id);
	
	public List<Invoice> findAll();
	
	public void save(Invoice newInvoice);
	
	public void delete(Invoice invoice);
	
	public Invoice update(Invoice invoice);
	
	
}
