package app.adapters.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.adapters.pet.entity.PetEntity;
import app.domain.models.Pet;

public interface PetRepository extends JpaRepository<PetEntity, Long>{
	
	public void savePet(Pet pet);
	public List<Pet> findByOwnerId(long id);

}
