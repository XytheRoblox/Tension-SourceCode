package ClientSrc.utils.Timers;

public class Timer {
	
	private long prevTime;
	
	public Timer () {
		prevTime = 0;
	}
	
	public boolean hasTimePassed(long ms) {
		return (float)(getTime() - prevTime) >= ms;
	}
	
	public void reset() {
		prevTime = getTime();
	}
	
	public static long getTime() {
		return System.nanoTime() / 1000000;
	}
}
