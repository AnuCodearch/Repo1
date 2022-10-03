package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import configurations.PathConfig;

public class Utility {
	
	public static void captureScreenshot(WebDriver driver,String TCID) throws IOException {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(PathConfig.sspath + TCID + "_Image.jpg");
		FileHandler.copy(src,dest);
	}

	public static String getExcelData(int i, int j) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(PathConfig.excelfilepath);
		String data=WorkbookFactory.create(file).getSheet("Sheet3").getRow(i).getCell(j).getStringCellValue();
		return data;
	}

}
