package uttoronPageclasses;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UttoronDonatePage extends UttoronBrowserOpen_Quit {

	WebDriverWait wait;
	Actions act;

	@FindBy(xpath = "//input[@name='submit']")
	WebElement Donatebutton;

	public void scrollToDonateButtonAndClick() throws InterruptedException {

		Point location = Donatebutton.getLocation();
		int y = location.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, -" + y + ")");
		Thread.sleep(2000);
		Donatebutton.click();
		System.out.println("Sucessfull Click on Donation Button!");
		Thread.sleep(2000);
	}

	public UttoronDonatePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		act = new Actions(driver);
	}

}
