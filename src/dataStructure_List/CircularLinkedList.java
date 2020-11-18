package dataStructure_List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<E> implements List<E> {

	private int size;
	private Node<E> tail;

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>() {

//			// 내방법
//			private Node<E> x = tail.next; // 첫번째 요소
//			private int count = 0;
			
			private Node<E> position = tail == null ? null : tail.next;
			private boolean isFirst = true;
			
			@Override
			public boolean hasNext() { // 마지막 요소일 경우 false, 아니면 true
				// TODO Auto-generated method stub
				
//				// 내방법 => 데이터가 없는경우도 테스트 해볼것!!
//				if( count < size) { // true
//					count++;
//					return true;
//				} else { // false = 마지막요소를 가리키고 있는 경우
//					return false;
//				}
				
				if(position == null) {
					return false;
				}
				if(isFirst) {
					isFirst = false;
					return true;
				}
				
				return (position != tail.next);
			}

			@Override
			public E next() { // 다음 요소 반환
				// TODO Auto-generated method stub
//				// 내방법
//				if (x == tail) {
//					E data = x.data;
//					return data;
//				}
//				E data = x.data;
//				x = x.next;
//				return data;
				
				// 선생님방법
				E data = position.data;
				position = position.next;
				return data;
			}
		};
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(element);

		if (tail == null) { // node가 아무것도 없음
			tail = newNode.next = newNode;
			// newNode.next = newNode
			// tail = newNode.next
		} else {
			newNode.next = tail.next; // newNode의 next에 첫번째 node주소값(tail.next)를 대입 => newNode는 첫번째 node가리킴
			tail.next = newNode; // 마지막 요소가 newNode를 가르킴
			tail = tail.next; // tail이동
		}

		size++;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		Node<E> newNode = new Node<E>(element);

		if (index == size) {
			add(element);
			return;
		}
		
		Node<E> pos;
		
		// 선생님 방법
		if(index == 0) {
			pos = tail;
		} else {
			pos = tail.next;
			for(int i = 0 ; i < index -1 ;i++) {
				pos = pos.next;
			}
		}
//		// 내가한 방법
//		pos = tail;
//		for (int i = 0; i < index; i++) {
//			pos = pos.next;
//		}
		size++;
		newNode.next = pos.next;
		pos.next = newNode;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		Node<E> x = tail.next;

		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		
//		// 내가 한 방법
//		E element;
//		Node<E> pos = tail.next;
//		if (index == 0) { // 첫번째 요소지우기
//			tail.next = pos.next;
//			element = pos.data;
//			pos.next = null;
//			size--;
//		} else {
//			pos = tail;
//			for (int i = 0; i < index; i++) {
//				pos = pos.next;
//			}
//			element = pos.next.data;
//			pos.next = pos.next.next;
//			size--;
//		}
//		return element;
		
		// 선생님 방법
		Node<E> pos;
		if(index == 0) {
			pos = tail;
		} else {
			pos = tail.next;
		}
		
		for(int i = 0 ; i < index -1 ; i++) {
			pos = pos.next;
		}
		
		if(pos.next == tail) { // 삭제 노드가 마지막 노드의 경우
			tail = pos;
		}
		Node<E> deleted;
		deleted = pos.next;
		pos.next = deleted.next;
		size--;
		return deleted.data;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		Node<E> x = tail.next; // x : 첫번째 노드

		while (x != tail) {
			Node<E> next = x.next; // x의 다음 노드
			x.next = null; // x와 다음 노드의 연결을 끊음
			x = next; // x는 다음 노드를 가리킴
		}
		tail.next = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	private static class Node<E> {
		private Node<E> next;
		private E data;

		private Node(E element) {
			this.data = element;
			this.next = null;
		}

		private Node(E element, Node<E> next) {
			this.data = element;
			this.next = next;
		}
	}

	private void checkBoundExclusive(int index) { // 경계값 포함O
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	private void checkBoundInclusive(int index) { // 경계값 포함X
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

}
