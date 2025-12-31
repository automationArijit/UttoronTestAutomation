package uttoronPageclasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UttoronRegisterData extends UttoronBrowserOpen_Quit {

	public static String firstName;
	public static String lastName;
	public static String email;
	public static String password;

	public void UttoronRegisterCredentials() throws EncryptedDocumentException, IOException {

		FileInputStream f = new FileInputStream(
				"C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\DDT_Use\\logindata.xlsx");
		Workbook w = WorkbookFactory.create(f);

		firstName = w.getSheet("register").getRow(1).getCell(0).getStringCellValue();
		lastName = w.getSheet("register").getRow(1).getCell(1).getStringCellValue();
		email = w.getSheet("register").getRow(1).getCell(2).getStringCellValue();
		password = w.getSheet("register").getRow(1).getCell(3).getStringCellValue();

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
