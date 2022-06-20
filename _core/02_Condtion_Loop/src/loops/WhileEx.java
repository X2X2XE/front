package loops;

public class WhileEx {

	public static void main(String[] args) {
		// 1부터 20까지 합 구하기 while 이용하기
		int num = 1;
		int hab = 0;
		while (num <= 20) {
			hab += num;
			num++;
		}
		System.out.println("1부터 20까지의 합 : "+hab);
		// 1부터 100까지 홀수의 합 구하기 do while 이용하기
		hab = 0;
		num = 1;
		do {
			if(num % 2 == 1) {
				hab += num;
			}
			num++;
		} while(num <= 100);
		
		System.out.println("1부터 100까지 홀수의 합 : "+hab);
	
	
	
	
	
	}

}
