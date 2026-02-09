package uttoronTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import uttoronPageclasses.SandboxPayPalPage;
import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronLoginData;
import uttoronPageclasses.UttoronLoginPage;
import uttoronPageclasses.UttoronMemberData;
import uttoronPageclasses.UttoronMembershipPage;
import uttoronPageclasses.UttoronPaypalData;
import uttoronPageclasses.UttoronSecureCheckoutPage;
import uttoronPageclasses.UttoronSecurePaymentPayPalPage;

@Listeners(uttoronPageclasses.UttoronTestListener.class)
public class UttoronMembershipTest extends UttoronBrowserOpen_Quit {

	UttoronHomePage uh;
	UttoronLoginPage ul;
	UttoronLoginData ud;
	UttoronMembershipPage um;
	UttoronSecureCheckoutPage usc;
	UttoronSecurePaymentPayPalPage usecp;
	SandboxPayPalPage spp;
	UttoronPaypalData upd;
	UttoronMemberData umd;

	@Test
	public void BecomeMember() throws EncryptedDocumentException, IOException, InterruptedException {

		uh = new UttoronHomePage(driver);
		uh.Homepage_LoginLink();

		ud = new UttoronLoginData();
		ud.UttoronLoginCredential();

		ul = new UttoronLoginPage(driver);

//  Login process
		ul.Loginpage_Username(UttoronLoginData.un1);
		ul.Loginpage_Password(UttoronLoginData.psw1);
		ul.Loginpage_LoginButton();

//  Home page, Membership 		
		uh.clickBecomeMemberUnderMembership();
		um = new UttoronMembershipPage(driver);

//  Passing value to become a member.	

		umd = new UttoronMemberData();
		umd.Membercredential();

		um.selectMemberAndProceedToPay(UttoronMemberData.membertype, UttoronMemberData.agegroup,
				UttoronMemberData.fname, UttoronMemberData.lname, UttoronMemberData.email);
//	SecureCheckoutPage 	

		usc = new UttoronSecureCheckoutPage(driver);
		usc.ProceedToPayButton();

//  SecurePayment to PayPal page, Changing parent window to PayPal page.

		usecp = new UttoronSecurePaymentPayPalPage(driver);
		usecp.ClickPayPalButton();
		usecp.switchingToPayPal();

//  Entire payment process in Sandbox through PayPal.	

//		upd =new UttoronPaypalData();
//		upd.UttoronPayPalCredential();

		spp = new SandboxPayPalPage(driver);

		spp.PayWithDebitCreditCard();

		upd = new UttoronPaypalData();
		upd.UttoronPayPalCredential();

		spp.Email(UttoronPaypalData.email);
		spp.ContinueToPayment();
		spp.CountryDropdown(UttoronPaypalData.continueDropdown);
		// UttoronPaypalData.billingemail
		spp.BillingEmailField();
		spp.PhoneType(UttoronPaypalData.phonetype);
		spp.PhoneNumber(UttoronPaypalData.phonenumber);
		spp.CardNumber(UttoronPaypalData.cardnumber);
		spp.CardExpiration(UttoronPaypalData.cardexpiration);
		spp.CVVNumber(UttoronPaypalData.cvv);
		spp.FirstName(UttoronPaypalData.fname);
		spp.LastName(UttoronPaypalData.lname);
		spp.StreetName(UttoronPaypalData.streetname);
		spp.CityName(UttoronPaypalData.cityname);
		spp.StateName(UttoronPaypalData.statetname);
		spp.ZipCode(UttoronPaypalData.zipcode);
		Thread.sleep(2000);
		spp.turnOffPayPalToggle();
		spp.ContinueAsGuestButton();
		// spp.ContinueButton();

	}

}
