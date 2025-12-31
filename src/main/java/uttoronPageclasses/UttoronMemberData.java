package uttoronPageclasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class UttoronMemberData {

	public static String membertype;
	public static String agegroup;
	public static String fname;
	public static String lname;
	public static String email;

	public void Membercredential() throws EncryptedDocumentException, IOException {
		FileInputStream f = new FileInputStream(
				"C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\DDT_Use\\logindata.xlsx");
		Workbook w = WorkbookFactory.create(f);
		membertype = w.getSheet("memberdata").getRow(1).getCell(0).getStringCellValue();
		agegroup = w.getSheet("memberdata").getRow(1).getCell(1).getStringCellValue();
		fname = w.getSheet("memberdata").getRow(1).getCell(2).getStringCellValue();
		lname = w.getSheet("memberdata").getRow(1).getCell(3).getStringCellValue();
		email = w.getSheet("memberdata").getRow(1).getCell(4).getStringCellValue();
	}

}
