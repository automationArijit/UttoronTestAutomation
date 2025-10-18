package uttoronPageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class UttoronBrowserOpen_Quit {

	public static WebDriver driver;

	@BeforeMethod
	public void browserOpen() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://uttoron.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Assert.assertTrue(driver.getTitle().length() > 0, "Browser Launch Failed");
		System.out.println("Browser launched successfully: " + driver.getTitle());
	}

	@AfterMethod
	public void browserClose() {

		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed successfully!");

		}
	}

}
