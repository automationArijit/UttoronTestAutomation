package uttoronPageclasses;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class UttoronSecureCheckoutPage extends UttoronBrowserOpen_Quit {

	WebDriverWait wait;

	@FindBy(xpath = "//button[@name='submit' and @ id='place_order']")
	WebElement proceedtopay;

	// Click proceed to pay
	public void ProceedToPayButton() throws InterruptedException {
		
		Point location = proceedtopay.getLocation();
		int y = location.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, -" + y + ")");
		Thread.sleep(2000);
		proceedtopay.click();
		Reporter.log("Clicked on Proceed to Pay!", true);
	}

	public UttoronSecureCheckoutPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

}
