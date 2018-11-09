package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.custom.db.OrderCustomDAO;
import net.member.db.MemberDAO;

public class MemberLoginAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		ActionForward forward=new ActionForward();
		
		MemberDAO memberdao=new MemberDAO();		
		OrderCustomDAO customdao = new OrderCustomDAO();
		
		String id=request.getParameter("MEMBER_ID");
		String pass=request.getParameter("MEMBER_PW");
		
		
		int centerCheck = memberdao.centerOpenCheck(id); 
		System.out.println(centerCheck);
		session.setAttribute("centerCheck", centerCheck);
		
		
		int check=memberdao.userCheck(id, pass);
		System.out.println(check);
		if(check == 1){
			session.setAttribute("id", id);
  			if(memberdao.isAdmin(id)){ 
				forward.setRedirect(true);
				forward.setPath("./admin.me");
				return forward;
			}else{
				forward.setRedirect(true);
				forward.setPath("./index.jsp");
				return forward;
			}
		}else if(check == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return null;
	}
}
