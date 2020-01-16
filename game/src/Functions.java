import java.util.concurrent.TimeUnit;

public class Functions {

	private int defaultOptionalPrintTime = 0;

	// Printing text in a cinematic way
	public void printText(String Input, int TimeInMilliSeconds){
		String[] inputArray = Input.split("", 0);
		for(String character: inputArray){
			System.out.print(character);
			try {
				TimeUnit.MILLISECONDS.sleep(TimeInMilliSeconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
	}
	
	public void printText(String input){
		printText(input, defaultOptionalPrintTime);
	}
	
}
