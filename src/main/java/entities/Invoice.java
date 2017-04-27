package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.action.internal.OrphanRemovalAction;
import org.hibernate.annotations.Cascade;




//@Table(indexes = @Index(columnList = "name ASC, lastname DESC", name = "AUTH_NAME_IDX", unique=false) , name = "AUTHOR")
//@DiscriminatorColumn(discriminatorType = DiscriminatorType.CHAR, length = 1, name = "AUTHOR_TYPE")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorValue("G") // general
@Entity
@Table(name = "invoice")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Invoice implements Serializable {

	private static final long serialVersionUID = -765511469134241231L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private Long number;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String company;
	private String recipient;
	
	
	@OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
	private List<Item> items;

	public void addItem(Item item) {
		
		if(getItems()==null){
			setItems(new ArrayList<Item>());
		}if(!getItems().contains(item)){
			getItems().add(item);
			item.setInvoice(this);
		}	
	}
	
	public void removeItem(Item item) {
		
		if(getItems().contains(item)){
			getItems().remove(item);
			item.setInvoice(null);
		}
		
	}
	
	public double getTotalPrice() {
		double price = 0;
		 for(Item i : this.items) {
			 price+=i.getTotalPrice();
		 }
		 return price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}


