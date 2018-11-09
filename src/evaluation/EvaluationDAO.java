package evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DatabaseUtil;

public class EvaluationDAO {

	DatabaseUtil databaseUtil = DatabaseUtil.getInstance();
	
	public int write(EvaluationDTO evaluation) {
		String SQL = "INSERT INTO EVALUATION VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = databaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, evaluation.getUserID());
			pstmt.setString(2, evaluation.getLectureName());
			pstmt.setString(3, evaluation.getProfessorName());
			pstmt.setInt(4, evaluation.getLectureYear());
			pstmt.setString(5, evaluation.getSemesterDivide());
			pstmt.setString(6, evaluation.getLectureDivide());
			pstmt.setString(7, evaluation.getEvaluationTitle());
			pstmt.setString(8, evaluation.getEvaluationContent());
			pstmt.setString(9, evaluation.getTotalEvaluation());
			pstmt.setString(10, evaluation.getGrade());
			pstmt.setString(11, evaluation.getLectureLevel());
			pstmt.setString(12, evaluation.getKindness());
			
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
		return -1; // 게시글 등록 실패
		
	}
	
}
