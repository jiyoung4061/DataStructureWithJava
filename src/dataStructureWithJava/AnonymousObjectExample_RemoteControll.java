package dataStructureWithJava;

public interface AnonymousObjectExample_RemoteControll {
	public int MAX_VOLUMN = 10;
	public int MIN_VOLUMN = 0;
	
	public void turnOn();
	public void turnOff();
	public void setVolumn(int volumn);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음처리");
		} else {
			System.out.println("무음해제");
		}
	}
	
	static void changeBattery() {
		System.out.println("배터리 교환");
	}
}
