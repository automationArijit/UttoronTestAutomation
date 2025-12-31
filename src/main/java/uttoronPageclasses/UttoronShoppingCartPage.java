package uttoronPageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UttoronShoppingCartPage extends UttoronBrowserOpen_Quit {

	WebDriverWait wait;
	Actions act;

	@FindBy(xpath = "//table//input[@type='number']")
	WebElement quantityInput;
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkoutButton;
	@FindBy(xpath = "//a[contains(text(),'Continue Shopping')]")
	WebElement continueShoppingLink;
	@FindBy(xpath = "//button[contains(text(),'Update Cart')]")
	WebElement updateCartButton;

	// Enter quantity
	public void updateQuantity(String qty) {
		quantityInput.clear();
		quantityInput.sendKeys(qty);
	}

	// Click Update Cart
	public void clickUpdateCart() {
		updateCartButton.click();
	}
	// Click Checkout
    public void clickCheckout() throws InterruptedException {
        checkoutButton.click();
        Thread.sleep(2000);
    }
 // Click Continue Shopping
    public void clickContinueShopping() {
        continueShoppingLink.click();
    }
    

	public UttoronShoppingCartPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		act = new Actions(driver);
	}

}
