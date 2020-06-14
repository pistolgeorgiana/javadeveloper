package ro.devmind.linkedlists.exercices;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class RemoveDuplicates {
	public static void removeDuplicates(List<Integer> head) {
		ListIterator<Integer> it = head.listIterator();
		
		if (it.hasNext()) {
			int current = it.next();
			while (it.hasNext()) {
				int next = it.next();
				if(next == current) {
					it.remove();
				}
				current = next;
			}
		}
    }
	
	public static void removeDuplicates2(List<Integer> head) {
		ListIterator<Integer> it = head.listIterator();
		
		if (it.hasNext()) {
			int current = it.next();
			while (it.hasNext()) {
				int next = it.next();
				if(next == current) {
					it.previous();
					it.previous();
					while(current == next) {
						it.remove();
						if(!it.hasNext()) {
							break;
						} 
						next = it.next();
					}
				} 
				current = next;
			}
		}
    }
	
	public static void main(String[] args) {
		List<Integer> duplicates = new LinkedList<>();
		 
	    duplicates.add(1);
	    duplicates.add(2);
	    duplicates.add(2);
	    duplicates.add(7);
	    duplicates.add(7);
	    duplicates.add(8);
	    duplicates.add(9);
	    duplicates.add(9);
	    duplicates.add(9);
	    duplicates.add(9);
	    duplicates.add(10);

//	    removeDuplicates(duplicates);
	    removeDuplicates2(duplicates);
	    
	    for(Integer el : duplicates) {
	    	System.out.println(el);
	    }
	}
}
