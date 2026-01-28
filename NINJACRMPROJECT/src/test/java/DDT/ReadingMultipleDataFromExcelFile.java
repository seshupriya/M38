package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingMultipleDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/E38.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Testcase");
		int rowcount = sh.getLastRowNum();
		System.out.println("Rowcount:"+rowcount);
		for(int i=1;i<=rowcount;i++) {
			String value = sh.getRow(i).getCell(0).getStringCellValue();
			String role = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(value+" "+role);
		}
	}

}
