package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static List<Map<String , String>> readExcelFile( String sheetName){
        String path = Constants.ITEMS_AND_PRICES_XFILE_PATH;

        List <Map<String,String>> excelData=new ArrayList<>();

        try {
            FileInputStream fileInputStream= new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet itemsAndPrices= workbook.getSheet(sheetName);

            int rowSize= itemsAndPrices.getPhysicalNumberOfRows();

            Row row0= itemsAndPrices.getRow(0);

            for (int i=1; i<rowSize; i++){
                Row currentRow= itemsAndPrices.getRow(i);
                LinkedHashMap <String ,String > rowMap= new LinkedHashMap<>();

                for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                    rowMap.put(row0.getCell(j).toString(), currentRow.getCell(j).toString());
                }
                excelData.add(rowMap);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return excelData;
    }


}
