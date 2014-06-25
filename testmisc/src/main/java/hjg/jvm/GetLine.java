package hjg.jvm;

/**
 * @author hjg
 * @version 创建时间：2010-11-26下午02:38:08
 * 
 **/
public class GetLine {
	public static int getLineNumber(Exception e) {
		StackTraceElement[] trace = e.getStackTrace();
		if (trace == null || trace.length == 0)
			return -1; //
		return trace[0].getLineNumber();
	}

	public static void main(String[] args) {
		System.out.println("Current line:" + getLineNumber(new Exception()));
		new java.lang.Throwable().printStackTrace();
	}
}

