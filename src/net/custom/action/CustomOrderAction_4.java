package net.custom.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.custom.db.OrderCustomDAO;

public class CustomOrderAction_4 implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
	ActionForward forward=null;
	Action action=null;
	HttpSession session = request.getSession();
	String id=(String)session.getAttribute("id");  
	System.out.println(id);  
	if(id==null){
		response.sendRedirect("/shopping_custom/MemberLogin.me");    
	}
	
	response.setContentType("text/html; charset=utf-8");
	PrintWriter out = response.getWriter();
	
	OrderCustomDAO dao = new OrderCustomDAO();
	int num = Integer.parseInt(request.getParameter("num"));
	int getNum = dao.getOrderType(num);
	
	
	
	if(getNum == 1) {
		out.println("<script>");
		out.println("location.href='./index.jsp?page=/custom/custom_order_4'");
	    out.println("</script>");			
		out.close();
	}else {  
		out.println("<script>");
		out.println("alert('결제를 진행해주세요.');");
		out.println("history.go(-1);");
	    out.println("</script>");
	}
	
	

	
	
	return forward;
	}
}
