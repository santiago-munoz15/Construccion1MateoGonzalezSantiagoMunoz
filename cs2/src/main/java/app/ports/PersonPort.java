package app.ports;

import app.domain.models.Person;

public interface PersonPort {
	public boolean existsByDocument(Person person) throws Exception;
	public void createPerson(Person person) throws Exception;
	public void deletePerson(Person person) throws Exception;
	public Person findByDocument(long document) throws Exception;
	public boolean existPerson(long document) throws Exception;
	public void savePerson(Person person) throws Exception;
	public void updatePerson(Person person) throws Exception;

}
