package s30505_0609;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url = "jdbc:mariadb://127.0.0.1:3306/exam305",
			user = "root",
			pwd = "1234"; 
	
	public MemberDAO() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, pwd);
			
		} catch (ClassNotFoundException e) {
			System.out.println("cant found driver : "+e.toString());
		} catch (SQLException e) {
			System.out.println("cant connect DB : "+e.toString());
		}
	}
	
	
	
	public void insertMember(MemberVO vo) {
		int cnt=0;
		try {
//			stmt = con.createStatement();
//			String sql = "insert into member values(100, '1111', '홍길동', 'gonh@robot.com', '2021-06-16')";
//			cnt = stmt.executeUpdate(sql);
			
			String sql = "insert into member values(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getJoinDate());
			cnt = pstmt.executeUpdate();
			
			System.out.println(cnt);
			
		} catch (SQLException e) {
			System.out.println("insert failed : "+e.toString());
		}
		
		if(cnt>0) System.out.println("데이터 추가 성공");
		else System.out.println("데이터 추가 실패");
		
		dbClose();
		
	}
	
	public void deleteMember(int id) {
		int cnt=0;
		try {			
			String sql = "delete from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			cnt = pstmt.executeUpdate();
			
			System.out.println(cnt);
			
		} catch (SQLException e) {
			System.out.println("delete failed : "+e.toString());
		}	
		
		if(cnt>0) System.out.println("데이터 삭제 성공");
		else System.out.println("데이터 삭제 실패");
		
		
		dbClose();
	}
	
	
	public void selectAll() {
		String sql = "select * from member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String joinDate = rs.getString("joinDate");
				System.out.println(id+"|"+name+"|"+email+"|"+joinDate);
			}
			
			
		} catch (SQLException e) {
			System.out.println("select all failed: "+e.toString());
		}
		dbClose();
	}
	
	public ArrayList<MemberVO> selectAllList() {
		String sql = "select * from member";
		ArrayList<MemberVO> resultList = new ArrayList<MemberVO>();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String joinDate = rs.getString("joinDate");
				MemberVO vo = new MemberVO(id, pwd, name, email, joinDate);
				resultList.add(vo);
			}			
		} catch (SQLException e) {
			System.out.println("select all failed - List: "+e.toString());
		}
		dbClose();
		return resultList;
	}
	
	public void dbClose() {
		
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		
	}
	
}
