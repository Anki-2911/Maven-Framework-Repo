package Com.Ecommerce.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;



public class TC_Ecommerce_LoginPage extends Ecommerce_BaseClass 
{
	
	
	public TC_Ecommerce_LoginPage ()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-email")
	public WebElement mail;
	
	@FindBy(id="input-password")
	public WebElement password;
	
	@FindBy(xpath  = "//*[@class=\"btn btn-primary btn-lg hidden-xs\"]")
	public WebElement Submit;
	
	
	
	public void email(String mailid) 
	{
		
		mail.sendKeys(mailid);
	}
	
	public void pass(String passWord)
	{
		password.sendKeys(passWord);
	}
	
	public void submit() throws InterruptedException
	{
		
		Submit.click();
	}
	
	
	
}
