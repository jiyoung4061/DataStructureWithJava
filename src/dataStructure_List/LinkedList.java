package dataStructure_List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

	private int size;
	private Node<E> head;

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(element);

		if (head == null) { // 현재 노드 존재X
			head = newNode;
		} else {
			Node<E> last = head; // head부터(index=0) 마지막이 될때(null) 까지 마지막 노드를 찾아감
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}

		size++;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		Node<E> newNode = new Node<E>(element);
		Node<E> last = head;

		for (int i = 0; i < index - 1; i++) {
			last = last.next;
		}

//		// M1. 내 방법 => 첫번째 index, 마지막 index에 추가할 경우를 안함!!
//		last.next = newNode;
//		newNode.next = last.next;

		// M2. 선생님 방법
		if (index == size) { // 마지막 index 추가할 경우!
			add(element);
			return;
		}
		if (index == 0) { // 맨앞에 추가할 경우
			head = newNode;
			newNode.next = last;
		} else {
			newNode.next = last.next;
			last.next = newNode;
		}

		size++;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		Node<E> x = head;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);

		// M2. 선생님 방법
		E element;
		if (index == 0) {
			element = head.data;
			head = head.next;
		} else {
			Node<E> last = head;
			for (int i = 0; i < index - 1; i++) {
				last = last.next;
			}

			element = last.next.data;
			last.next = last.next.next;
		}
		size--;
		return element;

//		// M1. 내가 한 방법 => 첫번째 요소 지우기가 없음. && 반환값 체크!
//		Node<E> last = head;
//		
//		for(int i = 0 ; i< index-1 ;i++) {
//			last = last.next; // for문 끝나면 last에는 index의 주소값갖고있음
//		}
//		last.next = last.next.next; // remove할 노드 다음 주소
//		size--;
//		
//		return last.data;	

	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		for (Node<E> x = head; x != null;) {
			Node<E> next = x.next;
			x.data = null;
			x.next = null;
			x = next;
		}
		head = null;
		size = 0;
	}

	private void checkBoundExclusive(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	private void checkBoundInclusive(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	private class Node<E> { // inner Class
		private Node<E> next; // next : 다음 노드 가르키는 것
		private E data;

		private Node(E element) { // 생성자1
			this.data = element;
			this.next = null;
		}

		private Node(E element, Node<E> next) { // 생성자2
			this.data = element;
			this.next = next;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub

		return new Iterator<E>() {

			private Node<E> x = head;

			@Override
			public boolean hasNext() { // 다음 요소 존재시 true, 존재 안하면 false
				// TODO Auto-generated method stub
				return x != null;
			}

			@Override
			public E next() { // 다음 요소 반환
				// TODO Auto-generated method stub
				
				if (x == null) {
					throw new NoSuchElementException();
				}
				E data = x.data;
				x = x.next;
				return data;
			}

		};
	}

}
