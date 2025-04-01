package app.domain.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class User extends Person {
	private long id;
	private String password;
	private String userName;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
