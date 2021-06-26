package CommonMethods;

import java.util.concurrent.TimeUnit;

public class commonMethods {
	
	/**
	 * Fifteen seconds explicit wait added in order to make the DOM fully loaded
	 */
	public static void longWait(){
		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			System.out.println("Interruption happened due to sleep() method");
		}
	}
	
	/**
	 * Five seconds explicit wait added in order to make the DOM fully loaded
	 */
	public static void shortWait(){
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			System.out.println("Interruption happened due to sleep() method");
		}
	}

}
