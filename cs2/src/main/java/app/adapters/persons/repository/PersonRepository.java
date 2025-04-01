package app.adapters.persons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.adapters.person.entity.PersonEntity;
import app.domain.models.Person;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
	
	boolean existsByDocument(Person person);
	
	PersonEntity findByDocument(long document);
	
	public void deletePerson(Person person);
	
	public void savePerson(Person person);

}
