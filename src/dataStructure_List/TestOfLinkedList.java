package dataStructure_List;

import java.util.Iterator;

public class TestOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new LinkedList<Integer>();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		System.out.println("현재 데이터 수: " + list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "번째 데이터:" + list.get(i));
		}
		System.out.println();

		list.add(2, 25);
		list.removeAll();

		System.out.println("현재 데이터 수: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "번째 데이터:" + list.get(i));
		}

//		// Iterator 사용하기
//		Iterator<Integer> it = list.iterator();
//		while (it.hasNext()) {
//			int i = it.next();
//			System.out.println(i);
//		}
//
//		System.out.println();
//
//		for (int i : list) {
//			System.out.println(i);
//		}
	}

}
