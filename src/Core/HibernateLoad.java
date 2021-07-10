package Core;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hibernate.HibernateConnector;

public abstract class HibernateLoad 
{
	public static void LoadFilesXml(List<FileXml<?>> fileXmlList)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		
		for (FileXml<?> fileXml : fileXmlList)
		{
			ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext(fileXml.getNameFileXml());
			
			for (Object object : contexto.getBeansOfType(fileXml.getType()).values())
			{
				hibernateConnector.AddEntity(object);
			}

			contexto.close();
		}
		
		hibernateConnector.SaveChange();
	}
}
