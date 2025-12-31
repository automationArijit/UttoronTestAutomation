package uttoronTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronDonatePage;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronLoginData;
import uttoronPageclasses.UttoronLoginPage;
import uttoronPageclasses.UttoronPaypalForDonatePage;

public class UttoronDonatePageTest extends UttoronBrowserOpen_Quit {

	UttoronHomePage uh;
	UttoronLoginPage ul;
	UttoronLoginData ud;
	UttoronPaypalForDonatePage udp;

	@Test
	public void UserLoginAndDonation() throws EncryptedDocumentException, IOException, InterruptedException {

		uh = new UttoronHomePage(driver);
		uh.Homepage_LoginLink();

		ud = new UttoronLoginData();
		ud.UttoronLoginCredential();

		ul = new UttoronLoginPage(driver);

		ul.Loginpage_Username(UttoronLoginData.un1);
		ul.Loginpage_Password(UttoronLoginData.psw1);
		ul.Loginpage_LoginButton();

		// Moving to Donation
		uh.clickDonateUnderFundRaising();
		UttoronDonatePage ud =new UttoronDonatePage(driver);
		ud.scrollToDonateButtonAndClick();
		
		//PayPal page for donation.
		udp =new UttoronPaypalForDonatePage(driver);
		//udp.switchToPayPalWindow();
		//udp.enterDonationAmountAndDonate("100");
		
	}
}
