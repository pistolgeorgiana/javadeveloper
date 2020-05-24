package devmind.h6.myintarraylist;

import java.util.Arrays;

public class MyIntArrayList {
	private int[] array;
	private int size;
	
	public MyIntArrayList(int size) {
		this.array = new int[size];
		this.size = size;
	}

	public MyIntArrayList() {
		this(10);
	}

	public MyIntArrayList(MyIntArrayList c) {
		this.size = c.size();
		this.array = new int[this.size];
		for(int i=0; i<c.size(); i++) {
			this.array[i] = c.get(i);
		}
	}

	public void add(int index, int element) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		if (this.size == this.array.length) {
			this.array = Arrays.copyOf(this.array, 2 * this.size);
		}
		
		for(int i=this.size; i >= index ; i--) {
			this.array[i] = this.array[i - 1];
		}
		this.size++;
		
		this.array[index] = element;
	}
	
	public boolean add(int e) {
		if (this.size == this.array.length) {
			this.array = Arrays.copyOf(this.array, 2 * this.size);
		}
		
		this.array[size] = e;
		this.size++;
		
		return true;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean contains(int e) {
		for (int i=0; i<this.size; i++) {
			if (this.array[i] == e) {
				return true;
			}
		}
		
		return false;
	}
	
	public int get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		return this.array[index];
	}
	
	public int indexOf(int e) {
		for(int i=0; i<this.size; i++) {
			if (this.array[i] == e) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int lastIndexOf(int e) {
		for (int i=this.size - 1; i>=0; i--) {
			if (this.array[i] == e) {
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean remove(int e) {
		for(int i=0; i<this.size; i++) {
			if(this.array[i] == e) {
				for(int j=i; j<this.size - 1; j++) {
					this.array[j] = this.array[j+1];
				}
				this.size--;
				
				return true;
			}
		}
		
		return false;
	}
	
	public int removeElementAtIndex(int index) {
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		int removedElement = this.array[index];
		for(int i=index; i<this.size; i++) {
			this.array[index] = this.array[index + 1];
		}
		this.size--;
		
		return removedElement;
	}
	
	public void clear() {
		this.size = 0;
	}
	
	public int set(int index, int e) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		int replacedElement = this.array[index];
		this.array[index] = e;
		
		return replacedElement;
	}
	
	public boolean addAll(MyIntArrayList c) {
		if (c == null) {
			throw new NullPointerException();
		}
		
		int dim = this.size + c.size();
		if (dim > this.array.length) {
			this.array = Arrays.copyOf(this.array, dim * 2);
		}
		for(int i=this.size; i < dim; i++) {
			this.array[i] = c.get(i - 1 - c.size() - 1);
		}
		this.size = dim;
		
		return true;
	}
	
	public boolean addAll(int index, MyIntArrayList c) {
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		} else if (c == null) {
			throw new NullPointerException();
		}
		
		this.size += c.size();
		if (this.size > this.array.length) {
			this.array = Arrays.copyOf(this.array, this.size * 2);
		}
		
		int dim = index + c.size();
		for(int i=this.size - 1; i >= dim; i--) {
			this.array[i] = this.array[i - c.size()];
			
		}
		for(int i=index; i<dim; i++) {
			this.array[i] = c.get(i - index);
		}
		
		return true;
	}
	
	public int[] toArray() {
		if(this.size != this.array.length) {
			this.array = Arrays.copyOf(this.array, this.size);
		}
		return this.array;
	}
	
	public void ensureCapacity(int minCapacity) {
		if(this.array.length < minCapacity) {
			this.array = Arrays.copyOf(this.array, minCapacity * 2);
		}
	}
	
	public void trimToSize() {
		if(this.size != this.array.length) {
			this.array = Arrays.copyOf(this.array, this.size);
		}
	}
}
