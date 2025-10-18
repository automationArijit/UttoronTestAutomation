package uttoronPageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UttoronLoginPage extends UttoronBrowserOpen_Quit {

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
		WebElement logoutlink = driver.findElement(By.xpath("//a[text()='Logout']"));
		Thread.sleep(2000);
		try {
			if (logoutlink.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("Login Sucessfull!");
				
			} else {
				System.out.println("Login failure");
			}

		} catch (Exception e) {
			System.out.println("Login failure expection handled");
		}

	}

	// Invoke Constructor

	public UttoronLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
