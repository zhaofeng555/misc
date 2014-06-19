package hjg.image;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class CutScreen {
	public static void main(String []args) throws Exception{
		CutScreen cs = new CutScreen();
		try {
			cs.captureScreen("resource/screen.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void captureScreen(String fileName) throws Exception {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(fileName));
		
		System.out.println("complete .... ");
		
//		Robot robot = new Robot();
//		robot.mouseMove(100, 100);
	}

}
