package hotel;

import java.util.Date;

public class Room {
	private String roomNum;
	private User user;
	private boolean empty;
	private String checkInTime;
	private String checkOutTime;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Room(String roomNum) {
		this.roomNum = roomNum;
		this.user = new User();
		this.empty = false;
		this.checkInTime = "";
		this.checkOutTime = "";
	}
	
	
	public Room() {
		this.roomNum = null;
		this.user = new User();
		this.empty = false;
		this.checkInTime = "";
		this.checkOutTime = "";
	}
	
	
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}


	public void out_room(String room_num) {
		if(getRoomNum().equals(room_num) && isEmpty() ==true) {
			System.out.println("퇴실 했습니다");
			setCheckInTime("");
			setCheckOutTime("");
			setEmpty(false);
			getUser().del_user();
		} else if (getRoomNum().equals(room_num) && isEmpty() ==false) {
			System.out.println("빈 방 입니다");
		} else {
			System.out.println("방 번호가 틀립니다.");
		}
		
	}


	public void user_info(String name, int age, char gen) {
		System.out.println("1");
		getUser().getAge();
		System.out.println("2");
		getUser().setName(name);
		getUser().setAge(age);
		getUser().setGen(gen);
		
	}


	public void info_room() {
		System.out.println("방 번호 : " + roomNum);
		System.out.println("빈 방 : " + isEmpty());
		System.out.println("체크인 : " + getCheckInTime());
		System.out.println("체크아웃 : " + getCheckOutTime());
		
	}


	public void show_use() {
		System.out.println("이름 : " + getUser().getName());
		System.out.println("나이 : " + getUser().getAge());
		System.out.println("성별 : " + getUser().getGen());
		
	}
}
