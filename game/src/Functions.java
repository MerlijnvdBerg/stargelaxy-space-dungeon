import java.util.concurrent.TimeUnit;

public class Functions {

private int defaultOptionalPrintTime = 100;

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
	System.out.println("");
}

public void printText(String input) {
	printText(input,
			defaultOptionalPrintTime);
}

public void Sleep(int TimeInMilliSeconds) {
	try {
		TimeUnit.MILLISECONDS.sleep(TimeInMilliSeconds);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

public void Pause(int BlinkTimes) {
	
	System.out.print("..");
	for (int i = 0; i < BlinkTimes; i++) {
		System.out.print("\b");
		Sleep(350);
		System.out.print(".");
		Sleep(350);
	}
	System.out.print("\b\b");
	System.out.println("");
	
}

}
