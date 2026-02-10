package uttoronTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TesseractException;
import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronRegisterData;
import uttoronPageclasses.UttoronRegisterPage;

@Listeners(uttoronPageclasses.UttoronTestListener.class)
public class UttoronRegisterPageTest extends UttoronBrowserOpen_Quit {

	UttoronRegisterPage reg;
	UttoronHomePage uh;

	@Test
	public void verifyUserRegistration() throws EncryptedDocumentException, IOException, TesseractException, InterruptedException {

		uh = new UttoronHomePage(driver);
		uh.Homepage_RegisterLink();

		reg = new UttoronRegisterPage(driver);
		
		UttoronRegisterData ud =new UttoronRegisterData();
		
		// Fetching registration data from excel sheet.
		ud.UttoronRegisterCredentials();
	
//  For New user: 
		
	 reg.registerUser(UttoronRegisterData.firstName, UttoronRegisterData.lastName, UttoronRegisterData.email, UttoronRegisterData.password);

//  For already registered user: Test Automation, email: watercolour.arijit@gmail.com , psw: uttoron2025Demo!
	
	//reg.registerUser(UttoronRegisterData.registered_firstName, UttoronRegisterData.registered_lastName, UttoronRegisterData.registered_email, UttoronRegisterData.registered_password);
	
		
	}

}
