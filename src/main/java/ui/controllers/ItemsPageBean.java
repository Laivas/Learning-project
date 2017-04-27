package ui.controllers;

import entities.Invoice;
import entities.Item;
import entities.repositories.InvoiceRepository;
import entities.repositories.ItemRepository;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ItemsPageBean {

	static final Logger log = LoggerFactory.getLogger(ItemsPageBean.class);
	
	private InvoiceRepository invoiceRepo;
	private ItemRepository itemRepo;
	

	 
	private InvoicesPageBean invoicesPageBean;
	
	private Item newItem;
	
	public void init() {
		
		newItem = new Item();
		
	}
	

	
	public void updateItem(Item item) {
		
		newItem = itemRepo.update(item);
		
	}
	
	
	public String addNew() {
		
		Invoice invoice = invoicesPageBean.getData().getCurrentInvoice();
		newItem.setInvoice(invoice);
		invoice.addItem(newItem);
		invoiceRepo.save(invoice);
		
		return InvoicesPageBean.NAV_SHOW_ADD_ITEM;
	}
	
	public void deleteSelected(Item item) {

		Invoice i = item.getInvoice();
		i.removeItem(item);
		Long id = item.getId();
		itemRepo.deleteById(id);
		message("Item id. "+id+" deleted.");
		
	}
	
	public void message(String message) {
		FacesMessage doneMessage = new FacesMessage(message);
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
	}

	public InvoicesPageBean getInvoicesPageBean() {
		return invoicesPageBean;
	}

	public void setInvoicesPageBean(InvoicesPageBean invoicesPageBean) {
		this.invoicesPageBean = invoicesPageBean;
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
		return invoicesPageBean;
	}

	public void setInvoicePageBean(InvoicesPageBean invoicePageBean) {
		this.invoicesPageBean = invoicePageBean;
	}

	public Item getNewItem() {
		return newItem;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}
	
	public List<Item> getItemList() {
		
		return invoicesPageBean.getData().getCurrentInvoice().getItems();
		
	}

	
	
}
