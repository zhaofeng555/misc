package hjg.thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        test1();
    }

	private static void test1() {
		/*
         * 创建Timer对象： 一种线程设施，用于安排以后在后台线程中执行的任务。 可安排任务执行一次，或者定期重复执行。<br>　　　　　　　　　　*
         */
        Timer tm = new Timer("MyThread");
        /*
         * 安排指定的任务
         */
        Calendar cal = Calendar.getInstance();
//        cal.set(2015, 1, 1, 13, 40, 00);
        tm.schedule(new TimerTask() {
 
            @Override
            public void run() { //输出线程的名称，其值为  MyThread<br>　　　　　　　　　　　　　　　　
            	System.err.println(Thread.currentThread().getName());
                while (true) {
                   try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /*
                     * 输出每秒时间
                     */
                    String time = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(new Date());
                    System.err.println(time);
                }
            }
        }, cal.getTime(), 1000);
	}
}
