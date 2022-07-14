package hotel;

import java.util.List;

public class HotelService implements Service{
	private DAO dao;
	
	public HotelService() {
		dao = new HotelDAO();
	}
	
	@Override
	public int creat_room(int floor, int room) {
		
		return dao.insert(floor, room);
	}

	@Override
	public List<HotelVO> list() {
		
		return dao.select();
	}

	@Override
	public int in_user(HotelVO hvo) {
		
		return dao.update(hvo);
	}

	@Override
	public int out_us(String rno) {
		
		return dao.room_out(rno);
	}

	@Override
	public HotelVO user_list(String rno) {
		
		return dao.user_info(rno);
	}


}
