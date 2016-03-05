package enumss;

import java.util.EnumSet;

public class Driver {
	
	public static void main (String[] args){
		
		for (Enumz people: Enumz.values() ){
			System.out.printf("%s\t%s\t%s\n", people, people.getCity(), people.getAge());
		}
		
		for (Enumz people: EnumSet.range(Enumz.akbar, Enumz.azemoon)){
			System.out.printf("%s\t%s\t%s\n", people, people.getCity(), people.getAge());

		}
	}

}
