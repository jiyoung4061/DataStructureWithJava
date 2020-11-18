package dataStructure_Stack;

import dataStructure_List.ArrayList;

public class Stack<E> extends ArrayList<E> {
	public void push( E item ) {
		add(item);
    }

    public E pop() {
        return remove(size()-1);
    }
	
    public E peek() {
        return get(size()-1);
    }
	
    public boolean empty() {
        return size()==0;
    }
}
