package quiz;

public class Quiz3 {
	public static void main(String[] args) {
		// Q3. 아래와 같은 출력문을 만들어보세요
		// ABCDEFGHIJKLMNOPQRSTUVWXYZ
		// ABCDEFGHIJKLMNOPQRSTUVWXY
		// ABCDEFGHIJKLMNOPQRSTUVWX
		// ABCDEFGHIJKLMNOPQRSTUVW
		// ABCDEFGHIJKLMNOPQRSTUV
		// ....
		// ...
		// ...
		// AB
		// A
		char ch = 90;
		int last = 90;
		for(int j = 26; j >=0; j--) {
			for(int i =65; i <= last; i++) {
				ch = (char)i;
				System.out.print(ch);
			}
			System.out.println("");
			last--;
		}
	}
}
