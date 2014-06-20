package hjg.jvm;


public class GetJVM {
	private static int mb = 1000;
	
	public static final String getMemoryInfo() { 
	     return getMemoryInfo("使用内存:%dM 可用内存:%dM 总内存:%dM 最大可用内存:%dM"); 
	} 
	 
	public static final String getMemoryInfo(final String formatStr) { 
	     final Runtime rt = Runtime.getRuntime(); 
	     final int maxMem = (int) (rt.maxMemory() / mb); 
	     final int freeMem = (int) (rt.freeMemory() / mb); 
	     final int totalMem = (int) (rt.totalMemory() / mb); 
	     final int usedMem = totalMem - freeMem; 
	     return String.format(formatStr, usedMem, freeMem, totalMem, maxMem); 
	}
	
	public static void main(String[] args) {
		System.out.println(getMemoryInfo());
	}
}
