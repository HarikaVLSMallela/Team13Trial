package numpyninja.qa.lms.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*; 

public class ExcelReaderAndWriter {
      
	//private static final String TEST_DATA_SHEET_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Team13-AutomationArchitect_testData.xlsx";
	private static final String TEST_DATA_SHEET_PATH = System.getProperty("user.dir") + "/src/test/resources/testData/Team13-AutomationArchitect_testData.xlsx";

    public static int totalRow;

    public List<Map<String, String>> getData(String sheetName) throws IOException {
        
    	FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
    	Workbook workbook;
    	Sheet sheet = null;
		try {
			workbook = WorkbookFactory.create(ip);
			sheet = workbook.getSheet(sheetName);
	       
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return readSheet(sheet);
        
    }

    private List<Map<String, String>> readSheet(Sheet sheet) {
    	
        Row row;
        Cell cell;
        int totalRow = sheet.getLastRowNum(); //total row
        List<Map<String, String>> excelRows = new ArrayList<>();
        
        for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
        	
            row = sheet.getRow(currentRow);
            int totalColumn = row.getLastCellNum();
            LinkedHashMap<String, String> columnMapData = new LinkedHashMap<>();
            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                cell = row.getCell(currentColumn);
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();

                if (null != cell && CellType.STRING.equals(cell.getCellType()))
                    columnMapData.put(columnHeaderName, cell.getStringCellValue());
                else if (null != cell && CellType.NUMERIC.equals(cell.getCellType()))
                    columnMapData.put(columnHeaderName,  Long.valueOf((long)cell.getNumericCellValue()).toString());
                else
                    columnMapData.put(columnHeaderName, "");
            }
            excelRows.add(columnMapData);
        }
        return excelRows;
    }

    public int countRow() {
        return totalRow;
    }

   
}


