package dataStructureWithJava;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Integer> list = new ArrayList<Integer>();
//		
//		// ������ �߰�
//		list.add( 1 );
//		list.add( 2 );
//		list.add( 3 );
//		list.add( 4 );
//		list.add( 5 );
//		list.add( 6 );
//		list.add( 7 );
//		list.add(2, 25);
//		list.remove(3);
//				
//		// ��ü ������ ������� ��������
//		for( int i = 0; i < list.size(); i++ ) {
//		    System.out.println( i + "��° ������ : " + list.get( i ) );
//		}
//
//		// ��ü ������ �� ���
//		System.out.println( "���� ������ ��:" + list.size() );
//
//		// ��ü ������ ����
//		list.removeAll();
//
//		// ��ü ������ �� ���
//		System.out.println( "���� ������ ��:" + list.size() );
//				
//		//���� �߻���Ű��
//		try {
//		     list.get( 0 );
//		 } catch( IndexOutOfBoundsException e ) {
//		    e.printStackTrace();
//		}
		
		List<Integer> list = new LinkedList<Integer>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		System.out.println("���� ������ ��: "+ list.size());
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+"��° ������:"+ list.get(i));
		}
		System.out.println();
		
		list.add(2, 25);
		list.remove(2);
		
		System.out.println("���� ������ ��: "+list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+"��° ������:"+ list.get(i));
		}
	}

}
