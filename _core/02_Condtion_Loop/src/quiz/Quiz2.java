package quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		//Q2. 음수나 0을 입력할때까지 숫자를 계속 입력받고
		// 음수나 0이 입력되면 지금까지 입력된 수의 총합과 평균을 구하세요
		Scanner sc = new Scanner(System.in);
		int hab =0;
		int user = 0;
		for(int i =0;;i++) {
			System.out.println("숫자를 입력하세요 (음수나 0일시 종료) 횟수 : " + i +" >");
			user = sc.nextInt();
			if(user <= 0) {
				System.out.println("총합 : "+ hab +", 평균 : "+(float)(hab/i));
				break;
			}
			hab += user;
		}
		System.out.println("종료");
	}
}
