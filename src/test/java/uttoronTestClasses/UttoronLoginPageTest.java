package uttoronTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronLoginData;
import uttoronPageclasses.UttoronLoginPage;

@Listeners(uttoronPageclasses.UttoronTestListener.class)
public class UttoronLoginPageTest extends UttoronBrowserOpen_Quit {

	UttoronHomePage uh;
	UttoronLoginPage ul;
	UttoronLoginData ud;

	@Test()
	public void UserLogin() throws EncryptedDocumentException, IOException, InterruptedException {

//  Login using valid/invalid credential.		

		uh = new UttoronHomePage(driver);

		// Clicking on the Login link in HomePage.
		uh.Homepage_LoginLink();

		// Fetching the login data from excel sheet.
		ud = new UttoronLoginData();

		// Calling method for value fetch.
		ud.UttoronLoginCredential();

		ul = new UttoronLoginPage(driver);

		// Check the Login functionality by passing valid and invalid credential.
		// un1,psw1 ==>> valid credential.
		// un2,psw2 ==>> in-valid credential.

		// To verify new registered user:

//		ul.Loginpage_Username(UttoronLoginData.newuserUN);
//		ul.Loginpage_Password(UttoronLoginData.newuserPSW);
//		ul.Loginpage_LoginButton();

		// To verify existing valid user:

		ul.Loginpage_Username(UttoronLoginData.un2);
		ul.Loginpage_Password(UttoronLoginData.psw2);
		ul.Loginpage_LoginButton();

	}

}
