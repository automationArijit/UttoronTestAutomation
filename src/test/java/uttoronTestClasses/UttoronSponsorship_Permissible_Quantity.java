package uttoronTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronLoginData;
import uttoronPageclasses.UttoronLoginPage;
import uttoronPageclasses.UttoronMagazineQualnity;
import uttoronPageclasses.UttoronShoppingCartPage;
import uttoronPageclasses.UttoronSponsorshipPage;

public class UttoronSponsorship_Permissible_Quantity extends UttoronBrowserOpen_Quit {
	
	UttoronHomePage uh;
	UttoronLoginPage ul;
	UttoronLoginData ud;
	UttoronSponsorshipPage usp;
	UttoronShoppingCartPage uscp;

	
	@Test
	public void Verify_PermissibleLimit() throws EncryptedDocumentException, IOException, InterruptedException
	{
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

		usp.selectQuarterPageAndAddToCart(UttoronMagazineQualnity.Prmissiblequantity);

		uscp = new UttoronShoppingCartPage(driver);
		uh.cartLink();
	}

}
