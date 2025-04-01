package app.adapters.invoice.entity;

import java.sql.Date;

import app.adapters.order.entity.OrderEntity;
import app.adapters.person.entity.PersonEntity;
import app.adapters.pet.entity.PetEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class InvoiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private long id;
	@Column(name= "pet_id")
	private PetEntity petId;
	@JoinColumn(name="owner_id")
	@OneToOne
	private PersonEntity ownerId;
	@JoinColumn(name="order_id")
	@OneToOne
	private OrderEntity orderId;
	@Column(name= "items")
	private String items;
	@Column(name= "amount")
	private double amount;
	@Column(name= "date")
	private Date date;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public PetEntity getPetId() {
		return petId;
	}
	public void setPetId(PetEntity petId) {
		this.petId = petId;
	}
	public PersonEntity getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(PersonEntity ownerId) {
		this.ownerId = ownerId;
	}
	public OrderEntity getOrderId() {
		return orderId;
	}
	public void setOrderId(OrderEntity orderId) {
		this.orderId = orderId;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
