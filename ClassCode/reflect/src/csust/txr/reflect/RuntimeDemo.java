package csust.txr.reflect;

import java.io.IOException;

public class RuntimeDemo {

	public static void main(String[] args) throws IOException {
		Runtime run=Runtime.getRuntime();
		run.exec("calc");
		run.exec("notepad");
	}

}
