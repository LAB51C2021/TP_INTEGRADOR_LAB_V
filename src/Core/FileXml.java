package Core;

public class FileXml<T>
{
	private String NameXml;
	private Class<T> Type;
	
	public FileXml(String nameXml, Class<T> type)
	{
		this.NameXml = nameXml;
		this.Type = type;
	}
	
	public String getNameFileXml()
	{
		return NameXml;
	}
	
	public String getTypeName()
	{
		return Type.getName();
	}
	
	public Class<T> getType()
	{
		return Type;
	}
}
