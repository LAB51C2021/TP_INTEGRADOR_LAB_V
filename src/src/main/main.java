package src.main;

import java.util.ArrayList;
import java.util.List;

import core.FileXml;
import core.HibernateLoad;
import models.Movimiento;
import models.Pais;
import models.Provincia;
import models.Tipo_Cuenta;
import models.Tipo_Movimiento;
import models.Usuario;

public class main 
{
	public static void main(String[] args) 
	{
		CargarBeansHibernateXml();
		CargarBeansHibernateClassConfig();
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
		classConfigList.add(Movimiento.class);
		HibernateLoad.LoadClassConfig(classConfigList);
	}
}
