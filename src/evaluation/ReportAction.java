package evaluation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Gmail;


/**
 * Servlet implementation class ReportAction
 */
@WebServlet("/reportAction")
public class ReportAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userID = null;
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userID") != null) 
			userID = (String)session.getAttribute("userID");
		
		if (userID == null) 
			response.sendRedirect("user_login.jsp");
		
		String reportTitle = null;
		String reportContent = null;
		
		if (request.getParameter("reportTitle") != null) {
			reportTitle = request.getParameter("reportTitle");
		}
		if (request.getParameter("reportContent") != null) {
			reportContent = request.getParameter("reportContent");
		}
		
		if (reportTitle == null || reportContent == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
			return;
		}
		
		String from = "haguni17@gmail.com";
		String to = "haguni17@gmail.com";
		String subject = "강의평가에서 접수된 신고 메일입니다..";
		String content = "신고자: " + userID + 
				"<br>제목: " + reportTitle + 
				"<br>내용: " + reportContent;
		
		Properties p = new Properties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.googlemail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		try {
			Authenticator auth = new Gmail();
			Session ses = Session.getInstance(p, auth);
			ses.setDebug(true);
			MimeMessage msg = new MimeMessage(ses);
			msg.setSubject(subject);
			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html;charset=UTF-8");
			Transport.send(msg);
			
		} catch(Exception e) {
			e.printStackTrace();
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('오류가 발생했습니다.');");
			script.println("location.href= 'user_login.jsp';");
			script.println("</script>");
			script.close();
			return;
		}
		
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('신고접수가 완료되었습니다.');");
		script.println("location.href = 'index.jsp';");
		script.println("</script>");
		script.close();
	}

}
