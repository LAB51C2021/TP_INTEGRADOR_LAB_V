package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class LogonUser {

	// Campos
	@Id
	@Column
	private int Id_User;

	@Column(unique=true)
	private String UserName;
	
	@Column
	private String Password;

	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="Id_User")
	private User User;

	public String getUserName() {
		return UserName;
	}

	public String getPassword() {
		return Password;
	}

	public User getUser() {
		return User;
	}
	
	
}
