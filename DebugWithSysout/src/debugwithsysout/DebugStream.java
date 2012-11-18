package debugwithsysout;


import java.io.PrintStream;
import java.text.MessageFormat;

/**
 * @author Jeeeyul 2011. 11. 1
 * 
 *         This class has been adapted from
 *         http://jeeeyul.wordpress.com/2012/10/18/make-system-out-println-rocks/
 */
public class DebugStream extends PrintStream {
	private static final DebugStream INSTANCE = new DebugStream();

	public static void activate() {
		System.setOut(INSTANCE);
	}

	private DebugStream() {
		super(System.out);
	}

	@Override
	public void println(Object x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(String x) {
		showLocation();
		super.println(x);
	}

	private void showLocation() {
		StackTraceElement element = Thread.currentThread().getStackTrace()[4];
//		super.print(MessageFormat.format("({0}:{1, number,#}) : ", element.getFileName(), element.getLineNumber()));
		super.print(MessageFormat.format("({0}:{1, number,#}) {2}(..) : ", element.getFileName(), element.getLineNumber(), element.getMethodName()));
		
	}
}
