package evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	public ArrayList<EvaluationDTO> getList(String lectureDivide, String searchType, String search, int pageNumber) {
		
		if (lectureDivide.equals("전체")) {
			lectureDivide = "";
		}
		
		ArrayList<EvaluationDTO> evaluationList = null;
		
		String SQL = "";
		if (searchType.equals("최신순")) {
			SQL = "SELECT * FROM EVALUATION WHERE lectureDivide LIKE ? AND CONCAT(lectureName, professorName, evaluationTitle, evaluationContent) LIKE "
					+ "? ORDER BY evaluationID DESC LIMIT " + pageNumber * 5 + ", " + pageNumber * 5 + 6;
		} else if (searchType.equals("추천순")) {
			SQL = "SELECT * FROM EVALUATION WHERE lectureDivide LIKE ? AND CONCAT(lectureName, professorName, evaluationTitle, evaluationContent) LIKE "
					+ "? ORDER BY likeCount DESC LIMIT " + pageNumber * 5 + ", " + pageNumber * 5 + 6;
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = databaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%" + lectureDivide + "%");
			pstmt.setString(2, "%" + search + "%");
			rs = pstmt.executeQuery();
			evaluationList = new ArrayList<EvaluationDTO>();
			while(rs.next()) {
				EvaluationDTO evaluation = new EvaluationDTO(
						rs.getInt("evaluationID"),
						rs.getString("userID"),
						rs.getString("lectureName"),
						rs.getString("professorName"),
						rs.getInt("lectureYear"),
						rs.getString("semesterDivide"),
						rs.getString("lectureDivide"),
						rs.getString("evaluationTitle"),
						rs.getString("evaluationContent"),
						rs.getString("totalEvaluation"),
						rs.getString("grade"),
						rs.getString("lectureLevel"),
						rs.getString("kindness"),
						rs.getInt("likeCount")
					);
				evaluationList.add(evaluation);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return evaluationList; // 결과 리턴
	}
}
