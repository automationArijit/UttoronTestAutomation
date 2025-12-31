package uttoronPageclasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class SandboxPayPalPage extends UttoronSecurePaymentPayPalPage {

	WebDriverWait wait;
	Select sc;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//button[text()='Pay with Debit or Credit Card']")
	WebElement PayWithDebitCredit;
	@FindBy(xpath = "//input[@id='onboardingFlowEmail']")
	WebElement emailfield;
	@FindBy(xpath = "//button[text()='Continue to Payment']")
	WebElement continuetopayment;
	@FindBy(xpath = "//select[@id='country' and @name='country']")
	WebElement countrydropdown;
	@FindBy(xpath = "//input[@id='email' and @name='email']")
	WebElement billingemailfield;
	@FindBy(xpath = "//select[@id='phoneType' and @name='phoneType']")
	WebElement phonetype;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonenumber;
	@FindBy(xpath = "//input[@id='cardNumber' and @name='cardnumber']")
	WebElement cardnumber;
	@FindBy(xpath = "//input[@id='cardExpiry' and @name='exp-date']")
	WebElement cardexpiration;
	@FindBy(xpath = "//input[@id='cardCvv' and @name='cvv']")
	WebElement cvvnumber;
	@FindBy(xpath = "//input[@id='firstName' and @name='fname']")
	WebElement firstname;
	@FindBy(xpath = "//input[@id='lastName' and @name='lname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@id='billingLine1' and @name='billingLine1']")
	WebElement streetname;
	@FindBy(xpath = "//input[@id='billingCity' and @name='billingCity']")
	WebElement cityname;
	@FindBy(xpath = "//select[@id='billingState' and @name='billingState']")
	WebElement statename;
	@FindBy(xpath = "//input[@id='billingPostalCode' and @name='billingPostalCode']")
	WebElement zipcode;
	@FindBy(xpath = "//button[text()='Continue as Guest']")
	WebElement continueasguest;
	@FindBy(xpath = "//button[.='Continue']")
	WebElement continuebutton;
	@FindBy(xpath = "//button/a[.='Print Order']")
	WebElement printorder;
	@FindBy(xpath = "//input[@name='login_email' and @id='email']")
	WebElement paypalemail;
	@FindBy(xpath = "//button[@name='btnNext' and @id='btnNext']")
	WebElement paypalnextbutton;

	// h4[.='Your order has been placed successfully!']

	public SandboxPayPalPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// this.driver=driver;
//		WebElement cardbutton = driver.findElement(By.xpath("//button[text()='Pay with Debit or Credit Card']"));
//		cardbutton.click();

	}

	public void PayWithDebitCreditCard() {
		try {
		PayWithDebitCredit.click();
		Reporter.log("Clicking on the button : Pay with Debit or Credit Card!", true);
		}
		catch(Exception e)
		{
			Reporter.log("Pay with Debit/Credit Card button not displayed. Proceeding with PayPal email flow.", true);
			wait.until(ExpectedConditions.visibilityOf(paypalemail)).clear();
			paypalemail.sendKeys("watercolour.arijit@gmail.com");
			Reporter.log("Entered PayPal email address", true);
			paypalnextbutton.click();
			Reporter.log("Clicked on PayPal Next button", true);
			
		}
	}

	public void Email(String email) {
		try {
		emailfield.sendKeys(email);
		Reporter.log("Passing the email address: " + email, true);
		}
		catch(Exception e)
		{
			Reporter.log("No required to pass the email ");
		}
	}

	public void ContinueToPayment() {

		try {
	        wait.until(ExpectedConditions.elementToBeClickable(continuetopayment)).click();
	        Reporter.log("Clicked Continue to Payment button", true);
	    } catch (Exception e) {
	        Reporter.log("Continue to Payment button not present – skipping", true);
	    }
	}

	public void CountryDropdown(String country) {
		sc = new Select(countrydropdown);
		try {
		sc.selectByVisibleText(country);
		}
		catch(Exception e)
		{
			System.out.println("Dropdown exception handled");
		}
	}

	public void BillingEmailField() {
		try {
			//billingemailfield.sendKeys(billemail);
			System.out.println("billing email already pre-filled");
			}
			catch(Exception e)
			{System.out.println("billing exception handled");
			}
	}

	public void PhoneType(String phone) {
		sc = new Select(phonetype);
		try {
		sc.selectByVisibleText(phone);
		}
		catch(Exception e)
		{
			System.out.println("phonetype dropdown exception handled");
		}
	}

	public void PhoneNumber(String phnumber) {
		try {
		phonenumber.sendKeys(phnumber);
		}
		catch(Exception e)
		{
			phonenumber.sendKeys("601-908-0284");
		}
	}

	public void CardNumber(String cdnumber) {
		try {
		cardnumber.sendKeys(cdnumber);
		}
		catch(Exception e)
		{
			cardnumber.sendKeys("4032035320585193");
		}
	}

	public void CardExpiration(String expdate) {
		try {
		cardexpiration.sendKeys(expdate);
		}
		catch(Exception e)
		{
			cardexpiration.sendKeys("02/28");
		}
	}

	public void CVVNumber(String cvv) {
		try {
		cvvnumber.sendKeys(cvv);
		}
		catch(Exception e)
		{
			cvvnumber.sendKeys("523");
		}
	}

	public void FirstName(String fname) {
		try {
		firstname.sendKeys(fname);
		}
		catch(Exception e)
		{
			firstname.sendKeys("Arijit");
		}
	}

	public void LastName(String lname) {
		try {
		lastname.sendKeys(lname);
		}
		catch(Exception e)
		{
			lastname.sendKeys("Chatterjee");
		}
	}

	public void StreetName(String stname) {
		try {
		streetname.sendKeys(stname);
		}
		catch(Exception e)
		{
			streetname.sendKeys("1809 Washington Avenue");
		}
	}

	public void CityName(String ctname) {
		try {
		cityname.sendKeys(ctname);
		}
		catch(Exception e)
		{
			cityname.sendKeys("Morrow");
		}
	}

	public void StateName(String stname) {
		try {
		sc = new Select(statename);
		sc.selectByVisibleText(stname);
		}
		catch(Exception e)
		{
			System.out.println("Select statename dropdown-Exception handled.");
		}
	}

	public void ZipCode(String zip) {
		try {
		zipcode.sendKeys(zip);
		}
		catch(Exception e)
		{
			zipcode.sendKeys("10011");
		}
	}

	public void turnOffPayPalToggle() {

		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        
	        WebElement toggle = wait.until(ExpectedConditions
	                .presenceOfElementLocated(By.xpath("//input[@role='switch']")));

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        boolean isToggleOn = toggle.isSelected();
	        Reporter.log("Toggle initial state (isSelected): " + isToggleOn, true);

	        // if toggle is On then off the toggle.
	        if (isToggleOn) {
	            js.executeScript("arguments[0].click();", toggle);
	            Thread.sleep(1500);

	            // Re-checking
	            if (toggle.isSelected()) {
	                Assert.fail("PayPal toggle is still ON after clicking");
	            }

	            Reporter.log("PayPal toggle successfully turned OFF", true);
	        } else {
	        	Reporter.log("PayPal toggle already OFF", true);
	        }

	    } catch (Exception e) {
	        Assert.fail("Failed to turn OFF PayPal toggle → " + e.getMessage());
	    }
	}

	public void ContinueAsGuestButton() {
		continueasguest.click();
	}

	public void ContinueButton() throws InterruptedException, IOException {

		// Click Continue button
		wait.until(ExpectedConditions.elementToBeClickable(continuebutton)).click();
		Reporter.log("Clicked on Continue inside PayPal window!", true);
		Thread.sleep(10000);
		
		driver.switchTo().window(parentWindow);
		Reporter.log("Switched back to main window", true);
		
		String title = driver.getTitle();
		Reporter.log("page tittle: "+title, true);
//		Assert.assertTrue(true);
//		TakesScreenshot	ss=(TakesScreenshot) driver;//-----1
//		File source = ss.getScreenshotAs(OutputType.FILE);// ----2
//		File destination=new File("C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\Screenshot\\PaymentDone.png");// ----3
//		FileHandler.copy(source, destination);//-----4
//		Thread.sleep(1000);
		
	}
}
