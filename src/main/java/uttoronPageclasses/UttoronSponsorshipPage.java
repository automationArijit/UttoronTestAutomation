package uttoronPageclasses;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UttoronSponsorshipPage extends UttoronBrowserOpen_Quit {

    WebDriverWait wait;
    Actions act;
    JavascriptExecutor js;

    @FindBy(xpath = "//input[contains(@nid, '748')]")
    WebElement quarterPageInput;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
    WebElement addToCartButton;

    public UttoronSponsorshipPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public void selectQuarterPageAndAddToCart(String quantity) {

        try {
            // Scroll input into CENTER of viewport
            js.executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
                quarterPageInput
            );
            Thread.sleep(1000);

            wait.until(ExpectedConditions.visibilityOf(quarterPageInput));
            quarterPageInput.clear();
            quarterPageInput.sendKeys(quantity,Keys.ENTER);
            Thread.sleep(1000);
          		
			
            System.out.println("Quarter Page added to cart successfully");

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to add Quarter Page to cart → " + e.getMessage());
        }
    }
}
