package Com.Ecommerce.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration 
{
	public static Properties pro;
	
	public ReadConfiguration() 
	{
	File src = new File("C:\\Users\\parag\\eclipse-workspace\\MavenFramework\\src\\main\\java\\Com\\Ecommerce\\Configuration\\Config.properties");
	FileInputStream files;
	
	try {
		files=new FileInputStream(src);
		pro = new Properties();
		try {
			pro.load(files);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	}
	public String getURL()
	{
		String Url =pro.getProperty("BaseURL");
		
		return Url;
	}
	public String getMailId()
	{
		String mail =pro.getProperty("MailId");
		
		return mail;
	}
	public String getPassword()
	{
		String pass =pro.getProperty("Password");
		
		return pass;
	}
	
	public String getChromePath()
	{
		String path =pro.getProperty("ChromePath");
		
		return path;
	}
	
	public String getFirefoxPath()
	{
		String path1 =pro.getProperty("FirefoxPath");
		
		return path1;
	}
	
	public String getEdgePath()
	{
		String path2 =pro.getProperty("EdgePath");
		
		return path2;
	}
	
	

}
