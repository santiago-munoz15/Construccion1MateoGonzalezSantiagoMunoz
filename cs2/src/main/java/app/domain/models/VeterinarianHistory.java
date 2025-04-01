package app.domain.models;

import java.sql.Date;

import lombok.NoArgsConstructor;
@NoArgsConstructor

public class VeterinarianHistory {
	private Date date;
	private Pet petId;
	private User veterinarian;
	private String reason;
	private Order orderId;
	private String diagnosis;
	private String medicine;
	private String dose;
	private String procedureName;
	private String procedureDetail;
	private String status;
	private String vaccination;
	private String alergies;
	public VeterinarianHistory(Date date, Pet petId, User veterinarian, String reason, Order orderId, String diagnosis,
			String medicine, String dose, String procedureName, String procedureDetail, String status,
			String vaccination, String alergies) {
		super();
		this.date = date;
		this.petId = petId;
		this.veterinarian = veterinarian;
		this.reason = reason;
		this.orderId = orderId;
		this.diagnosis = diagnosis;
		this.medicine = medicine;
		this.dose = dose;
		this.procedureName = procedureName;
		this.procedureDetail = procedureDetail;
		this.status = status;
		this.vaccination = vaccination;
		this.alergies = alergies;
	}
	public VeterinarianHistory() {
		// TODO Auto-generated constructor stub
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Pet getPetId() {
		return petId;
	}
	public void setPetId(Pet petId) {
		this.petId = petId;
	}
	public User getVeterinarian() {
		return veterinarian;
	}
	public void setVeterinarian(User veterinarian) {
		this.veterinarian = veterinarian;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Order getOrderId() {
		return orderId;
	}
	public void setOrderId(Order orderId) {
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
	public void setDate(long timeMillis) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
