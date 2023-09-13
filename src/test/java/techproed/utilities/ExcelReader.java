package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    Workbook workbook;
    Sheet sheet;
    public ExcelReader(String dosyaYolu, String sayfaIsmi){


        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            workbook= WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sayfaIsmi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    // satir ve sutun sayilarini girdigimizde o hucredeki veriyi rutrun edebilmesi icin;
    public String getCellData(int satir, int sutun){
        Cell cell = sheet.getRow(satir).getCell(sutun);


        return cell.toString();
    }
    // Excel deki satir sayisi icin
    public int rowCount(){
        return sheet.getLastRowNum();
    }
}
