package uttoronPageclasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class UttoronPaypalData {

	public static String email;
	public static String continueDropdown;
	public static String billingemail;
	public static String phonetype;
	public static String phonenumber;
	public static String cardnumber;
	public static String cardexpiration;
	public static String cvv;
	public static String fname;
	public static String lname;
	public static String streetname;
	public static String cityname;
	public static String statetname;
	public static String zipcode;
	public static String passemail;

	public void UttoronPayPalCredential() throws EncryptedDocumentException, IOException {
		FileInputStream f = new FileInputStream(
				"C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\DDT_Use\\logindata.xlsx");
		Workbook w = WorkbookFactory.create(f);
		email = w.getSheet("sandboxdata").getRow(1).getCell(0).getStringCellValue();
		continueDropdown = w.getSheet("sandboxdata").getRow(1).getCell(1).getStringCellValue();
		billingemail = w.getSheet("sandboxdata").getRow(1).getCell(2).getStringCellValue();
	passemail = w.getSheet("sandboxdata").getRow(1).getCell(2).getStringCellValue();
		
		phonetype = w.getSheet("sandboxdata").getRow(1).getCell(3).getStringCellValue();
		phonenumber = w.getSheet("sandboxdata").getRow(1).getCell(4).getStringCellValue();
		cardnumber = w.getSheet("sandboxdata").getRow(1).getCell(5).getStringCellValue();
		cardexpiration = w.getSheet("sandboxdata").getRow(1).getCell(6).getStringCellValue();
		cvv = NumberToTextConverter.toText(w.getSheet("sandboxdata").getRow(1).getCell(7).getNumericCellValue());
		fname = w.getSheet("sandboxdata").getRow(1).getCell(8).getStringCellValue();
		lname = w.getSheet("sandboxdata").getRow(1).getCell(9).getStringCellValue();
		streetname = w.getSheet("sandboxdata").getRow(1).getCell(10).getStringCellValue();
		cityname = w.getSheet("sandboxdata").getRow(1).getCell(11).getStringCellValue();
		statetname = w.getSheet("sandboxdata").getRow(1).getCell(12).getStringCellValue();
		zipcode = NumberToTextConverter.toText(w.getSheet("sandboxdata").getRow(1).getCell(13).getNumericCellValue());

	}

}
