package dataStructureWithJava;


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
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		try {
			return data[index];			
		} catch(IndexOutOfBoundsException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
}
