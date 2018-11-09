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
 * Servlet implementation class UserRegisterAction
 */
@WebServlet("/userRegisterAction")
public class UserRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
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
		String userPassword = null;
		String userEmail = null;
		
		if (!request.getParameter("userID").equals("")) {
			userID = request.getParameter("userID");
		}
		if (!request.getParameter("userPassword").equals("")) {
			userPassword = request.getParameter("userPassword");
		}
		if (!request.getParameter("userEmail").equals("")) {
			userEmail = request.getParameter("userEmail");
		}
		if (userID == null || userPassword == null || userEmail == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.');");
			script.println("history.back()");
			script.println("</script>");
			script.close();
			return;
		}
		
		UserDAO userDAO = new UserDAO();
		int result = userDAO.join(new UserDTO(userID, userPassword, userEmail, SHA256.getSHA256(userEmail), false));
		if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는 아이디입니다.');");
			script.println("history.back()");
			script.println("</script>");
			script.close();
			return;
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("userID", userID);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'emailSendAction'");
			script.println("</script>");
			script.close();
			return;
		}
	}

}
