package evaluation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EvaluationRegister
 */
@WebServlet("/evaluationRegister")
public class EvaluationRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvaluationRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userID = null;
		String lectureName = null;
		String professorName = null;
		int lectureYear = 0;
		String semesterDivide = null;
		String lectureDivide = null;
		String evaluationTitle = null;
		String evaluationContent = null;
		String totalEvaluation = null;
		String grade = null;
		String lectureLevel = null;
		String kindness = null;
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userID") != null) 
			userID = (String)session.getAttribute("userID");
		
		if (userID == null) 
			response.sendRedirect("user_login.jsp");
		
		if (request.getParameter("lectureName") != null) {
			lectureName = request.getParameter("lectureName");
		}
		if (request.getParameter("professorName") != null) {
			professorName = request.getParameter("professorName");
		}
		if (request.getParameter("lectureYear") != null) {
			try {
				lectureYear = Integer.parseInt(request.getParameter("lectureYear"));
			} catch (Exception e) {
				System.out.println("강의 연도 데이터 오류");
				e.printStackTrace();
			}
		}
		if (request.getParameter("semesterDivide") != null) {
			semesterDivide = request.getParameter("semesterDivide");
		}
		if (request.getParameter("lectureDivide") != null) {
			lectureDivide = request.getParameter("lectureDivide");
		}
		if (request.getParameter("evaluationTitle") != null) {
			evaluationTitle = request.getParameter("evaluationTitle");
		}
		if (request.getParameter("evaluationContent") != null) {
			evaluationContent = request.getParameter("evaluationContent");
		}
		if (request.getParameter("totalEvaluation") != null) {
			totalEvaluation = request.getParameter("totalEvaluation");
		}
		if (request.getParameter("grade") != null) {
			grade = request.getParameter("grade");
		}
		if (request.getParameter("lectureLevel") != null) {
			lectureLevel = request.getParameter("lectureLevel");
		}
		if (request.getParameter("kindness") != null) {
			kindness = request.getParameter("kindness");
		}
		
		
		if (lectureName == null || professorName == null || lectureYear == 0 || semesterDivide == null || lectureDivide == null || evaluationTitle == null ||
				evaluationContent == null || totalEvaluation == null || grade == null || lectureLevel == null || kindness == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
			return;
		}
		
		EvaluationDAO evaluationDAO = new EvaluationDAO();
		EvaluationDTO evaluationDTO = new EvaluationDTO(0, userID, lectureName, professorName, lectureYear, semesterDivide, lectureDivide, evaluationTitle,
				evaluationContent, totalEvaluation, grade, lectureLevel, kindness, 0);
		int result = evaluationDAO.write(evaluationDTO);
		
		if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('강의 평가 등록에 실패했습니다.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
			return;
		} else {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('강의 평가가 등록되었습니다.');");
			script.println("location.href='index.jsp';");
			script.println("</script>");
			script.close();
			return;
		}
	}

}
