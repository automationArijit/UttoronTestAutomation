package uttoronTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import uttoronPageclasses.SandboxPayPalPage;
import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronLoginData;
import uttoronPageclasses.UttoronLoginPage;
import uttoronPageclasses.UttoronMagazineQualnity;
import uttoronPageclasses.UttoronPaypalData;
import uttoronPageclasses.UttoronSecureCheckoutPage;
import uttoronPageclasses.UttoronSecurePaymentPayPalPage;
import uttoronPageclasses.UttoronShoppingCartPage;
import uttoronPageclasses.UttoronSponsorshipPage;

public class UttoronSponsorshipTest extends UttoronBrowserOpen_Quit {

	UttoronHomePage uh;
	UttoronLoginPage ul;
	UttoronLoginData ud;
	UttoronSponsorshipPage usp;
	UttoronShoppingCartPage uscp;
	UttoronSecureCheckoutPage usecp;
	UttoronSecurePaymentPayPalPage usppp;
	SandboxPayPalPage spp;
	UttoronPaypalData upd;

	@Test
	public void UserLoginAndSponsor() throws EncryptedDocumentException, IOException, InterruptedException {

		uh = new UttoronHomePage(driver);
		uh.Homepage_LoginLink();

		ud = new UttoronLoginData();
		ud.UttoronLoginCredential();

		ul = new UttoronLoginPage(driver);

		ul.Loginpage_Username(UttoronLoginData.un1);
		ul.Loginpage_Password(UttoronLoginData.psw1);
		ul.Loginpage_LoginButton();

		// Moving to Sponsorship
		uh.clickSponsorUnderFundRaising();
		usp = new UttoronSponsorshipPage(driver);

		UttoronMagazineQualnity uq = new UttoronMagazineQualnity();
		uq.MagazineitemQualnity();

		usp.selectQuarterPageAndAddToCart(UttoronMagazineQualnity.quantity);

		uscp = new UttoronShoppingCartPage(driver);
		uh.cartLink();
		uscp.clickCheckout();

		usecp = new UttoronSecureCheckoutPage(driver);
		usecp.ProceedToPayButton();
		
		usppp= new UttoronSecurePaymentPayPalPage(driver);
		usppp.ClickPayPalButton();	
		usppp.switchingToPayPal();
		
		spp= new SandboxPayPalPage(driver);
		
		spp.PayWithDebitCreditCard();
		//spp.Email(UttoronPaypalData.email);
		upd =new UttoronPaypalData();
		upd.UttoronPayPalCredential();
		
		
		spp.Email("watercolour.arijit@gmail.com");
		spp.ContinueToPayment();
		
		spp.CountryDropdown(UttoronPaypalData.continueDropdown);
		//UttoronPaypalData.billingemail
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
		Thread.sleep(6000);
		spp.turnOffPayPalToggle();
		spp.ContinueAsGuestButton();
		//spp.ContinueButton();

	}
}
