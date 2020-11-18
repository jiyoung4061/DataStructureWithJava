package dataStructure_List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements List<E> {

	private int size;
	private Node<E> head;
	private Node<E> tail;

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>() {

			private Node<E> pos = head;

			@Override
			public boolean hasNext() { 
				// TODO Auto-generated method stub
				return pos != null;
			}

			@Override
			public E next() { 
				// TODO Auto-generated method stub
				if(pos == null)
					throw new NoSuchElementException();
				E data = pos.data;
				pos = pos.next;
				return data;
			}

		};
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(element);

		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);

		if (index == size) {
			add(element);
			return;
		}
		
		Node<E> newNode = new Node<E>(element);
		Node<E> pos = head;
		
//		// 내방법
//		if (index == 0) {
//			newNode.next = head;
//			head = newNode;
//		} else {
//			for (int i = 0; i < index; i++) {
//				pos = pos.next;
//			}
//			pos.prev.next = newNode;
//			newNode.prev = pos.prev;
//			pos.prev = newNode;
//			newNode.next = pos;
//		}
		
		// 선생님방법
		for(int i = 0 ; i < index; i++) {
			pos = pos.next;
		}
		
		if(index == 0) {
			newNode.prev = pos.prev;
			newNode.next = pos;
			head = newNode;
		} else {
			pos.prev.next = newNode;
			newNode.prev = pos.prev;
			newNode.next = pos;
			pos.prev = newNode;
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
		Node<E> pos = head;
		
//		// 내방법
//		E element;
//		if (index == 0) {
//			element = pos.data;
//			head = head.next;
//		} else {
//			for (int i = 0; i < index; i++) {
//				pos = pos.next;
//			}
//			element = pos.data;
//			pos.prev.next = pos.next;
//			pos.next.prev = pos.prev;
//		}
		
		//선생님방법
		for(int i = 0 ; i < index ; i++) {
			pos = pos.next;
		}
		
		if(index == 0) {
			if(size==1) { // 제거요소 하나만 있는 경우
				head = null;
				tail = null;
			} else { 
				pos.next.prev = pos.prev;
				head = pos.next;
			}
		} else if(pos == tail) { // 마지막요소를 제거하는 경우
			pos.prev.next = pos.next;
			tail = pos.prev;
		} else {
			pos.prev.next = pos.next;
			pos.next.prev = pos.prev;
		}
		
		size--;
		return pos.data;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		Node<E> x = head;
		while (x != null) {
			Node<E> next = x.next;
			x.next = null;
			x.prev = null;
			x = next;
		}

		head = null;
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
		private Node<E> prev;
		private E data;

		private Node(E element) {
			this.data = element;
			this.next = null;
			this.prev = null;
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
