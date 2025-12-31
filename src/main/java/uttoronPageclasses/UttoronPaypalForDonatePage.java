package uttoronPageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UttoronPaypalForDonatePage extends UttoronBrowserOpen_Quit {

	WebDriverWait wait;
	Actions act;

	@FindBy(xpath = "//input[@type='tel' or @name='amount']")
	WebElement donationAmount;

	@FindBy(xpath = "//button[contains(.,'Donate with PayPal')]")
	WebElement donationWithPayPalButton;
	
	
	public void switchToPayPalWindow() {

	    String parent = driver.getWindowHandle();

	    new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(d -> d.getWindowHandles().size() > 1);

	    for (String win : driver.getWindowHandles()) {
	        if (!win.equals(parent)) {
	            driver.switchTo().window(win);
	            driver.manage().window().maximize();
	            break;
	        }
	    }

	    System.out.println("✔ Switched to PayPal window: " + driver.getCurrentUrl());
	}

	
	
	
	
	
	

	public void enterDonationAmountAndDonate(String amount) {

	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        // 1️⃣ Wait for PayPal iframe
	        WebElement paypalFrame = wait.until(
	            ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//iframe[contains(@src,'paypal.com/donate')]")
	            )
	        );

	        // 2️⃣ Switch to iframe
	        driver.switchTo().frame(paypalFrame);
	        System.out.println("✔ Switched to PayPal donation iframe");

	        // 3️⃣ Wait for amount field
	        wait.until(ExpectedConditions.visibilityOf(donationAmount));

	        donationAmount.clear();
	        donationAmount.sendKeys(amount);
	        System.out.println("✔ Entered donation amount: $" + amount);

	        // 4️⃣ Click Donate with PayPal
	        wait.until(ExpectedConditions.elementToBeClickable(donationWithPayPalButton)).click();
	        System.out.println("✔ Clicked Donate with PayPal button");

	        // Optional: switch back to main page if needed
	        driver.switchTo().defaultContent();

	    } catch (Exception e) {
	        Assert.fail("❌ Donation flow failed: " + e.getMessage());
	    }
	}


	
	//Constructor
	public UttoronPaypalForDonatePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		act = new Actions(driver);
	}

}
