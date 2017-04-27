package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Table(name = "item")
@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = -8502715361751610840L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotBlank
	private String title;
	
	private Integer amount;
	
	private String weight;
	
	private Double price;
	
	@JoinColumn(name = "invoice_id")
	@ManyToOne(optional = true, cascade = { CascadeType.ALL})
	private Invoice invoice;

	
	public double getTotalPrice(){
		
		return amount * price;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Invoice getInvoice() {
		return invoice;
	}


	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
	
}
