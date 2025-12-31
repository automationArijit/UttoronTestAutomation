package uttoronTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TesseractException;
import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronRegisterData;
import uttoronPageclasses.UttoronRegisterPage;

public class UttoronRegisterPageTest extends UttoronBrowserOpen_Quit {

	UttoronRegisterPage reg;
	UttoronHomePage uh;

	@Test
	public void verifyUserRegistration() throws EncryptedDocumentException, IOException, TesseractException, InterruptedException {

		uh = new UttoronHomePage(driver);
		uh.Homepage_RegisterLink();

		reg = new UttoronRegisterPage(driver);
		
		UttoronRegisterData ud =new UttoronRegisterData();
		ud.UttoronRegisterCredentials();
		
		reg.registerUser("Arijit", "Chatterjee", "uttoron100@yopmail.com", "Test@123456789");
		
		
	}

}
