package net.custom.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.custom.db.OrderCustomBean;
import net.custom.db.OrderCustomDAO;

public class CustomOrderAction_2 implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ActionForward forward=new ActionForward();
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");		
		if(id==null) {
			forward.setRedirect(true);
			forward.setPath("../MemberLogin.me");
			return forward;  
		}
		
		//
		OrderCustomDAO ordercusdao=new OrderCustomDAO();
		OrderCustomBean orderdata = new OrderCustomBean();
		
		int getnum = ordercusdao.getnum(id);
		
		System.out.println(getnum);
		/*session.setAttribute("getnum", get);*/
		
		orderdata = ordercusdao.getOrderCustom(getnum);
		
		if(orderdata==null){
	   		System.out.println("Null로 넘어옴"+orderdata);
	   		return null;
	   		
	   	}
	   	System.out.println("null아님"+orderdata);
		
	   	//
		session.setAttribute("orderdata", orderdata);
		
		
		
		  
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.href='./index.jsp?page=/custom/custom_order_2'");
        out.println("</script>");			
		out.close();	
		return forward;
	}
}



