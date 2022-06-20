package condtion;

import java.util.Scanner;

public class RSPGame {
	public static void main(String[] args) {
		// 가위바위보 게임 만들기
		// 1. 컴퓨터가 랜덤으로 가위바위보 선택
		// 2. 나도 가위바위보를 입력
		// 3. 승무패 결과 출력
		int ran = (int) ((Math.random()*10)+1);
		String com = "";
		if(ran <3) {
			com = "가위";
		} else if (ran < 6) {
			com  ="바위";
		} else {
			com = "보";
		}
		System.out.println(com);
		Scanner sc = new Scanner(System.in);
		System.out.println("가위바위보 중 하나 입력 >");
		String user = sc.next();
//		System.out.println(com.equals(user));
		if(com.equals(user)) {
			System.out.println("비김 com = "+com);
		} else if ((com.equals("가위") && user.equals("바위")) || (com.equals("바위") && user.equals("보"))|| (com.equals("보") && user.equals("가위"))) {
			System.out.println("너가 이김 com= " +com);
		} else {
			System.out.println("허접 컴터한테 지냐 com =" + com);
		}
		System.out.println("게임종료");
		
	}
}
