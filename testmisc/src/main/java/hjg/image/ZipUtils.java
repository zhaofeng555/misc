package hjg.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author hjg 
 * @version   创建时间：2012-2-17下午08:08:09
 *
 **/
public class ZipUtils {

	private static final Log logger = LogFactory.getLog(ZipUtils.class);
	
	public static void main(String[] args) {
		String zipFileName="test.zip";
		String inputPath="resource";
		String base="resource";
		String buzName="testhjg";
		String serverTime="20140618";
		zip4Pos(zipFileName, inputPath, base, buzName, serverTime);
		System.out.println("complete ..........");
	}
	
	/**按照POS目录要求压缩文件  
	 * @param out  
	 * @param f  
	 * @param base  
	 * @param serverTime 14位的时间戳  
	 * @param buzName 业务名称  
	 * @throws Exception  
	 */  
	public static void zip4Pos(String zipFileName, String inputPath, String base, String buzName, String serverTime)   
	{   
	    File f = new File(inputPath);   
	    ZipOutputStream out;   
	    logger.info("正在压缩：" + f.getName() + "... ...");   
	    try  
	    {   
	        out = new ZipOutputStream(new FileOutputStream(zipFileName));   
	        String buzp = buzName + "/";   
	        String yp = buzp + serverTime.substring(0,4)+"/";   
	        String mp = yp + serverTime.substring(4,6)+"/";   
	        out.putNextEntry(new ZipEntry(buzp));    
	        out.putNextEntry(new ZipEntry(yp));    
	        out.putNextEntry(new ZipEntry(mp));    
	        base = mp + f.getName();   
	        zip(out, f, base);   
	        out.close();   
	    }   
	    catch (Exception e)   
	    {   
	        logger.error(e);   
	        e.printStackTrace();   
	    }   
	       
	}   
	       
	  
	private static void zip(ZipOutputStream out, File f, String base)   
	        throws Exception   
	{   
	    logger.info("正在压缩：" + f.getName() + "... ...");   
	    if (f.isDirectory())   
	    {   
	        File[] fs = f.listFiles();   
	        base += "/";   
	        logger.info("新建目录条目：" + f.getName());   
	        out.putNextEntry(new ZipEntry(base)); // 生成相应的目录   
	        for (int i = 0; i < fs.length; i++)   
	        {   
	            // 对本目录下的所有文件对象递归调用本方法   
	            zip(out, fs[i], base + fs[i].getName());   
	        }   
	    }   
	    else  
	    {   
	        logger.info("新增文件条目：" + f.getName());   
	        out.putNextEntry(new ZipEntry(base));   
	        InputStream is = new FileInputStream(f);   
	        byte[] buf = new byte[1024];   
	        int len = 0;   
	        while ((len = is.read(buf)) != -1)   
	        {   
	            out.write(buf, 0, len);   
	        }   
	        out.flush();
	        is.close();   
	    }   
	}   
	  
	/**  
	 * 解压缩文件  
	 * @param zipFile   
	 * @param desPath  
	 */  
	public static void unZip(File zipFile, String desPath)   
	{   
	  
	    // 建立输出流，用于将从压缩文件中读出的文件流写入到磁盘   
	    OutputStream out = null;   
	    // 建立输入流，用于从压缩文件中读出文件   
	    ZipInputStream is;   
	    try  
	    {   
	        is = new ZipInputStream(new FileInputStream(zipFile));   
	        ZipEntry entry = null;   
	        while ((entry = is.getNextEntry()) != null)   
	        {   
	            logger.info("正在解压缩：" + entry.getName() + "... ...");   
	            File f = new File(desPath + "\\" + entry.getName());   
	            if (entry.isDirectory())   
	            {   
	                logger.info("新建目录：" + f.getName());   
	                f.mkdir();   
	            }   
	            else  
	            {   
	                logger.info("新增文件：" + f.getName());   
	                // 根据压缩文件中读出的文件名称新建文件   
	                out = new FileOutputStream(f);   
	                byte[] buf = new byte[1024];   
	                int len = 0;   
	                while ((len = is.read(buf)) != -1)   
	                {   
	                    out.write(buf, 0, len);   
	                }   
	                out.close();   
	            }   
	        }   
	        is.close();   
	    }   
	    catch (Exception e)   
	    {   
	        logger.error(e);   
	    }   
	}
}
