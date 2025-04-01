package app.ports;

import java.util.List;

import app.domain.models.Person;
import app.domain.models.Pet;

public interface PetPort {
	public void createPet(Pet pet) throws Exception;
	public Pet findById(Pet pet) throws Exception;
	public boolean existsById(Pet pet) throws Exception;
	List<Pet> getPetsByOwner(Person owner);
	Pet findById(long petId) throws Exception;

}
