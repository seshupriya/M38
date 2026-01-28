package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step1:Create Object of fileinputstream
		
		FileInputStream fis=new FileInputStream("./src/test/resources/E38.xlsx");
		
		//Step2:Open workbook in read mode
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3:Control of sheet
		
		Sheet sh = wb.getSheet("E38");
		
		//Step4:Control of row
		
		Row r = sh.getRow(1);
		
		//Step5:Control of cell
		
		Cell c = r.getCell(1);
		Cell c1 = r.getCell(0);
		
		//Step6:Read the data
		
		String value = c.getStringCellValue();
		String value1 = c1.getStringCellValue();
		System.out.println(value);
		System.out.println(value1);
		
		//Step7:Close the workbook
		
		wb.close();

	}

}
