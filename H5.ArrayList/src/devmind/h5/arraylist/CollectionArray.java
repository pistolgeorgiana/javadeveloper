package devmind.h5.arraylist;

import java.util.ArrayList;

public class CollectionArray {
	private ArrayList<String> studenti;
	
	public CollectionArray() {
		studenti = new ArrayList<String>();
	}
	
	public void addMultipleStudents(ArrayList<String> studs) {
		studenti.addAll(studs);
	}

	public void updateOrAddStudent(String studentOld, String studentNew) {
		if (studenti.contains(studentOld)) {
			int index = studenti.indexOf(studentOld);
			studenti.set(index, studentNew);
		} else {
			studenti.add(studentOld);
			studenti.add(studentNew);
		}
	}
	
	public void deleteStudent(String student) {
		int index = this.studenti.lastIndexOf(student); 
		if (index != -1) {
			this.studenti.remove(index);
		} else {
			this.studenti.clear();
		}
	}
	
	public void deleteStudents(ArrayList<String> studenti) {
		for(int i=0; i<studenti.size(); i++) {
			if(this.studenti.contains(studenti.get(i))) {
				this.studenti.remove(studenti.get(i));
			}
		}
	}
	
	public String getStudent(int index) {
		if(index >= 0 && index < this.studenti.size()) {
			return this.studenti.get(index);
		}
		throw new IllegalArgumentException("Index out of bounds");
	}
	
	public void displayStudents() {
		for(int i=0; i<this.studenti.size(); i++) {
			System.out.println(this.studenti.get(i));
		}
	}

	public ArrayList<String> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<String> studenti) {
		this.studenti = studenti;
	}
}
