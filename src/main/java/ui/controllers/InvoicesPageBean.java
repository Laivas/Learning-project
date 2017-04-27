package ui.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.Valid;

import org.primefaces.model.chart.BarChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Invoice;
import entities.repositories.InvoiceRepository;
import ui.controllers.InvoicesPageBean.InvoicesPageData;


public class InvoicesPageBean {
	
	static final Logger log = LoggerFactory.getLogger(InvoicesPageBean.class);
	
	public static final String NAV_SHOW_ADD_ITEM = "show-add-item";
	public static final String NAV_SHOW_VIEW = "show-view-page";
	public static final String NAV_LIST_INVOICES = "list-invoices";
	public static final String NAV_ADD_NEW_INVOICE = "add-invoice";
	
	public static class InvoicesPageData implements Serializable {

		private static final long serialVersionUID = -3924198083822619907L;
		
		@Valid
		private Invoice newInvoice;
		
		@Valid
		private Invoice currentInvoice;
		
		private List<Invoice> foundInvoices;
		
		public void init() {
			newInvoice = new Invoice();
			foundInvoices = new ArrayList<Invoice>();
		}

		public Invoice getNewInvoice() {
			return newInvoice;
		}

		public void setNewInvoice(Invoice newInvoice) {
			this.newInvoice = newInvoice;
		}

		public Invoice getCurrentInvoice() {
			return currentInvoice;
		}

		public void setCurrentInvoice(Invoice currentInvoice) {
			this.currentInvoice = currentInvoice;
		}

		public List<Invoice> getFoundInvoices() {
			return foundInvoices;
		}

		public void setFoundInvoices(List<Invoice> foundInvoices) {
			this.foundInvoices = foundInvoices;
		}

		
	}
	
	@Inject
	private ChartView cw;
	
	private InvoicesPageData data;
	
	private InvoiceRepository invoiceRepo;
	
	public String addNew() {
		log.info("New invoice added");
		invoiceRepo.save(data.newInvoice);
		data.newInvoice = new Invoice();
		
		return NAV_LIST_INVOICES;
	}
	
	public BarChartModel chart(Invoice invoice){
		
		cw = new ChartView();
		cw.setList(invoice.getItems());
		cw.init();
		
		
		return cw.getBarModel();
		
	}
	
	public String deleteSelected(Invoice invoice) {
		log.info("Deleting invoice: "+invoice.getNumber());
		Long nr = invoice.getNumber();
			invoiceRepo.delete(invoice);
			message("Invoice nr. "+nr+" deleted.");
		return NAV_LIST_INVOICES;
		
	}
	
	public String invoiceToUpdate(Invoice invoice) {
		
		data.newInvoice = invoiceRepo.update(invoice);
		return NAV_ADD_NEW_INVOICE;
		
	}
	
	public String showAddItemPage(Invoice invoice) {
		log.info("Intention to add new item to invoice nr: "+invoice.getNumber());
		data.currentInvoice = invoice;
		return NAV_SHOW_ADD_ITEM;
	}
	
	public String showViewPage(Invoice invoice) {
		data.currentInvoice = invoice;
		return NAV_SHOW_VIEW;
	}
	
	public void message(String message) {
		FacesMessage doneMessage = new FacesMessage(message);
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
	}

	public InvoicesPageData getData() {
		return data;
	}

	public void setData(InvoicesPageData data) {
		this.data = data;
	}

	public InvoiceRepository getInvoiceRepo() {
		return invoiceRepo;
	}

	public void setInvoiceRepo(InvoiceRepository invoiceRepo) {
		this.invoiceRepo = invoiceRepo;
	}
	
	
	
	public ChartView getCw() {
		return cw;
	}

	public void setCw(ChartView cw) {
		this.cw = cw;
	}

	public List<Invoice> getInvoiceList() {
		return invoiceRepo.findAll();
	}
	
}


