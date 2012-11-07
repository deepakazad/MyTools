package debugwithsysout;

import org.eclipse.ui.IStartup;

public class DebugWithSysoutStartup implements IStartup {
	public void earlyStartup() {
		DebugStream.activate();
	}
}
