package dataStructure_List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{
	private int size;
	private E[] data;

	public ArrayList() { // arrayList 생성자
		this.size = 0;
		resize();
	}
	private void resize() {
		if(size == 0 ) {
			data = (E[]) new Object[10]; // 제네릭타입으로 배열을 만드는 방법 : object타입으로 배열을 만들고 형변환해줌
		} else {
			E[] newData = (E[]) new Object[size + 10];
			System.arraycopy(data, 0, newData, 0, size);
			// System.arraycopy(src, srcPos, des, desPos, length); // src의 srcPos부터 length만큼 des에 desPos부터 copy함 
			data = newData; // copy한 새 배열로 현재 배열 교체!
		}
	}
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		if(data.length == size) {
			resize();
		}
		
		data[size++] = element;
	}
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		
		if(data.length == size) {			
			resize();
		}
		
//		//M1. 내가 한 방법
//		for(int i = size ; i >= index ; i--) {
//			if(i == index) {
//				data[index] = element;
//			} else {
//				data[i] = data[i-1];
//			}
//		}
		
		//M2. 선생님 방법
		if(index != size)
			System.arraycopy(data, index, data, index+1, size-index);
		data[index] = element;
		
		size++;
	}
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		return data[index];	
	}
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		
//		//M1. 내가 한 방법
//		for(int i = index ; i < size ; i++) {
//			data[i] = data[i+1];
//		}
//		size--;
//		return (E) data;
		
		//M2. 선생님 방법
		E r = data[index];
		if(index != --size)
			System.arraycopy(data, index+1, data, index, size-index);
		
		return r;
	}
	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		size = 0;
		// 데이터는 안지워주나? => 기존의 데이터값을 쓰레기값으로 여기고 size를 0으로하면 데이터를 굳이 안지워도댐
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	private void checkBoundExclusive(int index) { // 경계값 포함O
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
	}
	private void checkBoundInclusive(int index) { // 경계값 포함X
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+ size);
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		
		return new Iterator<E> () {
			
			private int pos = 0;
			private int size = size();
			
			@Override
			public boolean hasNext() { // 다음 요소 존재시 true, 존재 안하면 false
				// TODO Auto-generated method stub
				return pos < size;
			}
			
			@Override
			public E next() { // 다음 요소 반환
				// TODO Auto-generated method stub
				if(pos == size) {
					throw new NoSuchElementException();
				}
				
				return data[pos++];
			}
			
		};
		
		
	}
}
