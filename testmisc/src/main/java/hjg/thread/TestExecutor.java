package hjg.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;


public class TestExecutor {

	public static void test1() {
		Executor threadPool = null;
		/*  
         * 该方法返回一个固定线程数量的线程池,该线程池中的线程数量 是固定不变的,  
         * 当一个新任务被提交时,若然没有空闲线程,则会暂时存储在一个任务队列中,  
         * 待有空闲的线程便处理任务队列中的任务  
         */  
		threadPool = Executors.newFixedThreadPool(10);
		
		 /*  
         * 该方法返回一个只有一个线程的线程池,当一个新任务被提交后,  
         * 会进入任务队列待有空闲线程时即处理任务队列中的任务  
         */ 
		threadPool = Executors.newSingleThreadExecutor();
		
		 /*  
         * 该方法返回一个可根据实际任务数量调整线程数量的线程池,  
         * 该线程池的线程数量是不固定的,若有空闲线程,则会优先处理任务,  
         * 若所有线程都在执行任务时又有新的任务被提交,则会创建新的线程去处理任务  
         */  
		threadPool = Executors.newCachedThreadPool();
		
		/*  
         * 每个创建线程池的方法都有ThreadFactory的重载  
         */  
		threadPool = Executors.newFixedThreadPool(10, new ThreadFactory() {
			
			/*  
             * 使用ThreadFactory能控制线程产生时的细节操作  
             */  
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				//设置为守护线程
				thread.setDaemon(true);
				//设置线程为最高优先级
				thread.setPriority(Thread.MAX_PRIORITY);
				return thread;
			}
		});
		
		//提交任务
		threadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				//执行业务逻辑
				
			}
		});
		
		/*
		 * 我们一般使用ExecutorService方式操作线程池，（有更多的方式操作操作）
		 * 
		 * 其实Executors创建的线程池返回的都是ExecutorService对象，
		 * （Executor是ExecutorService的父类，都是接口）
		 */
		ExecutorService service = (ExecutorService)threadPool;
		
		/*
		 * 提交一个有返回值（计算结果）的任务，
		 * 		温馨提示，如果任务需要返回计算结果使用service.submit()
		 * 							如果任务不需要返回结果使用service.execute()
		 */
		Future<Integer> future=service.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				
				return 10;
			}
		});
		
		/*
		 * 当线程池使用完毕可以使用shutdown关闭线程池，
		 * 		shutdown温柔的关闭方式，等待任务执行结束完毕后关闭线程池
		 * 		shutdownNow马上关闭 
		 */
		service.shutdown();
		
	}
	
//    //固定线程数 -- FixedThreadPool
//    public static ExecutorService newFixedThreadPool(int nThreads) {
//        return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
//    }
//
//    //单条线程  --  SingleThreadExecutor
//    public static ExecutorService newSingleThreadExecutor() {
//        return new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L,
//                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));
//    }
//
//    //线程数自增长    --  CachedThreadPool
//    public static ExecutorService newCachedThreadPool() {
//        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
//                new SynchronousQueue<Runnable>());
//    }
	
}
