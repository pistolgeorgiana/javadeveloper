package ro.devmind.queue.classes;

import java.util.NoSuchElementException;

import ro.devmind.linkedlists.classes.MyLinkedList;

public class MyQueue<E> {
	private MyLinkedList<E> list;

	public MyQueue() {
		this.list = new MyLinkedList<E>();
	}
	
	public MyQueue(MyLinkedList<E> list) {
		this.list = new MyLinkedList<E>(list);
	}
	
	public boolean add(E e) {
		if(e != null) {
			list.add(e);
			return true;
		}
		throw new IllegalStateException();
	}
	
	public boolean offer(E e) {
		if(e != null) {
			list.add(e);
			return true;
		}
		return false;
	}
	
	public E peek() {
		return list.get(0);
	}
	
	public E poll() {
		return list.removeElementAtIndex(0);
	}
	
	public E element() {
		if(list.isEmpty()) {
			throw new NoSuchElementException();
		}
		return list.get(0);
	}
	
	public E remove() {
		if(list.isEmpty()) {
			throw new NoSuchElementException();
		}
		return list.removeElementAtIndex(0);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
