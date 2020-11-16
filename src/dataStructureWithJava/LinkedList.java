package dataStructureWithJava;

public class LinkedList<E> implements List<E>{

	private int size;
	private Node<E> head;
	
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(element);
		
		if(head == null) { // ���� ��� ����X
			head = newNode;
		} else {
			Node<E> last = head; // head����(index=0) �������� �ɶ�(null) ���� ������ ��带 ã�ư�
			while(last.next != null) {
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
		size++;
		Node<E> newNode = new Node<E>(element);
		
		Node<E> last = head;
		
		for(int i = 0 ; i < index-1 ; i++) {
			last = last.next;
		}
		Node<E> nextStart = last.next;
		last.next = newNode;
		newNode.next = nextStart;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		Node<E> x = head;
		for(int i = 0 ; i < index; i++) {
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		
		Node<E> last = head;
		
		for(int i = 0 ; i< index ;i++) {
			last = last.next; // for�� ������ last���� index�� �ּҰ���������
			System.out.println(last.next+"next:"+last.data);
		}
		
		System.out.println(last.next.data+"asdf");
		last.next = last.next.next;
//		last.next; // remove�� ��� ���� �ּ�
		
		
		size--;
		
		return last.data;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		for(Node<E> x = head; x != null;) {
			Node<E> next = x.next;
			x.data = null;
			x.next = null;
			x = next;
		}
		head = null;
		size = 0;
	}
	
	private void checkBoundExclusive(int index) { 
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
	}
	
	private void checkBoundInclusive(int index) { 
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+ size);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private class Node<E>{ // inner Class
		private Node<E> next; // next : ���� ��� ����Ű�� ��
		private E data;
		
		private Node(E element) { // ������1
			this.data = element;
			this.next = null;
		}
		
		private Node(E element, Node<E> next) { // ������2
			this.data = element;
			this.next = next;
		}
	}
	
}