package random;

public class random3 {
	
	public static void main (String [ ]args) {
		int firstone [ ][ ]={{1,2,3,5}, {5,6,7,8}, {5,6,7,8}};
		int secondone [ ][ ]={{1,2,3,5}, {5,6,7,8}, {5,6,7,8}};
		System.out.println("first one");
		display(firstone);
		System.out.println("second one");
		display(secondone);		
		}
	
	public static void display (int x [][]) {
		for (int row=0;row<x.length;row++){
			for (int column=0;column<x[row].length; column++){
				System.out.print(x[row][column]+"\t");
			}
			System.out.println();
		}
	}
		
		
	}

