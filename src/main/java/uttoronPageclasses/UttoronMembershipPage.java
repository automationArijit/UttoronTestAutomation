package uttoronPageclasses;

import org.openqa.selenium.Point;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class UttoronMembershipPage extends UttoronBrowserOpen_Quit {
	
	WebDriverWait wait;
	Actions act;
	Select sc;
	
	
	@FindBy(xpath = "//button[.='Finish & Pay']")
    WebElement memberSection;
	
	@FindBy(xpath = "//select[@id='m_type' and @name='m_type[]']")
    WebElement membershipType;

    @FindBy(xpath = "//select[@id='age_group' and @name='age_group[]']")
    WebElement ageGroup;

    @FindBy(xpath = "//input[@id='fname' and @name='fname[]']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='lname' and @name='lname[]']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='email' and @name='email[]']")
    WebElement email;

    @FindBy(xpath = "//button[.='Finish & Pay']")
    WebElement finishAndPayBtn;

    public UttoronMembershipPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   
    public void selectMemberAndProceedToPay(
            String memberType,
            String ageGrp,
            String fname,
            String lname,
            String emailId) throws InterruptedException {

        // Scroll to Member section
        Point location = memberSection.getLocation();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0])", location.getY() - 200);
        Thread.sleep(1500);

        System.out.println("Scrolled to Member section");

        // Membership Type
        wait.until(ExpectedConditions.visibilityOf(membershipType));
        sc = new Select(membershipType);
        sc.selectByVisibleText(memberType);
        Reporter.log(" Selected Membership Type: " + memberType, true);

        // Age Group
        sc = new Select(ageGroup);
        sc.selectByVisibleText(ageGrp);
        Reporter.log(" Selected Age Group: " + ageGrp, true);

        // First Name
        firstName.clear();
        firstName.sendKeys(fname);
        Reporter.log("Entered First Name: "+fname, true);

        // Last Name
        lastName.clear();
        lastName.sendKeys(lname);
        Reporter.log("Entered Last Name: "+lname, true);

        // Email
        email.clear();
        email.sendKeys(emailId);
        Reporter.log("Entered Email: "+emailId, true);

        // Finish & Pay
        wait.until(ExpectedConditions.elementToBeClickable(finishAndPayBtn)).click();
        Reporter.log("Clicked Finish & Pay", true);
    }

}
