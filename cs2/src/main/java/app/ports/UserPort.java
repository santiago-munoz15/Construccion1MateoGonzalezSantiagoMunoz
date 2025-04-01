package app.ports;

import app.domain.models.Person;
import app.domain.models.User;

public interface UserPort {
	public User findByUserName(User user) throws Exception;
	public boolean existsByUserName(String userName) throws Exception;
	public void createUser(User user) throws Exception;
	public void saveUser(User user) throws Exception;
	public User findByPersonId(Person person) throws Exception;
	public void deleteUser(User user) throws Exception;

}
