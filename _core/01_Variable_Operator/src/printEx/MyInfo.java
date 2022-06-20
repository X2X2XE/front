package printEx;

import java.util.Scanner;

public class MyInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Han";
		int age = 28;
		float height = 169.0f;
		double weight = 74.3;
		char blood = 'A';
		boolean vachine = false;
		long asset = 2222222220L;
		String description = "현재 강의 듣는 중";
		
		Scanner sc = new Scanner(System.in);
		
		// 정보 입력 안내
		// 입력받은 정보를 변수에 저장
		System.out.println("이름을 입력하세요 >");
		name = sc.next();
		System.out.println("나이를 입력하세요 >");
		age = sc.nextInt();
		System.out.println("키를 입력하세요 >");
		height = sc.nextFloat();
		System.out.println("몸무게를 입력하세요 >");
		weight = sc.nextDouble();
		System.out.println("혈액형을 입력하세요 > ");
		blood = sc.next().charAt(0);
		System.out.println("백신을 맞으셧습니까? >");
		vachine = sc.nextBoolean();
		System.out.println("당신의 연봉은? >");
		asset = sc.nextLong();
		System.out.println("부가정보를 입력하세요 >");
		description = sc.nextLine();
		
		// 문자 : %s, 정수 : %d, 실수 : %f
		System.out.printf(
		"이름 : %s , 나이 : %d, 키 : %f, 몸무게 : %f,  혈액형 : %s, 백신접종 : %s, 연봉 : %d, %s",
		name, age, height, weight, blood, vachine, asset, description);
	}

}
