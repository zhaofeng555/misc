package hjg.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
// Create a class extends with TimerTask
public class ScheduledTask extends TimerTask {
 
	Date now; // to display current time
 
	// Add your task here
	public void run() {
		now = new Date(); // initialize date
		System.out.println("Time is :" + now); // Display current time
	}
	

	public static void main(String args[]) throws InterruptedException {
 
		Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, 1000); // Create Repetitively task for every 1 secs
 
		//for demo only.
		for (int i = 0; i <= 5; i++) {
			System.out.println("Execution in Main Thread...." + i);
			Thread.sleep(2000);
			if (i == 5) {
				System.out.println("Application Terminates");
				System.exit(0);
			}
		}
	}

}
