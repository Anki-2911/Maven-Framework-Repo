package Com.Ecommerce.TestCases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClass.TC_Ecommerce_LoginPage;

public class TC_LoginTestCases extends Ecommerce_BaseClass 
{ 

	@Test
	public void Login() throws InterruptedException, IOException 
	{
		logger.info("Open Url");
		TC_Ecommerce_LoginPage obj = new TC_Ecommerce_LoginPage();
		
		obj.email(MailId);
		logger.info("Enter MailID");
		
		obj.pass(Password);
		logger.info("Enter Password");
		
		obj.submit();
		logger.info("Click on Login");
		
		obj.getScreenshotAs("opencart");
		logger.info("Screenshot taken");
	}
	
}
	
	
	



