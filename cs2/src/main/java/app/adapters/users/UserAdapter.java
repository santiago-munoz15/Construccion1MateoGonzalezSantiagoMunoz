package app.adapters.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.user.entity.UserEntity;
import app.adapters.users.repository.UserRepository;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class UserAdapter implements UserPort {
	@Autowired
	private UserRepository userRepository;
	private List<User> userList = new ArrayList<>();

	@Override
	public User findByUserName(User user) throws Exception {
		UserEntity userEntity = userRepository.findByUserName(user.getUserName());
		if (userEntity == null){
			return null;
		}
		return userAdapter(userEntity);
	}


	@Override
	public boolean existsByUserName(String userName) throws Exception {
		return userRepository.existsByUserName(userName);
	}

	@Override
	public void createUser(User user) throws Exception {
		for (User u : userList) {
	        if (u.getUserName().equals(user.getUserName())) {
	            throw new Exception("Ya existe un usuario con ese nombre de usuario.");
	        }
	    }
	    
	    userList.add(user);
		
	}
	
	private User userAdapter(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}
		User user = new User();
		user.setDocument(userEntity.getPersonId().getDocument());
		user.setName(userEntity.getPersonId().getName());
		user.setUserName(userEntity.getUserName());
		user.setPassword(userEntity.getPassword());
		user.setRole(userEntity.getRole());
		user.setId(userEntity.getPersonId().getId());
		return user;
	}


	@Override
	public void saveUser(User user) throws Exception {
		for (User u : userList) {
	        if (u.getUserName().equals(user.getUserName())) {
	            throw new Exception("Ya existe un usuario con ese nombre de usuario.");
	        }
	    }
	    userList.add(user);
		
	}


	@Override
	public User findByPersonId(Person person) throws Exception {
		for (User user : userList) {
	        if (user.getId() == person.getId()) { 
	            return user;
	        }
	    }
	    throw new Exception("No existe un usuario asociado a esa persona.");
	}


	@Override
	public void deleteUser(User user) throws Exception {
		boolean removed = userList.removeIf(u -> u.getUserName().equals(user.getUserName()));
	    if (!removed) {
	        throw new Exception("No se encontró el usuario para eliminar.");
	    }
		
	}
	

}
