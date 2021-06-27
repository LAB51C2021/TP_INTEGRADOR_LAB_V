package hibernate;

import models.LogonUser;
import models.User;

public class UsuarioHibernate{

	public UsuarioHibernate()
	{
		
	}
	
	public LogonUser GetUserByCredentials(String name, String dni, String clave)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();		
		LogonUser user = hibernateConnector.GetUserByCredentials(LogonUser.class.getSimpleName(), name, clave);
		return user;
	}
	
	public User GetUsuario(int idUser)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return (User) hibernateConnector.GetRegistry(User.class.getName(), "Id_User = " + idUser + " AND Status = 'A'");
	}
}
