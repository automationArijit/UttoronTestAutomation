package uttoronPageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UttoronRegisterPage extends UttoronBrowserOpen_Quit {
	
	// Finding elements
		@FindBy(name = "fname")
		WebElement RegisterPage_firstname;
		@FindBy(name = "lname")
		WebElement RegisterPage_lastname;
		@FindBy(name = "email")
		WebElement RegisterPage_email;
		@FindBy(name = "password")
		WebElement RegisterPage_password;
		@FindBy(xpath = "//input[@id='edit-submit']")
		WebElement RegisterPage_registerbutton;
		@FindBy(xpath = "//input[@type='text' and contains(@id, 'captcha')]")
	    WebElement captchaField;

		// Methods of elements
		public void registerUser(String fName, String lName, String emailId, String pass) {
			RegisterPage_firstname.sendKeys(fName);
			RegisterPage_lastname.sendKeys(lName);
			RegisterPage_email.sendKeys(emailId);
			RegisterPage_password.sendKeys(pass);

	        System.out.println("Enter CAPTCHA manually within 15 seconds...");
	        try {
	            Thread.sleep(15000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        RegisterPage_registerbutton.click();
		}

		// Invoke Constructor

		public UttoronRegisterPage(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}

}
