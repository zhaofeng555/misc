package hjg.image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


public class GeneratePDF {

	public static void main(String[] args) {
		try {
			OutputStream file = new FileOutputStream(new File("resource/test.pdf"));
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			Image image = Image.getInstance("resource/test.jpg");
			document.add(image);
			document.add(new Paragraph("Hello hjg"));
			document.add(new Paragraph(new Date().toString()));
			document.close();
			file.close();
			System.out.println("complete ............");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
