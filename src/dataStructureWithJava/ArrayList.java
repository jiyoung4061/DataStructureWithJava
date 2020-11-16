package dataStructureWithJava;


public class ArrayList<E> implements List<E>{
	private int size;
	private E[] data;

	public ArrayList() { // arrayList ������
		this.size = 0;
		resize();
	}
	
	private void resize() {
		if(size == 0 ) {
			data = (E[]) new Object[10]; // ���׸�Ÿ������ �迭�� ����� ��� : objectŸ������ �迭�� ����� ����ȯ����
		} else {
			E[] newData = (E[]) new Object[size + 10];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData; // copy�� �� �迭�� ���� �迭 ��ü!
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
