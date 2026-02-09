package uttoronTestClasses;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import uttoronPageclasses.UttoronBrowserOpen_Quit;
import uttoronPageclasses.UttoronHomePage;
import uttoronPageclasses.UttoronRegisterData;
import uttoronPageclasses.UttoronRegisterPage;



@Listeners(uttoronPageclasses.UttoronTestListener.class)
public class UttoronMultiUserRegistration extends UttoronBrowserOpen_Quit {
	
	UttoronRegisterPage reg;
    UttoronHomePage uh;

    @Test(dataProvider = "registerData", 
          dataProviderClass = UttoronRegisterData.class)
    public void RegistrationDataFromExcel_MultipleUser(
            String firstName,
            String lastName,
            String email,
            String password) throws InterruptedException {

        uh = new UttoronHomePage(driver);
        uh.Homepage_RegisterLink();

        reg = new UttoronRegisterPage(driver);

        reg.RegisterPage_Firstname(firstName);
        reg.RegisterPage_Lastname(lastName);
        reg.RegisterPage_Email(email);
        reg.RegisterPage_Password(password);

        reg.RegisterPage_RegisterButton();
        
       // reg.registerUser(firstName, lastName, email, password);
    }
}


