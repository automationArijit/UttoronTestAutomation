package uttoronTestClasses;

import org.testng.annotations.Test;

import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronRegisterPage;

public class UttoronRegisterPageTest extends UttoronBrowserOpen_Quit {

	UttoronRegisterPage reg;
	UttoronHomePage uh;

	@Test
	public void verifyUserRegistration() {

		uh = new UttoronHomePage(driver);
		uh.Homepage_RegisterLink();

		reg = new UttoronRegisterPage(driver);
		reg.registerUser("Arijit", "Chatterjee", "uttoron100@yopmail.com", "Test@123456789");
	}

}
