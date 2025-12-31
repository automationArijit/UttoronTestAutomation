package uttoronPageclasses;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class UttoronLoginData {

	public static String un1;
	public static String psw1;
	public static String un2;
	public static String psw2;

	public void UttoronLoginCredential() throws EncryptedDocumentException, IOException {
		FileInputStream f = new FileInputStream(
				"C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\DDT_Use\\logindata.xlsx");
		Workbook w = WorkbookFactory.create(f);
		un1 = w.getSheet("login").getRow(1).getCell(0).getStringCellValue();
		psw1 = w.getSheet("login").getRow(1).getCell(1).getStringCellValue();
		un2 = w.getSheet("login").getRow(2).getCell(0).getStringCellValue();
		psw2 = w.getSheet("login").getRow(2).getCell(1).getStringCellValue();

	}
	
	public void UttoronLoginInvalidCredential() throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream(
				"C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\DDT_Use\\logindata.xlsx");
		Workbook w = WorkbookFactory.create(f);
		un2 = w.getSheet("login").getRow(2).getCell(0).getStringCellValue();
		psw2 = w.getSheet("login").getRow(2).getCell(1).getStringCellValue();
	}
	

}
