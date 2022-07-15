package supplement;

public class Room {
	private String roomNum;
	private boolean empty;
	private User user;
	private String[] amanities;
	
	public Room() {}
	
	public Room(String roomNum, boolean empty, User userm, String[] amanities) {
		this.roomNum = roomNum;
		this.empty = empty;
		this.user = user;
		this.amanities = amanities;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String[] getAmanities() {
		return amanities;
	}

	public void setAmanities(String[] amanities) {
		this.amanities = amanities;
	}
}
