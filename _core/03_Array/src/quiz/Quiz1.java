package quiz;

import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		// 24절기 맞추기 게임
		String[] seasonal = {
			"입춘","우수","경칩","춘분",
			"청명","곡우","입하","소만",
			"망종","하지","소서","대서",
			"입추","처서","백로","추분",
			"한로","상강","입동","소설",
			"대설","동지","소한","대한"
		};
		// ? 번째 절기는 무엇입니까>?
		// 정답 or 오답이니다 > 정답은 ? 
		// 몇 번 시도했는지 출력
		Scanner sc = new Scanner(System.in);
		int comnum = (int)(Math.floor(Math.random()*24)+1);
		String com = seasonal[comnum-1];
		System.out.println("24절기 게임 맞추기");
		for(int i=1;;i++) {
			System.out.println(comnum + " 번째 절기를 입력하세요 >");
			String user = sc.next();
			if(user.equals(com)) {
				System.out.println(i + " 번째 시도 >> 정답입니다! 정답은 : " + com);
				break;
			} else {
				System.out.println(i + " 번째 시도 >> 오답입니다! 다시 입력하세요");
			}
		}
		
		System.out.println("게임 종료");
		
	}
}
