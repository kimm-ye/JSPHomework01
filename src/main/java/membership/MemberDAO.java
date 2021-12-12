package membership;

import common.JDBConnect;

public class MemberDAO extends JDBConnect {
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "SELECT * FROM member WHERE id=? AND pass=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			
			if(rs.next()) { 
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public String searchIdDTO(String uname) {
		MemberDTO dto = new MemberDTO();
		String findId = null;
		String query = "SELECT id FROM member WHERE name=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uname);
			rs = psmt.executeQuery();
			
			if(rs.next()) { 
				findId = rs.getString("id");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return findId;
	}
	
	public String searchPwDTO(String uid, String uname) {
		MemberDTO dto = new MemberDTO();
		String findPw = null;
		String query = "SELECT pass FROM member WHERE id=? AND name=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, uname);
			rs = psmt.executeQuery();
			
			if(rs.next()) { 
				findPw = rs.getString("pass");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return findPw;
	}
}
