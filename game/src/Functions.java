import java.util.concurrent.TimeUnit;

/**
 * @author Merlijn van den Berg & Pieter van der werff
 */
public class Functions {
	
	private int defaultOptionalPrintTime = 20;
	
	/**
	 * Prints de text en een damatise manier
	 * @param Input
	 * @param TimeInMilliSeconds
	 */
	// Printing text in a cinematic way
	public void printText(String Input, int TimeInMilliSeconds) {
		String[] inputArray = Input.split("",
				0);
		for (String character : inputArray) {
			System.out.print(character);
			System.out.print("..");
			Sleep(TimeInMilliSeconds);
			System.out.print("\b\b");
			
		}
		System.out.println();
	}
	
	/**
	 * print de text met een custom timer
	 * @param input
	 */
	public void printText(String input) {
		printText(input,
				defaultOptionalPrintTime);
	}
	
	/**
	 * versimpelde sleep funcie
	 * @param TimeInMilliSeconds
	 */
	public void Sleep(int TimeInMilliSeconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(TimeInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * een sleep funtie met een knipper effect
	 * @param BlinkTimes
	 */
	public void Pause(int BlinkTimes) {
		
		System.out.print("..");
		for (int i = 0; i < BlinkTimes; i++) {
			System.out.print("\b");
			Sleep(350);
			System.out.print(".");
			Sleep(350);
		}
		System.out.print("\b\b");
		System.out.println();
		
	}
	
}
