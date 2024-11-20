package android_Utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class FormDataProvider {
	
	@DataProvider(name="FormDataProvider")
	public Object[][] formData() throws IOException {
		
		String path = ".\\Data-Sheets\\Book1.xlsx";
		
		ExcelUtility utils = new ExcelUtility(path);
		
		int rows = utils.getRowCount("Sheet1");
		int cols = utils.getCellCount("Sheet1", 1);
		
		Object[][] FormSubmitData = new Object[rows][cols]; 
		
		for(int i = 1; i<=rows; i++) {
			
			for(int j =0; j<cols; j++) {
				
				FormSubmitData[i-1][j] = utils.getCellData("Sheet1", i, j);
			}
		}
		
		return FormSubmitData;
	
	}
}
