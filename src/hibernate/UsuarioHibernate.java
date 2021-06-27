package hibernate;

import models.LogonUser;
import models.User;

public class UsuarioHibernate {

	public UsuarioHibernate()
	{
		
	}
	
	public Long GetUserId(String name, String dni, String clave)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		Long id = hibernateConnector.RegistryId("Id_User", LogonUser.class.getName(), "UserName = '" + name + "' AND Password = '" + clave + "' AND Status = 'A'");
		return id;
	}
	
	public User GetUsuario(Long idUser)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return (User) hibernateConnector.GetRegistry(User.class.getName(), "Id_User = " + idUser + " AND Status = 'A'");
	}
}
