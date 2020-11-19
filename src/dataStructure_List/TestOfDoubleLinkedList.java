package dataStructure_List;

import java.util.Iterator;

public class TestOfDoubleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new DoubleLinkedList<Integer>();

		// 데이터 추가
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(2, 25);
//		list.remove(3);

//		// 전체 데이터 순서대로 가져오기
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "번째 데이터 : " + list.get(i));
		}
//
//		// 전체 데이터 수 출력
//		System.out.println("현재 데이터 수:" + list.size());

		// Iterator 사용하기
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
