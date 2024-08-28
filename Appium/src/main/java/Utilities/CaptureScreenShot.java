package Utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import Base.BaseTest;

public class CaptureScreenShot extends BaseTest {
	public static void getScreenshot(String Name) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\target\\ScreenShot\\"+Name+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		//return destinationFile;
	}
}
