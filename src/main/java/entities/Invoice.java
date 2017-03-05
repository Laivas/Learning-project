package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;



//@Table(indexes = @Index(columnList = "name ASC, lastname DESC", name = "AUTH_NAME_IDX", unique=false) , name = "AUTHOR")
//@DiscriminatorColumn(discriminatorType = DiscriminatorType.CHAR, length = 1, name = "AUTHOR_TYPE")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorValue("G") // general
@Entity
@Table(indexes = @Index(columnList = ""))
@DiscriminatorColumn(discriminatorType = DiscriminatorType.CHAR, length = 1, name = "INVOICE_TYPE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("G")
public class Invoice implements Serializable {

	private static final long serialVersionUID = -765511469134241231L;

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@NotBlank
	private long number;
	private Date date;
	private String company;
	private String recipient;
	
	private List<Item> items;

	public void addItem(Item item) {
		
		if(getItems()==null){
			setItems(new ArrayList<Item>());
		}if(!getItems().contains(item)){
			getItems().add(item);
		}	
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
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


