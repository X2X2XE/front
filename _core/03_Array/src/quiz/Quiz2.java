package quiz;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		// 테스트에 참여할 인원수를 입력하세요 > 3
		// 1번째 사람의 이름을 입력하세요 >
		// 1번째 사람의 국어점수 입력 >
		// 1번째 사람의 영어점수 입력 >
		// 1번째 사람의 수학점수 입력 >
		// ...
		// 3번째 사람의 수학점수 입력 >
		// 이름 국어 영어 수학 총점 평균
		// aaa 88  99  87  ?   ? 
		// ...
		
		Scanner sc = new Scanner(System.in);
		System.out.println("테스트에 참여할 인원수를 입력하세요 >>");
		int tester = sc.nextInt();
		String[][] test_info = new String[tester][4];
		for(int i=0; i< test_info.length;i++) {
			for(int j=0; j < test_info[i].length;j++) {
				if(j==0) {
					System.out.println((i+1) + " 번째 사람의 이름을 입력하세요 >>");
					test_info[i][j] = sc.next();
				} else if(j==1) {
					System.out.println((i+1) + " 번째 사람의 국어점수을 입력하세요 >>");
					test_info[i][j] = sc.next();
				} else if(j==2) {
					System.out.println((i+1) + " 번째 사람의 영어점수을 입력하세요 >>");
					test_info[i][j] = sc.next();
				} else if(j==3) {
					System.out.println((i+1) + " 번째 사람의 수학점수을 입력하세요 >>");
					test_info[i][j] = sc.next();
				}
			}
		}
		DecimalFormat df = new DecimalFormat("#.##"); // 소수점 방식
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------------");
		for(int i=0; i <test_info.length; i++) {
			float hab =0;
			for(int j=0; j <test_info[i].length; j++) {
				System.out.print(test_info[i][j]+"\t");
				if(j >0) {
					hab += Integer.parseInt(test_info[i][j]);
				}
			}
			System.out.println(hab+"\t"+df.format(hab/3)); 
			
			
		}
	}
}
