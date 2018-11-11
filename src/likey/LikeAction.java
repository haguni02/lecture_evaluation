package likey;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import evaluation.EvaluationDAO;
import util.IPCollector;

/**
 * Servlet implementation class LikeAction
 */
@WebServlet("/likeAction")
public class LikeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userID = null;
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
		
		String evaluationID = null;
		if (request.getParameter("evaluationID") != null) {
			evaluationID = request.getParameter("evaluationID");
		}
		
		String userIP = IPCollector.getClientIP(request);
		
		EvaluationDAO evaluationDAO = new EvaluationDAO();
		LikeyDAO likeyDAO = new LikeyDAO();
		
		int result = likeyDAO.like(userID, evaluationID, userIP);
		
		if (result == 1) {
			result = evaluationDAO.like(evaluationID);
			if (result ==1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('추천이 완료되었습니다.');");
				script.println("location.href='index.jsp';");
				script.println("</script>");
				script.close();
				return;
			} else {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('DB 오류');");
				script.println("history.back();");
				script.println("</script>");
				script.close();
				return;
			}
		} else {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 추천을 하신 평가글입니다.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
