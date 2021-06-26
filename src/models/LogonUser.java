package models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class LogonUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public LogonUser() {
		super();
	}

	public LogonUser(User user, String userName, String password) {
		this.User = user;
		UserName = userName;
		Password = password;
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(unique=true)
	private String UserName;
	
	@Column
	private String Password;

	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="Id_User")
	private User User;
	
	@Column
	private String Status = "A";

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
