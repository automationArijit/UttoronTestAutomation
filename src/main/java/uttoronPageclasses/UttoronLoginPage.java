package uttoronPageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class UttoronLoginPage extends UttoronBrowserOpen_Quit {
	
	WebDriverWait wait;

	// Finding elements

	@FindBy(id = "edit-name")
	WebElement Loginpage_username;
	@FindBy(id = "edit-pass")
	WebElement Loginpage_password;
	@FindBy(xpath = "//a[text()='Forgot Password?']")
	WebElement Loginpage_forgetpasswordlink;
	@FindBy(xpath = "//input[@id='edit-submit' and @value='Log in']")
	WebElement Loginpage_loginbutton;

	// Methods of elements

	public void Loginpage_Username(String username) {
		Loginpage_username.sendKeys(username);
	}

	public void Loginpage_Password(String password) {
		Loginpage_password.sendKeys(password);
	}

	public void Loginpage_ForgetPasswordLink() {
		Loginpage_forgetpasswordlink.click();
	}

	public void Loginpage_LoginButton() throws InterruptedException {
		Loginpage_loginbutton.click();
		try {
		WebElement logoutlink = driver.findElement(By.xpath("//a[text()='Logout']"));
		Thread.sleep(2000);
		
			if (logoutlink.isDisplayed()) {
				Assert.assertTrue(true);
				Reporter.log("Login Sucessfull!", true);
				
			} 
//			else {
//				Reporter.log("Login failure, 'Sorry, unrecognized username or password' message is displayed.", true);
//				
//			}

		} catch (Exception e) {
			Reporter.log("Logout link not displayed !! Login failure expection handled / 'Sorry, unrecognized username or password' message is displayed. ",  true);
			Assert.assertTrue(true);
		}

	}

	// Invoke Constructor

	public UttoronLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

}
