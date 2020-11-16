package dataStructureWithJava;

public class AnonymousObjectExample_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonymousObjectExample_RemoteControll rc;
		
		rc = new AnonymousObjectExample_RemoteControll() {
			// AnonymousObjectExample_Television을 익명객체로 사용한 코드
			private int volumn;

			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("TV를 켭니다.");
			}

			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("TV를 끕니다.");
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
				System.out.println("현재 TV 볼륨: " + this.volumn);
			}
		};
		rc.turnOn();
		rc.turnOff();
		
		// 이클립스 제공 기능 사용 => new 타입 작성후 ctrl+space 누르면 자동으로 override되어서 작성됨
		AnonymousObjectExample_RemoteControll rc2 = new AnonymousObjectExample_RemoteControll() {
			
			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setVolumn(int volumn) {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

}
