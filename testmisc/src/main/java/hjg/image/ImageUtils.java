package hjg.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

public class ImageUtils {

	public static ByteArrayOutputStream image2OutStream(Image itemp) throws ImageFormatException, IOException{
		ByteArrayOutputStream op = new ByteArrayOutputStream();
		JPEGImageEncoder imageEncoder = JPEGCodec.createJPEGEncoder(op);
		imageEncoder.encode((BufferedImage) itemp);
		return op;
	}
	
	public static Image ResizeImg(InputStream inputStream, int maxWidth,
			int maxHeight) throws IOException {

		BufferedImage bufferimage = ImageIO.read(inputStream);
		int curWidth = bufferimage.getWidth();
		int curHeight = bufferimage.getHeight();

		double ratio = 0;
		Image itemp = bufferimage.getScaledInstance(maxWidth, maxHeight,
				BufferedImage.SCALE_SMOOTH);
		// 计算比例
		if ((bufferimage.getHeight() > maxHeight)
				|| (bufferimage.getWidth() > maxWidth)) {
			if (bufferimage.getHeight() > bufferimage.getWidth()) {
				ratio = (new Integer(maxHeight)).doubleValue()
						/ bufferimage.getHeight();
			} else {
				ratio = (new Integer(maxWidth)).doubleValue()
						/ bufferimage.getWidth();
			}
			AffineTransformOp op = new AffineTransformOp(
					AffineTransform.getScaleInstance(ratio, ratio), null);
			itemp = op.filter(bufferimage, null);
		}

		BufferedImage bufftmp = new BufferedImage(curWidth, curHeight,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2D = bufftmp.createGraphics();

		g2D.setColor(Color.white);
		g2D.fillRect(0, 0, curWidth, curHeight);

		if (maxWidth == itemp.getWidth(null))
			g2D.drawImage(itemp, 0, (maxHeight - itemp.getHeight(null)) / 2,
					itemp.getWidth(null), itemp.getHeight(null), Color.white,
					null);
		else
			g2D.drawImage(itemp, (maxWidth - itemp.getWidth(null)) / 2, 0,
					itemp.getWidth(null), itemp.getHeight(null), Color.white,
					null);
		g2D.dispose();

		return itemp;
	}

	public static Image ResizeImg(byte[] content, int maxWidth, int maxHeight)
			throws IOException {
		ByteInputStream bis = new ByteInputStream(content, content.length);
		return ResizeImg(bis, maxWidth, maxHeight);
	}
}
