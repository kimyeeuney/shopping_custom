package net.custom.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.custom.db.OrderCustomBean;
import net.custom.db.OrderCustomDAO;

public class CustomOrderAction_1 implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ActionForward forward=null;
		
		OrderCustomDAO ordercusdao=new OrderCustomDAO();
		OrderCustomBean dto = new OrderCustomBean();
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		 
		
		
		dto.setORDER_CUSTOM_NUM(0);
		dto.setORDER_CUSTOM1(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM1")));
		dto.setORDER_CUSTOM2(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM2")));
		
		dto.setORDER_CUSTOM3(request.getParameter("ORDER_CUSTOM3"));
		
		dto.setORDER_CUSTOM4(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM4")));
		dto.setORDER_CUSTOM5(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM5")));
		dto.setORDER_CUSTOM6(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM6")));
		dto.setORDER_CUSTOM7(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM7")));
		dto.setORDER_CUSTOM8(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM8")));
		dto.setORDER_CUSTOM9(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM9")));
		dto.setORDER_CUSTOM10(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM10")));
		dto.setORDER_CUSTOM11(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM11")));
		
		dto.setORDER_CUSTOM12(request.getParameter("ORDER_CUSTOM12"));
		dto.setORDER_CUSTOM13(request.getParameter("ORDER_CUSTOM13"));
		dto.setORDER_CUSTOM_ID(id);
		dto.setORDER_CUSTOM_RECEIVE_NAME(null);
		
		dto.setORDER_CUSTOM_ZIPCODE1(0);
		dto.setORDER_CUSTOM_ZIPCODE2(0);
		
		dto.setORDER_CUSTOM_RECEIVE_ADDR1(null);
		dto.setORDER_CUSTOM_RECEIVE_ADDR2(null);
		
		dto.setORDER_CUSTOM_RECEIVE_PHONE(0);//point
		dto.setORDER_CUSTOM_RECEIVE_MOBILE(0);
		
		dto.setORDER_CUSTOM_MEMO(null);
		dto.setORDER_CUSTOM_TRADE_TYPE(null);
		
		dto.setORDER_CUSTOM_TRADE_DATE(new Timestamp(System.currentTimeMillis()));
		dto.setORDER_CUSTOM_TRADE_PAYER(0);
		
		dto.setORDER_CUSTOM_GALLERY(0);
		
		ordercusdao.insertOrderCustom(dto);
		int point = ordercusdao.getPoint(id);
		
		session.setAttribute("point", point);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.href='./CustomOrderAction_2.co';");
		out.println("</script>");			
		out.close();	
		return forward;
	}
}
