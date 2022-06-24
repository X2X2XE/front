package hotel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Hotel {
	private Room[][] rooms;	
	
	
	public void goFrontDest(Room room) {
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		boolean flag = true;
		
		
		
		while (flag) {
			
			System.out.println("\n====================== 호텔 관리 메뉴 =====================");
			System.out.println("1:객실현황 2:입실 3:퇴실 4:객실상세조회 5:투숙객조회 6.객실생성 Etc:종료");
			System.out.println("-------------------------------------------------------------");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> 메뉴 선택 >>>>>>>>>>>>>>>>>>>>>>>>>>");
			menu = sc.nextInt();
			
			flag = choiceMenu(menu, room);
		}
		System.out.println("프로그램을 종료합니다");
		
	}

	private boolean choiceMenu(int menu, Room room) {
		Scanner sc = new Scanner(System.in);
		
		
		switch (menu) {
		case 1:
			show_hotel(room);
			break;
		case 2:
			input_room(room);
			break;
		case 3:
			out_room(room);
			break;
		case 4:
			info_room(room);
			break;
		case 5:
			room_use(room);
			break;
		case 6:
			create_room(room);
			break;
		default:
			System.out.println("호텔프로그램을 종료합니다");
			break;
		}
		return true;
	}
	
	

	private void room_use(Room room) {
		Scanner sc = new Scanner(System.in);
		System.out.println("확인할 방번호를 입력하세요 >>");
		String room_num = sc.next();
		if(room.getRoomNum().equals(room_num)) {
			room.show_use();
		} else {
			System.out.println("입력한 방번호가 다릅니다");
		}
		
		
	}

	private void info_room(Room room) {
		Scanner sc = new Scanner(System.in);
		System.out.println("확인할 방번호를 입력하세요 >>");
		String room_num = sc.next();
		if(room.getRoomNum().equals(room_num)) {
			room.info_room();
		} else {
			System.out.println("입력이 잘못되었습니다");
		}
		
	}

	private void out_room(Room room) {
		Scanner sc = new Scanner(System.in);
		System.out.println("퇴실할 방 번호를 입력하세요");
		String room_num = sc.next();
		room.out_room(room_num);
		
	}

	private void input_room(Room room) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		System.out.println("입실할 방 번호를 입력하세요 >>");
		String room_num = sc.next();
		if(room.getRoomNum().equals(room_num) && room.isEmpty() ==false) {
			System.out.println("이름을 입력하세요 >>");
			String name = sc.next();
			System.out.println("나이를 입력하세요 >>");
			int age = sc.nextInt();
			System.out.println("성별이 M과 G로 입력하세요 >>");
			char gen = sc.next().charAt(0);
			room.user_info(name, age, gen);
			//입실 완료
			System.out.println("입실 했습니다");
			cal.setTime(date);
			room.setCheckInTime(String.valueOf(sim.format(cal.getTime())));
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			room.setCheckOutTime(String.valueOf(sim.format(cal.getTime())));
			room.setEmpty(true);
		} else if (room.getRoomNum().equals(room_num) && room.isEmpty() !=false) {
			System.out.println("빈 방이 아닙니다");
		} else {
			System.out.println("방 번호가 틀립니다.");
		}
		
	}

	public void create_room(Room room) {
		Scanner sc = new Scanner(System.in);
		System.out.println("생성시키고자 하는 호텔 방번호를 입력하세요>>");
		String roomNum = sc.next();
		room.setRoomNum(roomNum);
			
	}
	public void show_hotel(Room room) {
		System.out.print("방번호 : " + room.getRoomNum());
		System.out.print(" 빈 방 : " + room.isEmpty());
//		System.out.print(" 체크인 : " + room.getCheckInTime());
//		System.out.print(" 체크아웃 : " + room.getCheckOutTime());
		
		
	}

}
