package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String toReadDataFromExcelFile(String sheetname,int RowNum,int CellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/E38_updated.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(RowNum).getCell(CellNum).getStringCellValue();
		return value;
	}
}
