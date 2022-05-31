package ClientSrc.utils.Timers;

public class Timer2 {
	
	public static short convert(float persecond) {
		return (short) (1000/ persecond);
	}
	
	public static long getCurrentTime() {
		return System.nanoTime() / 1000000;
	}
	
	private long previousTime;
	
	public Timer2() {
		previousTime = -1L;
	}
	
	public long get() {
		return previousTime;
	}
	
	public boolean check(float millisec) {
		return Timer2.getCurrentTime() - previousTime >= millisec;
	}
	
	public void reset() {
		previousTime = Timer2.getCurrentTime();
	}

}
