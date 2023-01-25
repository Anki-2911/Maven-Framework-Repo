package Com.Ecommerce.BaseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.Ecommerce.Configuration.ReadConfiguration;
import Com.Ecommerce.Utilities.TestUtils;
import net.bytebuddy.utility.RandomString;

public class Ecommerce_BaseClass 
{
	ReadConfiguration object = new ReadConfiguration();
	public String BaseURL = object.getURL();
	public String MailId = object.getMailId();
	public String Password = object.getPassword();
	public String ChromePath = object.getChromePath();
	
	

	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("Browser")
	
	@BeforeMethod
	public void setup(String BrowserName) throws InterruptedException
	{
		logger = logger.getLogger("Maven Framework");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(BrowserName.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", ChromePath );
			driver =new ChromeDriver();
		}
		else if(BrowserName.equals("Firefox")) 
		{
			driver =new FirefoxDriver();
		}
		else if(BrowserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\installer\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		
		
	    driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_Wait,TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(TestUtils.Page_Load_TimeOut,TimeUnit.SECONDS);
	    driver.get(BaseURL);
	    
	    Thread.sleep(5000);
	    }
	
		public String getScreenshotAs(String TestCasename) throws IOException {		
		
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	String Name = "- Screenshot -"+Timestamp;

		String destination = System.getProperty("user.dir") + "/Screenshot/" + TestCasename + "" + Name + ".png";

		FileUtils.copyFile(source, new File(destination));

		return destination;
	    	
	    	
	    }
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
	
	

}
