package ui.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Invoice;
import entities.Item;
import entities.repositories.InvoiceRepository;
import entities.repositories.ItemRepository;

public class ItemsPageBean {

	static final Logger log = LoggerFactory.getLogger(ItemsPageBean.class);
	
	private InvoiceRepository invoiceRepo;
	private ItemRepository itemRepo;
	
	private InvoicesPageBean invoicePageBean;
	
	private Item newItem;
	
	public void init() {
		newItem = new Item();
	}
	
	public String addNew() {
		
		Invoice invoice = invoicePageBean.getData().getCurrentInvoice();
		log.info("Adding new item to invoice : {}", invoice);
		log.info("New item info: {}", newItem);
		newItem.setInvoice(invoice);
		invoice.addItem(newItem);
		invoiceRepo.save(invoice);
		
		return InvoicesPageBean.NAV_LIST_INVOICES;
	}

	public InvoiceRepository getInvoiceRepo() {
		return invoiceRepo;
	}

	public void setInvoiceRepo(InvoiceRepository invoiceRepo) {
		this.invoiceRepo = invoiceRepo;
	}

	public ItemRepository getItemRepo() {
		return itemRepo;
	}

	public void setItemRepo(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}

	public InvoicesPageBean getInvoicePageBean() {
		return invoicePageBean;
	}

	public void setInvoicePageBean(InvoicesPageBean invoicePageBean) {
		this.invoicePageBean = invoicePageBean;
	}

	public Item getNewItem() {
		return newItem;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}
	
	
	
}
