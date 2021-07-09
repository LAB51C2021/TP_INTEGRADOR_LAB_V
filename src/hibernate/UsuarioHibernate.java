package hibernate;

import models.Usuario;

public class UsuarioHibernate
{	
	public Usuario GetUserByCredentials(String name, String dni, String clave)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();		
		Usuario user = hibernateConnector.GetUserByCredentials(name, dni, clave);

		return user;
	}
	
	public Usuario GetUsuario(int idUser)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return (Usuario) hibernateConnector.GetRegistry(Usuario.class.getSimpleName(), "Id_User = " + idUser + " AND Status = 'A'");
	}
}
