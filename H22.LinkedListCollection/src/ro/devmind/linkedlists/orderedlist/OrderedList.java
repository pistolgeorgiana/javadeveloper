package ro.devmind.linkedlists.orderedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class OrderedList<T extends Comparable<T>> {
	private List<T> elements = new LinkedList<>();
	 
	  public boolean addInOrderedList(T newElement) {
	    ListIterator<T> li = elements.listIterator();
	 
	    while (li.hasNext()) {
	      int comparison = li.next().compareTo(newElement);
	 
	      if (comparison < 0) { 
	      } else if (comparison > 0) { 
	        li.previous();
	        li.add(newElement);
	        return true;
	      } else {
	        return false;
	      }
	    }
	    li.add(newElement);
	    return true;
	  }
	 
	  @Override
	  public String toString() {
	    String ret = "";
	    for(T el : elements) {
	      ret += el + "\n";
	    }
	    return ret;
	  }
}
