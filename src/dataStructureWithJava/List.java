package dataStructureWithJava;

public interface List<E> {
	void add(E element);
	void add(int index, E element);
	E get(int index);
	E remove(int index);
	void removeAll();
	int size();
}
