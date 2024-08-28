package org.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.base.browser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class takescreenshot extends browser {
	public static void screenShot(String name) throws Exception {
		try {
			TakesScreenshot shot = ((TakesScreenshot) driver);
			File source = shot.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "\\target\\ScreenShot\\" + name + ".png";
			File destination = new File(path);
			FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			System.out.print(e);
		}

	}
}
