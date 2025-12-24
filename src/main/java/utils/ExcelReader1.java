package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader1 {
	private Workbook workbook;
	private DataFormatter formatter = new DataFormatter();
	public ExcelReader1() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/excelTestData/testdata1.xlsx");
            workbook = new XSSFWorkbook(fis);
    }
	 public Map<String, String> getDataByScenarioName(String sheetName, String scenarioName) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new IllegalArgumentException("Sheet not found: " + sheetName);
	        }
	        Row headerRow = sheet.getRow(0);
	        if (headerRow == null) {
	            throw new IllegalStateException("Header row is missing");
	        }
	        int scenarioColumnIndex = -1;
	      
	        for (Cell cell : headerRow) {
	            if ("ScenarioName".equalsIgnoreCase(formatter.formatCellValue(cell))) {
	                scenarioColumnIndex = cell.getColumnIndex();
	                break;
	            }
	        }
	        if (scenarioColumnIndex == -1) {
	            throw new IllegalStateException("ScenarioName column not found");
	        }
	      
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;
	            String scenarioCellValue =
	                    formatter.formatCellValue(row.getCell(scenarioColumnIndex)).trim();
	            if (scenarioCellValue.equalsIgnoreCase(scenarioName)) {
	                return extractRowData(headerRow, row);
	            }
	        }
	        throw new IllegalArgumentException("Scenario not found in Excel: " + scenarioName);
	    }
	    private Map<String, String> extractRowData(Row headerRow, Row dataRow) {
	        Map<String, String> data = new HashMap<>();
	        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
	            String header = formatter.formatCellValue(headerRow.getCell(i)).trim();
	            String value = formatter.formatCellValue(dataRow.getCell(i)).trim();
	            if ("empty".equalsIgnoreCase(value)) {
	                value = "";
	            }
	            data.put(header, value);
	        }
	        return data;
	    }
}

