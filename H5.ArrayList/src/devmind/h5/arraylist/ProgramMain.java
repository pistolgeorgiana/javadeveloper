package devmind.h5.arraylist;

import java.util.ArrayList;

public class ProgramMain {
	public static void main(String[] args) {
		ArrayList<String> studs = new ArrayList<String>();
		studs.add("Alina");
		studs.add("Marius");
		
		CollectionArray studenti = new CollectionArray();
		studenti.addMultipleStudents(studs);
		
		studenti.updateOrAddStudent("Marius", "Daniel");
		System.out.println(studenti.getStudent(1) + "\n\n");
		
		studenti.updateOrAddStudent("Ana", "Andreea");
		studenti.updateOrAddStudent("Gabi", "Ana");
		
		MaxFrequency.maxFrequency(studenti.getStudenti());
		
		studenti.deleteStudent("Ana");
		
		System.out.println();
		MaxFrequency.maxFrequency(studenti.getStudenti());
		System.out.println();
		
		studenti.deleteStudents(studs);
		studenti.displayStudents();
		
		studenti.deleteStudent("Ion");
	}
}
