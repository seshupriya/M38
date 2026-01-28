package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingBackDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
      FileInputStream fis=new FileInputStream("./src/test/resources/E38_updated.xlsx");
     Workbook wb = WorkbookFactory.create(fis);
     Sheet sh = wb.getSheet("E38");
     Row r = sh.getRow(1);
     Cell c = r.createCell(2);
     c.setCellValue("pass");
     FileOutputStream fos=new FileOutputStream("./src/test/resources/E38_updated.xlsx");
     wb.write(fos);
     wb.close();
	}

}
