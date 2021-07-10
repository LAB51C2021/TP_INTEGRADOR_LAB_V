package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.BeanConfig;
import core.FileXml;
import core.HibernateLoad;
import hibernate.HibernateConnector;
import models.Persona;
import models.Cuenta;
import models.Movimiento;
import models.Pais;
import models.Provincia;
import models.Tipo_Cuenta;
import models.Tipo_Movimiento;
import models.Usuario;

public class main {

	public static void main(String[] args) 
	{
		CargarBeansHibernateXml();
		CargarBeansHibernateClassConfig();
		CargarDatosHibernate(); // Quitar cuando se implemente el Bean de movimientos.
	}
	
	public static void CargarBeansHibernateXml()
	{
		List<FileXml<?>> fileXmlList = new ArrayList<FileXml<?>>();
		fileXmlList.add(new FileXml<Tipo_Cuenta>("beans/BeanTipoCuenta.xml", Tipo_Cuenta.class));
		fileXmlList.add(new FileXml<Tipo_Movimiento>("beans/BeanTipoMovimiento.xml", Tipo_Movimiento.class));
		fileXmlList.add(new FileXml<Provincia>("beans/BeanProvincia.xml", Provincia.class));
		fileXmlList.add(new FileXml<Pais>("beans/BeanPais.xml", Pais.class));

		HibernateLoad.LoadFilesXml(fileXmlList);
	}
	
	public static void CargarBeansHibernateClassConfig()
	{
		List<Class<?>> classConfigList = new ArrayList<Class<?>>();
		classConfigList.add(Usuario.class);
		//classConfigList.add(Movimiento.class); // FALTA AGREGAR AL BEANCONFIG LOS MOVIMIENTO para poder cargarlos por medio de Beans.
		HibernateLoad.LoadClassConfig(classConfigList);
	}
	
	public static void CargarDatosHibernate()
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 1, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 2, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 3, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 4, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 5, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 6, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 7, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 8, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 9, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 10, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 2500, 2, 1, 2));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 2500, 3, 2, 1));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 1200, 2, 5, 6));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 1200, 3, 6, 5));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 8000, 2, 3, 7));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 8000, 3, 7, 3));
		
		hibernateConnector.SaveChange();
	}
}
