package uttoronPageclasses;

import java.time.Duration;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class UttoronBrowserOpen_Quit extends UttoronTestListener {

	//public static WebDriver driver;
	public static String parentWindow;
	

	@BeforeMethod
	@Parameters("browser")
	public void browserOpen(@Optional("chrome") String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("chrome")) {
	        driver = new ChromeDriver();
	    } else if (browser.equalsIgnoreCase("firefox")) {
	        driver = new FirefoxDriver();
	    } else if (browser.equalsIgnoreCase("edge")) {
	        driver = new EdgeDriver();
	    }
		driver.get("https://uttoron.dcsdev.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Assert.assertTrue(driver.getTitle().length() > 0, "Browser Launch Failed");
		Reporter.log("Browser launched successfully: " + driver.getTitle(),true);
	}

	@AfterMethod
	public void browserClose() {

		if (driver != null) {
			driver.quit();
			Reporter.log("Browser closed successfully!",true);

		}
	}

}
