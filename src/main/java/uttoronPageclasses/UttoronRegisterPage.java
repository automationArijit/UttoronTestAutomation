package uttoronPageclasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class UttoronRegisterPage extends UttoronBrowserOpen_Quit {

	WebDriverWait wait;

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
	@FindBy(xpath = "//div[contains(@class,'messages') and contains(@class,'warning')]//h2")
	WebElement alreadyregistermsg;

	// div[contains(@class,'messages') and contains(@class,'warning')]//h2

	// Methods of elements
	public void registerUser(String fName, String lName, String emailId, String pass) {
		try {
			RegisterPage_Firstname(fName);
			RegisterPage_Lastname(lName);
			RegisterPage_Email(emailId);
			RegisterPage_Password(pass);

			System.out.println("Enter CAPTCHA manually within 15 seconds...");

			Thread.sleep(15000);
			RegisterPage_RegisterButton();

			wait.until(ExpectedConditions.visibilityOf(alreadyregistermsg));

			if (alreadyregistermsg.isDisplayed()) {
				Reporter.log("You are already registered message is displayed.", true);
			}
			Reporter.log("Clicked on Register button!", true);

		} catch (InterruptedException e) {

			Reporter.log("The answer you entered for the CAPTCHA was not correct./ unable to click on register button.",
					true);
		}

	}

	public void RegisterPage_RegisterButton() {
		Assert.assertTrue(RegisterPage_registerbutton.isDisplayed(), "Register button is not displayed");
		System.out.println("Register button is displayed!");
		RegisterPage_registerbutton.click();
		Reporter.log("Clicked on Register button!", true);
	}

	// excel data fetch for registration.

	public void RegisterPage_Firstname(String firstname) {
		Assert.assertTrue(RegisterPage_firstname.isDisplayed());
		Reporter.log("firstname textfield displayed! : " + firstname, true);
		RegisterPage_firstname.sendKeys(firstname);

	}

	public void RegisterPage_Lastname(String lastname) {
		Assert.assertTrue(RegisterPage_lastname.isDisplayed());
		Reporter.log("lastname textfield displayed! : " + lastname, true);
		RegisterPage_lastname.sendKeys(lastname);
	}

	public void RegisterPage_Email(String email) {
		Assert.assertTrue(RegisterPage_email.isDisplayed());
		Reporter.log("email textfield displayed! : " + email, true);
		RegisterPage_email.sendKeys(email);
	}

	public void RegisterPage_Password(String password) {
		Assert.assertTrue(RegisterPage_password.isDisplayed());
		System.out.println("password textfield displayed!");
		RegisterPage_password.sendKeys(password);
	}

	public void capchaHandle() throws IOException, TesseractException, InterruptedException {

		WebElement capchaImg = driver.findElement(By.xpath("//img[contains(@src,'image_captcha')]"));
		wait.until(ExpectedConditions.visibilityOf(capchaImg));

		File src = capchaImg.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshot/capchaImage.png";

		FileHandler.copy(src, new File(path));

		ITesseract image = new Tesseract();

		String imageText = image.doOCR(new File(path));

		String finalText = imageText.split("below")[1].replaceAll("[^a-zA-Z0-9]", "");

		System.out.println("Final Captcha is " + finalText);
		wait.until(ExpectedConditions.visibilityOf(captchaField));
		captchaField.sendKeys(finalText);

	}

	// Invoke Constructor

	public UttoronRegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

}
