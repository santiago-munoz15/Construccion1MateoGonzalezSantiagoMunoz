package app.adapters.pet.entity;

import app.adapters.person.entity.PersonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet")
public class PetEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "pet_id")
	private long petId;
	@Column(name= "name")
	private String name;
	@JoinColumn(name="owner_identification")
	@OneToOne
	private PersonEntity ownerIdentification;
	@Column(name= "age")
	private int age;
	@Column(name= "species")
	private String species;
	@Column(name= "race")
	private String race;
	@Column(name= "features")
	private String features;
	@Column(name= "weight")
	private double weight;
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PersonEntity getOwnerIdentification() {
		return ownerIdentification;
	}
	public void setOwnerIdentification(PersonEntity ownerIdentification) {
		this.ownerIdentification = ownerIdentification;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	

}
