package uttoronTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronLoginData;
import uttoronPageclasses.UttoronLoginPage;

public class UttoronLoginPageTest extends UttoronBrowserOpen_Quit {

	UttoronHomePage uh;
	UttoronLoginPage ul;
	UttoronLoginData ud;
	
	@Test
	public void UserLogin() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		uh = new UttoronHomePage(driver);
		uh.Homepage_LoginLink();
		
		ud = new UttoronLoginData();
        ud.UttoronLoginCredential();
        
		ul = new UttoronLoginPage(driver);

		ul.Loginpage_Username(UttoronLoginData.un1);
		ul.Loginpage_Password(UttoronLoginData.psw1);
		ul.Loginpage_LoginButton();

	}

}
