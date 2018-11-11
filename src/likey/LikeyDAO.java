package likey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DatabaseUtil;

public class LikeyDAO {
	
	DatabaseUtil databaseUtil = DatabaseUtil.getInstance();

	public int like(String userID, String evaluationID, String userIP) {
		
		String SQL = "INSERT INTO LIKEY VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = databaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setInt(2, Integer.parseInt(evaluationID));
			pstmt.setString(3, userIP);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1; // 추천 중복 오류
		
	}
	
}
