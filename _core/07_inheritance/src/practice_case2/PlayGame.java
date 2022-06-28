package practice_case2;

import java.util.Scanner;

public class PlayGame {
	private Character character; //캐릭터 추상
	private int menu; //메뉴 번호
	private boolean flag; //종료 조건
	
	public boolean isFlag() { //종료조건 전달 메서드
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public PlayGame(Character ch) { //게임시작 후 캐릭터 셋팅
		this.character = ch;
		
	}
	
	public void printMenu(Scanner sc) {
		// 캐릭터 플레이 메뉴
		System.out.println("1.EAT 2.SLEEP 3.PALY 4.TRAIN 0.EXIT");
		menu = sc.nextInt();
		playCharacter(); // 캐릭터 플레이 메서드
	}

	private void playCharacter() {// 캐릭터 추상 클래스에서 확인바람
		switch (menu) {
		case 1:
			character.eat(); 
			break;
		case 2:
			character.sleep();
			break;
		case 3:
			character.play();
			break;
		case 4:
			character.train();
			break;
		default:
			flag = true;
			break;
		}
		character.printStatus(); //캐릭터 상태 출력 in 캐릭터 추상 클래스
		
	}

	public boolean continu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("게임 종료를 누르셧습니다 >>");
		System.out.println("1. 다른 캐릭터 선택 2. 게임종료");
		int sel = sc.nextInt();
		if(sel ==1) {
			return true;
		} else {
			System.out.println("게임 종료!");
			return false;
		}
	}

	public int[] state() {
		int[] stat = new int[3];
		stat[0] = character.getHp();
		stat[1] = character.getMp();
		stat[2] = character.getLevel();
		return stat;
	}

	
}	
