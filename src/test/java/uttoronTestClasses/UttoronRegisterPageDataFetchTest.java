package uttoronTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronRegisterData;
import uttoronPageclasses.UttoronRegisterPage;

public class UttoronRegisterPageDataFetchTest extends UttoronBrowserOpen_Quit {

	UttoronRegisterPage reg;
	UttoronHomePage uh;

//	@Test(priority = 0)
//	public void RegistrationDataFromExcel_SingleUser() throws EncryptedDocumentException, IOException {
//		uh = new UttoronHomePage(driver);
//		uh.Homepage_RegisterLink();
//
//		reg = new UttoronRegisterPage(driver);
//
//		UttoronRegisterData ud = new UttoronRegisterData();
//		ud.UttoronRegisterCredentials();
//
//		reg.RegisterPage_Firstname(UttoronRegisterData.firstName);
//		reg.RegisterPage_Lastname(UttoronRegisterData.lastName);
//		reg.RegisterPage_Email(UttoronRegisterData.email);
//		reg.RegisterPage_Password(UttoronRegisterData.password);
//		reg.RegisterPage_RegisterButton();
//	}
	@Test
	public void RegistrationDataFromExcel_MultipleUser() throws EncryptedDocumentException, IOException {
		
		uh = new UttoronHomePage(driver);
		uh.Homepage_RegisterLink();

		reg = new UttoronRegisterPage(driver);

		UttoronRegisterData ud = new UttoronRegisterData();
		ud.UttoronRegisterCredentials_ForMultipleUser();

		reg.RegisterPage_Firstname(UttoronRegisterData.firstName);
		reg.RegisterPage_Lastname(UttoronRegisterData.lastName);
		reg.RegisterPage_Email(UttoronRegisterData.email);
		reg.RegisterPage_Password(UttoronRegisterData.password);
		reg.RegisterPage_RegisterButton();
		
	}
	

}
