package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Reusable_UploadFiles {

	public static void uploadFile(String file) throws AWTException, InterruptedException
	{
		StringSelection select = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		
		Thread.sleep(4000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
}
