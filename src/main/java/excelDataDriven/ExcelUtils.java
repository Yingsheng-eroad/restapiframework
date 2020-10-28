package excelDataDriven;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet xssfSheet;

    public ExcelUtils(String excelPath, String sheetName) {

        try {
            workbook = new XSSFWorkbook(excelPath);
            xssfSheet = workbook.getSheet(sheetName);

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public static void getCellData(int rowNum, int colNum) {

        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(xssfSheet.getRow(rowNum).getCell(colNum));
        System.out.println(value);

    }
    public static String getCellDataString(int rowNum, int colNum){

        String cellData=null;
        try{
             cellData = xssfSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
                    System.out.println(cellData);

        }catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }return cellData;
    }

    public static void getCellDataNumber(int rowNum, int colNum){
        try{
            Double cellData = xssfSheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
            System.out.println(cellData);

        }catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public static int getRowCount() {
        int rowCount=0;

//        String projDir = System.getProperty("user.dir");
//        System.out.println(projDir);
        try {
             rowCount = xssfSheet.getPhysicalNumberOfRows();
            System.out.println("No.of Rows:" + rowCount);

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        } return rowCount;
    }
    public static int getColCount() {

        int colCount=0;
//        String projDir = System.getProperty("user.dir");
//        System.out.println(projDir);
        try {
           colCount = xssfSheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("No.of Columns:"+ colCount);

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }return colCount;
    }
}

