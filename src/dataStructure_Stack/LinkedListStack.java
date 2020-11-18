package dataStructure_Stack;

import dataStructure_List.LinkedList;

public class LinkedListStack<E> extends LinkedList<E>{
	public void push( E item ) {
		add(item);
    }

    public E pop() {
    	if(size()==0) {
    		throw new StackException("Stack is Empty");
    	}
        return remove(size()-1);
    }
	
    public E peek() {
        return get(size()-1);
    }
	
    public boolean empty() {
        return size()==0;
    }
}
