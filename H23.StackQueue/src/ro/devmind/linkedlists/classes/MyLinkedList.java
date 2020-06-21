package ro.devmind.linkedlists.classes;

public class MyLinkedList<E> {
	private int size;
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode tail;

	public MyLinkedList() {
		this.size = 0;
	}

	public MyLinkedList(MyLinkedList<E> c) {
		this.size = c.size;
		this.head = c.head;
		this.tail = c.tail;
	}

	public void add(int index, E element) {
		if(index < 0 || index > this.size) {
			throw new IllegalArgumentException();
		}
		DoubleLinkedListNode node = new DoubleLinkedListNode(element, null, null);
		if(this.size == 0) {
			this.head = node;
			this.tail = this.head;
		} else {
			DoubleLinkedListNode it = this.head;
			for(int i = 0; i < index - 1; i++) {
				it = it.next();
			}			
			if(index == 0) {
				this.head = node;
				node.next(it);
				
			} else {
				node.next(it.next());
				node.prev(it);
				it.next(node);
			}
		}
		this.size++;
	}
	
	public boolean add(E e) {
		DoubleLinkedListNode newNode = new DoubleLinkedListNode(e, null, tail);
		if(this.head == null) {
			this.head = newNode;
		}
		if(this.tail != null) {
			this.tail.next(newNode);
		}
		this.tail = newNode;
		this.size++;
		return true;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean contains(E e) {
		for(DoubleLinkedListNode it = head; it != null; it = it.next()) {
			if(it.value().equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	public E get(int index) {
		if(index < 0 || index >= this.size) {
			throw new IllegalArgumentException();
		}
		DoubleLinkedListNode it = this.head;
		for(int i = 0; i < index; i++) {
			it = it.next();
		}
		return it.value();
	}
	
	public int indexOf(E e) {
		int index = 0;
		DoubleLinkedListNode it = this.head;
		while (it != null) {
			if(it.value().equals(e)) {
				return index;
			}
			it = it.next();
			index++;
		}
		return -1;
	}
	
	public int lastIndexOf(E e) {
		int index = this.size - 1;
		DoubleLinkedListNode it = this.tail;
		while (it != null) {
			if(it.value().equals(e)) {
				return index;
			}
			it = it.prev();
			index--;
		}
		return -1;
	}
	
	public boolean remove(E e) {
		DoubleLinkedListNode it = this.head;
		while(it != null) {
			if(it.value().equals(e)) {
				it.prev().next(it.next());
				it.next().prev(it.prev());
				if(it.next() == null) {
					this.tail = it.prev();
				}
				this.size--;
				return true;
			}
			it = it.next();
		}
		return false;
	}
	
	public E removeElementAtIndex(int index) {
		if(index < 0 || index >= this.size) {
			throw new IllegalArgumentException();
		}
		DoubleLinkedListNode it = this.head;
		for(int i = 0; i < index - 1; i++) {
			it = it.next();
		}
		E val;
		if (index == 0 && index != this.size - 1) {
			val = it.value();
			this.head = it.next();
			this.head.prev(null);
		} else if (index == this.size - 1) {
			val = this.head.value();
			this.head = null;
			this.tail = null;
		} else {
			val = it.next().value();
			it.next(it.next().next());
			if(it.next() != null) {
				it.next().prev(it);
			}
			if(index == this.size - 1) {
				this.tail = it;
			}
		}
		this.size--;
		return val;
	}
	
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public E set(int index, E e) {
		if(index < 0 || index >= this.size) {
			throw new IllegalArgumentException();
		}
		DoubleLinkedListNode it = this.head;
		for(int i = 0; i < index; i++) {
			it = it.next();
		}
		E val = it.value();
		it.value(e);
		return val;
	}
	
	public boolean addAll(MyLinkedList<E> c) {
		if(c != null && c.head != null && c.tail != null) {
			if(this.head == null) {
				this.head = c.head;
			} else {
				this.tail.next(c.head);
				this.tail.next().prev(this.tail);
				this.tail = c.tail;
				this.size += c.size;
			}
			return true;
		}
		return false;
	}
	
	public boolean addAll(int index, MyLinkedList<E> c) {
		if(index < 0 || index > this.size) {
			throw new IllegalArgumentException();
		}
		if(c != null && c.head != null && c.tail != null) {
			if(index == 0 && this.head == null && this.tail == null) {
				this.head = c.head;
				this.tail = c.tail;
			} else {
				DoubleLinkedListNode it = this.head;
				for(int i = 0; i < index - 1; i++ ) {
					it = it.next();
				}
				DoubleLinkedListNode node = it.next();
				c.tail.next(node);
				node.prev(c.tail);
				it.next(c.head);
				it.next().prev(it);
				if(index == this.size - 1) {
					this.tail = c.tail;
				}
			}
			
			this.size += c.size;
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public Object[] toArray() {
		Object[] res = new Object[this.size];
		int index = 0;
		for(int i = 0; i < this.size(); i++) {
			res[index++] = this.get(i);
 		}
		return res;
	}
	
	private class DoubleLinkedListNode {
		private E value;
		private DoubleLinkedListNode next;
		private DoubleLinkedListNode previous;

		public DoubleLinkedListNode(E value, DoubleLinkedListNode next, DoubleLinkedListNode previous) {
			super();
			this.value = value;
			this.next = next;
			this.previous = previous;
		}

		public DoubleLinkedListNode() {
		}

		public DoubleLinkedListNode(E value) {
			this(value, null, null);
		}

		public void value(E value) {
			this.value = value;
		}
		
		public E value() {
			return this.value;
		}
		
		public DoubleLinkedListNode next() {
			return next;
		}
		
		public void next(DoubleLinkedListNode next) {
			this.next = next;
		}
		
		public DoubleLinkedListNode prev() {
			return this.previous;
		}
		
		public void prev(DoubleLinkedListNode previous) {
			this.previous = previous;
		}
	}
}
