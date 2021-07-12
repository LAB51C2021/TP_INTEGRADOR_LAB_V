package core;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.BeanConfig;
import models.Usuario;
import src.hibernate.HibernateConnector;

public abstract class HibernateLoad 
{
	public static void LoadFilesXml(List<FileXml<?>> fileXmlList)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		
		for (FileXml<?> fileXml : fileXmlList)
		{
			ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(fileXml.getNameFileXml());
			
			for (Object object : applicationContext.getBeansOfType(fileXml.getType()).values())
			{
				hibernateConnector.AddEntity(object);
			}

			applicationContext.close();
		}
		
		hibernateConnector.SaveChange();
	}

	public static void LoadClassConfig(List<Class<?>> classConfigList)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		
		for (Class<?> classType : classConfigList)
		{
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class); 

			for (Object object : applicationContext.getBeansOfType(classType).values())
			{
				hibernateConnector.AddEntity(object);
			}

			applicationContext.close();
		}
		
		hibernateConnector.SaveChange();
	}
}
