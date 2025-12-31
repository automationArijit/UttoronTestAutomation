package uttoronPageclasses;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class UttoronSecurePaymentPayPalPage extends UttoronBrowserOpen_Quit {

	WebDriverWait wait;

	@FindBy(xpath = "//div[@aria-label='PayPal Checkout']")
	WebElement paypalbutton;

	// Click on PayPal button.
	public void ClickPayPalButton() {

Reporter.log("Waiting for PayPal iframe...", true);
		try {
			// Switching the iFrame.
			wait.until(
					ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@src,'paypal')]")));
			Reporter.log("Inside PayPal iframe. Looking for button...", true);
			// locating the PayPal button.
			By paypalBtn = By.xpath("//div[@role='button' and contains(@aria-label,'PayPal')]");
			WebElement button = wait.until(ExpectedConditions.elementToBeClickable(paypalBtn));
			Reporter.log("PayPal button visible, clicking...", true);
			String title = driver.getTitle();
			Assert.assertEquals(title, "Uttoron | Payment", "Page tittle is not correct!");
			button.click();
			Reporter.log(" PayPal button clicked successfully.", true);
		} catch (Exception e) {
			Reporter.log("PayPal button is not visible, unable to click!", true);
		}
	}

	public void switchingToPayPal() {
		 parentWindow = driver.getWindowHandle();

		// Wait until another window appears
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.getWindowHandles().size() > 1);

		// Switch to newly opened PayPal window
		for (String win : driver.getWindowHandles()) {
			if (!win.equals(parentWindow)) {
				driver.switchTo().window(win);
				driver.manage().window().maximize();
				
			}
		}

		Reporter.log("Switched to PayPal Window " + driver.getTitle(), true);
	}

	public UttoronSecurePaymentPayPalPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

}
