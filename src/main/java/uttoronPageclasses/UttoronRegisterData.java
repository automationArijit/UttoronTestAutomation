package uttoronPageclasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class UttoronRegisterData extends UttoronBrowserOpen_Quit {

	public static String firstName;
	public static String lastName;
	public static String email;
	public static String password;
	public static String registered_firstName;
	public static String registered_lastName;
	public static String registered_email;
	public static String registered_password;
	
		
	
	@DataProvider(name = "registerData")
	
	public Object[][] getRegisterData() throws EncryptedDocumentException, IOException {

	    FileInputStream f = new FileInputStream(
	            "C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\DDT_Use\\logindata.xlsx");

	    Workbook w = WorkbookFactory.create(f);
	    Sheet s = w.getSheet("registerMultiple");

	    DataFormatter formatter = new DataFormatter();
	    int rowCount = s.getPhysicalNumberOfRows();

	    // Exclude header row
	    Object[][] data = new Object[rowCount - 1][4];

	    for (int i = 1; i < rowCount; i++) {
	        Row row = s.getRow(i);

	        data[i - 1][0] = formatter.formatCellValue(row.getCell(0)); // firstName
	        data[i - 1][1] = formatter.formatCellValue(row.getCell(1)); // lastName
	        data[i - 1][2] = formatter.formatCellValue(row.getCell(2)); // email
	        data[i - 1][3] = formatter.formatCellValue(row.getCell(3)); // password
	    }

	    w.close();
	    return data;
	}
	

	public void UttoronRegisterCredentials() throws EncryptedDocumentException, IOException {

		FileInputStream f = new FileInputStream(
				"C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\DDT_Use\\logindata.xlsx");
		Workbook w = WorkbookFactory.create(f);

		firstName = w.getSheet("register").getRow(1).getCell(0).getStringCellValue();
		lastName = w.getSheet("register").getRow(1).getCell(1).getStringCellValue();
		email = w.getSheet("register").getRow(1).getCell(2).getStringCellValue();
		password = w.getSheet("register").getRow(1).getCell(3).getStringCellValue();
		
		registered_firstName = w.getSheet("register").getRow(2).getCell(0).getStringCellValue();
		registered_lastName = w.getSheet("register").getRow(2).getCell(1).getStringCellValue();
		registered_email = w.getSheet("register").getRow(2).getCell(2).getStringCellValue();
		registered_password = w.getSheet("register").getRow(2).getCell(3).getStringCellValue();
				
	}
	
	
	public void UttoronRegisterCredentials_ForMultipleUser() throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream(
				"C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\DDT_Use\\logindata.xlsx");

		Workbook w = WorkbookFactory.create(f);
		Sheet s = w.getSheet("registerMultiple");

		DataFormatter formatter = new DataFormatter(); 
		int totalRows = s.getPhysicalNumberOfRows(); //  

		System.out.println("Total active rows (including header): " + totalRows);

		for (int i = 1; i < totalRows; i++) { // start from row 1 (skip header)
			Row row = s.getRow(i);
			if (row == null) {
				System.out.println("Skipping empty row: " + i);
				continue;
			}

			firstName = formatter.formatCellValue(row.getCell(0));
			lastName = formatter.formatCellValue(row.getCell(1));
			email = formatter.formatCellValue(row.getCell(2));
			password = formatter.formatCellValue(row.getCell(3));

			if (firstName.isEmpty() || email.isEmpty()) {
				System.out.println("Incomplete data in row " + i + ", skipping...");
				continue;
			}

			System.out.println("User " + i + ": " + firstName + " " + lastName + " (" + email + ")");
			driver.navigate().refresh();
		}

		w.close();
	}

}
