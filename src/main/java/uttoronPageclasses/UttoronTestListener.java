package uttoronPageclasses;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class UttoronTestListener implements ITestListener {
	
	public static WebDriver driver;
	

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		 TakesScreenshot t= (TakesScreenshot) driver;//Upcasting
         File source= t.getScreenshotAs(OutputType.FILE); // source of the screenshot
         File destination = new File("C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\Screenshot\\Pass\\PassCase"+Math.random()+".png");
         try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		 TakesScreenshot t= (TakesScreenshot) driver;//Upcasting
         File source= t.getScreenshotAs(OutputType.FILE); // source of the screenshot
         File destination = new File("C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\Screenshot\\Fail\\FailCase"+Math.random()+".png");
         try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
