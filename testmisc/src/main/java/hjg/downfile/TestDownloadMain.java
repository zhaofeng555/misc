package hjg.downfile;

public class TestDownloadMain {

   public static void main(String[] args) {
       /*
       DownloadInfo bean = new DownloadInfo("http://i7.meishichina.com/Health/UploadFiles/201109/2011092116224363.jpg");
       System.out.println(bean);
       BatchDownloadFile down = new BatchDownloadFile(bean);
       new Thread(down).start();
       */
       
       
       //DownloadUtils.download("http://i7.meishichina.com/Health/UploadFiles/201109/2011092116224363.jpg");
       DownloadUtils.download("http://www.baidu.com/img/baidu_sylogo1.gif", "aa.gif", "c:/test", 5);
   }
}
