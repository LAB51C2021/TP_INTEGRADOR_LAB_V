package src.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import src.hibernate.ClienteHibernate;
import src.hibernate.HibernateConnector;
import src.services.ClienteServiceInterface;
import src.servicesImplementation.ClienteService;

@Configuration
public class Config {

	@Bean(name="clienteHibernate")
	public ClienteHibernate getClienteHibernate() 
	{
		return new ClienteHibernate();
	}
	
	@Bean(name="clienteService")
    public ClienteService getClienteService() 
    {
        return new ClienteService();
    }
}
