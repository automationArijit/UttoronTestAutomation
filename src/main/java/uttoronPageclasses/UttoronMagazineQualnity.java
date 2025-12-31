package uttoronPageclasses;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;


public class UttoronMagazineQualnity extends UttoronBrowserOpen_Quit {

	public static String quantity;
	public static String Prmissiblequantity;

	public void MagazineitemQualnity() throws EncryptedDocumentException, IOException {
		
		FileInputStream f = new FileInputStream(
				"C:\\Users\\Datacore\\eclipse-workspace\\uttoron2025\\DDT_Use\\logindata.xlsx");
		Workbook w = WorkbookFactory.create(f);
		
		 quantity = NumberToTextConverter.toText(
		        w.getSheet("quantity").getRow(0).getCell(1).getNumericCellValue());
		 Prmissiblequantity = NumberToTextConverter.toText(
			        w.getSheet("quantity").getRow(1).getCell(1).getNumericCellValue());
		

	}

}
