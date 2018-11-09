package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.SHA256;

/**
 * Servlet implementation class EmailCheckAction
 */
@WebServlet(name = "emailCheckAction", urlPatterns = { "/emailCheckAction" })
public class EmailCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailCheckAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String code = null;
		UserDAO userDAO = new UserDAO();
		String userID = null;
		
		HttpSession session = request.getSession();
		
		if(!request.getParameter("code").equals("")) {
			code = request.getParameter("code");
		}
		
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
		if (userID == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 먼저 해주세요.');");
			script.println("location.href = 'user_login.jsp'");
			script.println("</script>");
			script.close();
			return;
		}
		
		String userEmail = userDAO.getUserEmail(userID);
		boolean isEmailCheck = SHA256.getSHA256(userEmail).equals(code) ? true : false;
		
		if (isEmailCheck) {
			userDAO.setUserEmailChecked(userID);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('인증에 성공하셨습니다.');");
			script.println("location.href = 'index.jsp'");
			script.println("</script>");
			script.close();
			return;
		} else {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('유효하지 않은 코드입니다..');");
			script.println("location.href = 'user_login.jsp'");
			script.println("</script>");
			script.close();
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
