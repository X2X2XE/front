package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO implements DAO{
	private Connection conn;
	private PreparedStatement pst;
	private String query ="";
	
	public HotelDAO() {
		DatabaseConnector dbc = DatabaseConnector.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public int insert(int floor, int room) {
		int fir = 1;
		int sces_2=100;
		String room_num;
		boolean scess=true;
		query = "insert into room(rno,guest_tel) values(?,'000')";
		for(int j=1; j<=floor; j++) {
			
			for(int i=1;i <=room;i++) {
				if(i<10) {
					room_num = fir + "0" + i;
				} else {
					room_num = Integer.toString(fir) + i;
				}
				try {
					pst=conn.prepareStatement(query);
					pst.setString(1, room_num);
					scess = pst.executeUpdate() > 0? true : false;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(scess == false) {
					sces_2 =-1;
					break;
				}
			}
			fir+=j;
		}
		return sces_2;
	}

	@Override
	public List<HotelVO> select() {
		query = "select * from room";
		List<HotelVO> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new HotelVO(rs.getString("rno"), rs.getString("guest_name"), rs.getString("guest_tel"), rs.getInt("guest_age"), rs.getInt("guest_gen"), rs.getString("is_empty"), rs.getString("check_in_time"), rs.getString("check_out_time")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(HotelVO hvo) {
		query = "update room set guest_name = ?, guest_tel = ?, guest_age = ?, guest_gen = ?, check_in_time = now() ,is_empty = 1 where rno = ? and is_empty = 0";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, hvo.getGuest_name());
			pst.setString(2, hvo.getGuest_tel());
			pst.setInt(3, hvo.getGuest_age());
			pst.setInt(4, hvo.getGuest_gen());
			pst.setString(5, hvo.getRno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int room_out(String rno) {
		query = "update room set is_empty =0, guest_name = null, guest_tel = 000, guest_age = 0, guest_gen = 0, is_empty =0, check_in_time = null, check_out_time = null where rno = ? and is_empty = 1";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, rno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public HotelVO user_info(String rno) {
		query = "select * from room where rno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, rno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new HotelVO(rs.getString("rno"),rs.getString("guest_name"),rs.getString("guest_tel"), rs.getInt("guest_age"), rs.getInt("guest_gen"), rs.getString("is_empty"),rs.getString("check_in_time"),rs.getString("check_out_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
