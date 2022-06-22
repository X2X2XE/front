package quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		// 숫자 야구 게임
		int[] com = new int[3];
		
		for(int i=0;i<3;i++) { //3자리 랜덤으로 넣기
			com[i] = (int)Math.floor(Math.random()*9);
			if(i>0) {
				for(int j=0;j <i;j++) {
					while(com[i] == com[j]) {//중복되면 다시 랜덤문 반복
						com[j] = (int)Math.floor(Math.random()*9); 
					}
				}
			}
		}
		// 컴퓨터 설정완료
		Scanner sc = new Scanner(System.in);
		for(int i=1;;i++) { // 무한루프로 만듬
			int straki = 0;
			int ball = 0;
			System.out.println("숫자야구 중첩되지 않는 숫자 3개 입력 >>");
			String user = sc.next();// 입력받기
			String[] user_arr = user.split("");
			if(user.length()!=3) { // 입력한 값이 3자리인지 확인
				System.out.println("입력한 값이 3자리가 아닙니다!!!!! 다시 입력하세요 입력 값 : " +user);
			} else if(user.length()==3) { // 중복되지 않다면 볼과 스트라이크 판단
				if(user_arr[0].equals(user_arr[1]) || user_arr[0].equals(user_arr[2]) || user_arr[1].equals(user_arr[2])) {
					System.out.println("입력한 값이 중복되었습니다. 다시 입력하세요 입력 값 : " + user );
				} else {
					for(int j=0; j<3; j++) { 
						if(com[j] == Integer.parseInt(user_arr[j])){ //자리값과 숫자값이 같다면 증가
							straki++;
							
						}
						for(int k=0; k<3; k++) { 
							if(!(j==k) && com[j] == Integer.parseInt(user_arr[k])) { //자리값은 다른데 숫자가 같다면 증가
								ball++;
								
							}
						}
					}
					if(straki==0 && ball==0) { // Out인지 확인
						System.out.println("OUT!!!!!!!!!!!!!!");
					} else { // out이 아니라면 스트라이크와 볼 갯수 출력
						System.out.println("스타라이크 : "+straki+" 볼 : "+ball);
					}
				}
			}
			if(straki == 3) { //스트라이크가 3개라면 정답 출력후 종료
				System.out.print("게임종료 정답 : ");
				for (String str : user_arr) {
					System.out.print(str);
				}
				break;
			}
		}

	}
}
