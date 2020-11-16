package dataStructureWithJava;

public class AnonymousObjectExample_Television implements AnonymousObjectExample_RemoteControll{
	private int volumn;

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV¸¦ ÄÕ´Ï´Ù.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV¸¦ ²ü´Ï´Ù.");
	}

	@Override
	public void setVolumn(int volumn) {
		// TODO Auto-generated method stub
		if(volumn > AnonymousObjectExample_RemoteControll.MAX_VOLUMN) {
			this.volumn = AnonymousObjectExample_RemoteControll.MAX_VOLUMN;
		} else if(volumn < AnonymousObjectExample_RemoteControll.MIN_VOLUMN) {
			this.volumn = AnonymousObjectExample_RemoteControll.MIN_VOLUMN;
		} else {
			this.volumn = volumn;
		}
		System.out.println("ÇöÀç TV º¼·ý: " + this.volumn);
	}

}
