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
import org.testng.Reporter;

public class UttoronHomePage extends UttoronBrowserOpen_Quit {

	WebDriverWait wait;
	Actions act;

	// Finding elements
	@FindBy(xpath = "//a[text()='Login']")
	WebElement Homepage_loginlink;
	@FindBy(xpath = "//a[text()='Register']")
	WebElement Homepage_registerlink;

	// Header Menus
	@FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='Charter']")
	WebElement headerCharter;

	@FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='Events']")
	WebElement headerEvents;

	@FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='YOU']")
	WebElement headerYou;

	@FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='Resources']")
	WebElement headerResources;

	@FindBy(xpath = "//ul/li/a[text()='Fund Raising']")
	WebElement headerFundRaising;

	@FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='About Us']")
	WebElement headerAboutUs;

	@FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='Gallery']")
	WebElement headerGallery;

	// Sponsor link inside Fund Raising
	@FindBy(xpath = "//ul/li/a[text()='Fund Raising']/../ul/li/a[text()='Sponsor']")
	WebElement sponsorLink;

	// Sponsor link inside Fund Raising
	@FindBy(xpath = "//ul/li/a[text()='Fund Raising']/../ul/li/a[text()='Donate']")
	WebElement donateLink;

	@FindBy(xpath = "(//a[contains(text(),'Cart')])[1]")
	WebElement Homepage_cartLink;

	@FindBy(xpath = "(//a[contains(text(),'Membership')])[1]")
	WebElement headerMembership;

	@FindBy(xpath = "//a[normalize-space()='Become a Member']")
	WebElement becomeMemberLink;
	//
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkoutButton;

	// Methods of elements
	public void Homepage_LoginLink() {
		// Homepage_loginlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(Homepage_loginlink));
		Homepage_loginlink.click();
		Reporter.log("Navigated to Login page!", true);
	}

	public void Homepage_RegisterLink() {
		// Homepage_registerlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(Homepage_registerlink));
		Homepage_registerlink.click();
		Reporter.log("Navigated to Registration page!", true);
	}

	// Specific action: Hover On Fund Raising then Click Sponsor
	public void clickSponsorUnderFundRaising() {
		act.moveToElement(headerFundRaising).perform();
		wait.until(ExpectedConditions.visibilityOf(sponsorLink));
		Reporter.log("\n Clicking on 'Sponsor' under 'Fund Raising'...", true);
		sponsorLink.click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Uttoron | Sponsorship 2025");
		Reporter.log("The tittle of the page is: " + title, true);
	}

	// Specific action: Hover On Fund Raising then Click Donate
	public void clickDonateUnderFundRaising() {
		act.moveToElement(headerFundRaising).perform();
		wait.until(ExpectedConditions.visibilityOf(donateLink));
		Reporter.log("\n Clicking on 'Donate' under 'Fund Raising'...", true);
		donateLink.click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Uttoron | Donate");
		Reporter.log("The tittle of the page is: " + title, true);
	}

	public void clickBecomeMemberUnderMembership() {

		act.moveToElement(headerMembership).perform();
		wait.until(ExpectedConditions.visibilityOf(becomeMemberLink));

		Reporter.log("\n Clicking on 'Become a Member' under 'Membership'...", true);
		becomeMemberLink.click();

		String title = driver.getTitle();
		Assert.assertEquals(title, "Uttoron | Become a member");
		Reporter.log("The title of the page is: " + title, true);
	}

	public void cartLink() {
		WebElement freshCartLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Cart')])[1]")));

		freshCartLink.click();
		Reporter.log("Clicking on Cart link!", true);

		try {
			if (checkoutButton.isDisplayed()) {
				Reporter.log("Landing on Shopping Cart page.",true);
			}
		} catch (Exception e) {
			Reporter.log("You can buy up to 6 number of item(s).\n"
					+ "After clicking on the Cart link, 'Your cart is empty' is displayed.", true);
		}

	}

	// Invoke Constructor
	public UttoronHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		act = new Actions(driver);

	}

}
