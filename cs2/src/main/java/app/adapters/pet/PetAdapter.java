package app.adapters.pet;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.person.entity.PersonEntity;
import app.adapters.pet.entity.PetEntity;
import app.adapters.pet.repository.PetRepository;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.ports.PetPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class PetAdapter implements PetPort {
	
	@Autowired
	private PetRepository petRepository;

	@Override
	public void createPet(Pet pet) throws Exception {
		petRepository.savePet(pet);
		
	}

	@Override
	public Pet findById(Pet pet) throws Exception {
		if (pet == null || pet.getPetId() == 0) return null;
	    
	    Optional<PetEntity> petEntityOptional = petRepository.findById(pet.getPetId());
	    
	    if (petEntityOptional.isEmpty()) return null; 

	    return adapter(petEntityOptional.get());
	}

	@Override
	public boolean existsById(Pet pet) throws Exception {
		 if (pet == null) return false;
		    return petRepository.existsById(pet.getPetId());
	}

	@Override
	public List<Pet> getPetsByOwner(Person owner) {
		return petRepository.findByOwnerId(owner.getId());
	}

	@Override
	public Pet findById(long petId) throws Exception {
		if (petId <= 0) return null;  

	    Optional<PetEntity> optionalPet = petRepository.findById(petId);
	    if (optionalPet.isEmpty()) return null;

	    return adapter(optionalPet.get());
	}

	private Pet adapter(PetEntity petEntity) {
		if (petEntity == null) return null;

	    Pet pet = new Pet();
	    pet.setPetId(petEntity.getPetId());
	    pet.setName(petEntity.getName());
	    pet.setAge(petEntity.getAge());
	    pet.setSpecies(petEntity.getSpecies());
	    pet.setRace(petEntity.getRace());
	    pet.setFeatures(petEntity.getFeatures());
	    pet.setWeight(petEntity.getWeight());

	    // Asegurar que el ownerIdentification no sea null antes de asignarlo
	    if (petEntity.getOwnerIdentification() != null) {
	        pet.setOwnerIdentification(adapter(petEntity.getOwnerIdentification()));
	    }

	    return pet;
	}

	private Person adapter(PersonEntity ownerIdentification) {
		if (ownerIdentification == null) return null;

	    Person person = new Person();
	    person.setId(ownerIdentification.getId());
	    person.setName(ownerIdentification.getName());
	    person.setDocument(ownerIdentification.getDocument());
	    person.setAge(ownerIdentification.getAge());

	    return person;
	}

}
