package app.adapters.order.entity;

import java.sql.Date;

import app.adapters.person.entity.PersonEntity;
import app.adapters.pet.entity.PetEntity;
import app.adapters.user.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private long id;
	@Column(name= "pet_id")
	private PetEntity petId;
	@Column(name= "veterinarian")
	private UserEntity veterinarian;
	@JoinColumn(name="owner_id")
	@OneToOne
	private PersonEntity ownerId;
	@Column(name= "dose")
	private String dose;
	@Column(name= "medicine")
	private String medicine;
	@Column(name= "date")
	private Date date;
	@Column(name= "status")
	private String status;
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
	public UserEntity getVeterinarian() {
		return veterinarian;
	}
	public void setVeterinarian(UserEntity veterinarian) {
		this.veterinarian = veterinarian;
	}
	public PersonEntity getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(PersonEntity ownerId) {
		this.ownerId = ownerId;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
