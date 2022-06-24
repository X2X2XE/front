package quiz;

public class Quiz6_2 {

	public static void main(String[] args) {
		star();

	}

	private static void star() {
		for(int i=1; i < 5; i++) {
			for(int j=0; j <i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
	}

}
