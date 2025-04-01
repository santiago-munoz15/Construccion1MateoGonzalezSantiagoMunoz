package app.adapters.veterinarian.entity;

import java.sql.Date;

import app.adapters.order.entity.OrderEntity;
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
@Table(name = "veterinarian")
public class VeterinarianHistoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "pet_id")
	private PetEntity petId;
	@Column(name= "date")
	private Date date;
	@Column(name= "veterinarian")
	private UserEntity veterinarian;
	@Column(name= "reason")
	private String reason;
	@JoinColumn(name="order_id")
	@OneToOne
	private OrderEntity orderId;
	@Column(name= "diagnosis")
	private String diagnosis;
	@Column(name= "medicine")
	private String medicine;
	@Column(name= "dose")
	private String dose;
	@Column(name= "procedure_name")
	private String procedureName;
	@Column(name= "procedure_detail")
	private String procedureDetail;
	@Column(name= "status")
	private String status;
	@Column(name= "vaccination")
	private String vaccination;
	@Column(name= "alergies")
	private String alergies;
	public PetEntity getPetId() {
		return petId;
	}
	public void setPetId(PetEntity petId) {
		this.petId = petId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public UserEntity getVeterinarian() {
		return veterinarian;
	}
	public void setVeterinarian(UserEntity veterinarian) {
		this.veterinarian = veterinarian;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public OrderEntity getOrderId() {
		return orderId;
	}
	public void setOrderId(OrderEntity orderId) {
		this.orderId = orderId;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public String getProcedureName() {
		return procedureName;
	}
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	public String getProcedureDetail() {
		return procedureDetail;
	}
	public void setProcedureDetail(String procedureDetail) {
		this.procedureDetail = procedureDetail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVaccination() {
		return vaccination;
	}
	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}
	public String getAlergies() {
		return alergies;
	}
	public void setAlergies(String alergies) {
		this.alergies = alergies;
	}
	
	

}
