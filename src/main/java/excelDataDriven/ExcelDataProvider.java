package excelDataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

    public static Object[][] testData(String excelPath, String sheetName){

        ExcelUtils excelUtils = new ExcelUtils(excelPath,sheetName);

        int rowCount=excelUtils.getRowCount();
        int colCount=excelUtils.getColCount();

        Object data[][] = new Object[rowCount-1][colCount];
        for (int i=1;i<rowCount;i++){
            for (int j=0;j<colCount;j++){
               String cellData=excelUtils.getCellDataString(i,j);
               data[i-1][j]=cellData;
            }
          }return data;

    }

    @DataProvider(name="leaseDashcamData")
    public static Object[][] getData(){
        String excelPath="/home/nithya.balu/NextGEN_APIFramework/Data/LeaseDashcamTestData.xlsx";
        Object data[][]=testData(excelPath,"sheet1");
        return data;
    }

//    @Test(dataProvider="leaseDashcamData")
//    public void leaseDashcamTestData(String requestType,String uri,String organisationId, String header,String endpoint ){
//        System.out.println(requestType+ "|"+ uri + "|"+organisationId+ "|"+header+"|"+endpoint+"|" );
//
//    }
}
