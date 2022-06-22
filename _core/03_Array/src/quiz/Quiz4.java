package quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		// Optional
		// 호텔 예약 프로그램
		
		String[][] hotel = new String[10][2];
		
		for(int i=0;i < hotel.length; i++) { //호텔 생성
			hotel[i][0] = ("10"+i);
			hotel[i][1] = "빈방";
			
		}
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;;i++) { //프로그램 시작
			System.out.println("호텔 에약 프로그램입니다 에약을 원하시면 '1'을 빈방의 현황을 보고 싶으시다면 '2'을 종료를 원하시면 '3'를 입력해주세요 >>");
			String ans = sc.next();
			if(ans.equals("1")) { // 예약 시작
				System.out.println("예약을 선택하셧습니다");
				for(int j=0;j <2; j++) { //방 출력
					for(int k=0; k <hotel.length;k++) {
						System.out.print(hotel[k][j]+"\t");
					}
					System.out.println("");
				}
				for(int l=0;;l++) {//방호수 받아서 예약
					int count = 0;
					int ho =10000;
					System.out.println("예약하실 방번호를 입력해 주세요");
					String num = sc.next();
					for(int a=0; a< hotel.length;a++) { // 입력한 호수랑 같은 값이 있는 배열 번호 지정
						if(hotel[a][0].equals(num)) {
							ho = a;
							System.out.println(num);
							break;
						} 
					}
					if(ho < 10) { // 입력한 호수가 있다면
						for(int j=0;;j++) {
							if(hotel[ho][1].equals("빈방")) {// 빈방인지 확인 후 예약
								hotel[ho][1] = "예약";
								System.out.println(num + "호실이 예약되었습니다.");
								count++;
								break;
							} else if(!(hotel[ho][1].equals("빈방"))){ // 빈방이 아니라면 출력
								System.out.println(num + "호실은 빈방이 아닙니다.");
								break;	
							}
						}
					} else if ( ho > 10) { // 입력한 호수가 없다면
						System.out.println("방번호를 잘못 입력햇습니다");
					}
					
					
					if(count >0) {
						break;
					}
				}
			} else if(ans.equals("2")){ // 빈방 확인
				for(int j=0;j <2; j++) {
					for(int k=0; k <hotel.length;k++) {
						System.out.print(hotel[k][j]+"\t");
					}
					System.out.println("");
				}
			}
			 else if(ans.equals("3")) { // 종료
				System.out.println("호텔 예약 프로그램을 종료합니다. 안녕히가세요");
				System.out.println("호텔 현 상황");
				for(int j=0;j <2; j++) {
					for(int k=0; k <hotel.length;k++) {
						System.out.print(hotel[k][j]+"\t");
					}
					System.out.println("");
				}
			System.out.println("==============================");
			System.out.println("프로그램 종료");
				break;
			} else if(ans.equals("4")) {
				int ho =0;
				System.out.println("퇴실할 방번호를 입력하세요 >>");
				String num = sc.next();
				for(int d=0;d < hotel.length;d++) {
					if(hotel[d][0].equals(num)) {
						ho = d;
					}
				}
				hotel[ho][1] = "빈방";
			}
			 else { //1,2,3을 제외한 다른 값을 입력시
				System.out.println("잘못 입력하셧습니다 다시 입력하세요");
			}
		}
		
	}
}
