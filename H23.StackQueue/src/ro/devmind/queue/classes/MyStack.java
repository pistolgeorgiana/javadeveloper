package ro.devmind.queue.classes;

import ro.devmind.linkedlists.classes.MyLinkedList;

public class MyStack<E> {
	private MyLinkedList<E> list;

	public MyStack() {
		this.list = new MyLinkedList<E>();
	}
	
	public MyStack(MyLinkedList<E> list) {
		this.list = new MyLinkedList<E>(list);
	}
	
	public boolean empty() {
		return list.isEmpty();
	}
	
	public E peek() {
		return list.get(0);
	}
	
	public E pop() {
		return list.removeElementAtIndex(0);
	}
	
	public E push(E item) {
		list.add(0, item);
		return item;
	}
	
	public int search(E elem) {
		return list.indexOf(elem);
	}
}
