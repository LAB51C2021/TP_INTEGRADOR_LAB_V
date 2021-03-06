package src.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import models.Cuenta;
import models.Movimiento;
import models.Pais;
import models.Persona;
import models.Provincia;
import models.Tipo_Cuenta;
import models.Usuario;
import src.hibernate.ClienteHibernate;
import src.hibernate.HibernateConnector;
import src.services.EntityService;
import src.services.IEntityService;

@Configuration
public class Config 
{
	@Bean(name="personaService")
    public EntityService<Persona> getPersonaService() 
    {
        return new EntityService<Persona>(new Persona());
    }
	
	@Bean(name="cuentaService")
    public IEntityService<Cuenta> getCuentaService() 
    {
        return new EntityService<Cuenta>(new Cuenta());
    }
	
	@Bean(name="movimientoService")
    public IEntityService<Movimiento> getMovimientoService() 
    {
        return new EntityService<Movimiento>(new Movimiento());
    }
	
	@Bean(name="paisService")
    public IEntityService<Pais> getPaisService() 
    {
        return new EntityService<Pais>(new Pais());
    }
	
	@Bean(name="provinciaService")
    public IEntityService<Provincia> getProvinciaService() 
    {
        return new EntityService<Provincia>(new Provincia());
    }
	
	@Bean(name="tiposCuentaService")
    public IEntityService<Tipo_Cuenta> getTiposCuentaService() 
    {
        return new EntityService<Tipo_Cuenta>(new Tipo_Cuenta());
    }
    
    @Bean(name="usuarioService")
    public IEntityService<Usuario> getUsuarioService() 
    {
        return new EntityService<Usuario>(new Usuario());
    }

	@Bean(name="hibernateConnector")
    public HibernateConnector getHibernateConnector() 
    {
        return new HibernateConnector();
    }
}
