package uttoronPageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='Membership']")
    WebElement headerMembership;

    @FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='Events']")
    WebElement headerEvents;

    @FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='YOU']")
    WebElement headerYou;

    @FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='Resources']")
    WebElement headerResources;

    @FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='Fund Raising']")
    WebElement headerFundRaising;

    @FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='About Us']")
    WebElement headerAboutUs;

    @FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li/a[text()='Gallery']")
    WebElement headerGallery;
    
 // Sponsor link inside Fund Raising
    @FindBy(xpath = "//nav[@id='block-uttoron-main-menu']//ul/li[a[text()='Fund Raising']]//a[text()='Sponsor']")
    WebElement sponsorLink;
    
	// Methods of elements
	public void Homepage_LoginLink() {
		//Homepage_loginlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(Homepage_loginlink));
		Homepage_loginlink.click();
        System.out.println("Navigated to Login page!");
	}
	public void Homepage_RegisterLink() {
		//Homepage_registerlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(Homepage_registerlink));
		Homepage_registerlink.click();
        System.out.println("Navigated to Registration page!");
	}
	
	// Specific action: Hover On Fund Raising then Click Sponsor
    public void clickSponsorUnderFundRaising() {
        act.moveToElement(headerFundRaising).perform();
        wait.until(ExpectedConditions.visibilityOf(sponsorLink));
        System.out.println("\n Clicking on 'Sponsor' under 'Fund Raising'...");
        sponsorLink.click();
    }

	// Invoke Constructor

	public UttoronHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);

	}

}
