package net.custom.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.custom.db.OrderCustomBean;
import net.custom.db.OrderCustomDAO;


public class CustomOrderAction_3 implements Action {

	@Override 
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	 request.setCharacterEncoding("utf-8");
	 ActionForward forward = new ActionForward();
	 boolean result = false;
	
	 int num=Integer.parseInt(request.getParameter("ORDER_CUSTOM_NUM"));
	
	 OrderCustomDAO ordercusdao=new OrderCustomDAO();
	 OrderCustomBean dto = new OrderCustomBean();
	 
	 //로그인체크
	 HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
    
		
		
		//포인트
		//1. 상품가격
		int point_ch=0;
		float point_pu=0;
		int insertprice =0;//저장시킬 총 가격
		 int price = Integer.parseInt(request.getParameter("ORDER_CUSTOM_RECEIVE_PHONE"));
		//2. 넘어온 포인트가 있으면 차감해준다.
		 point_ch = Integer.parseInt(request.getParameter("POINT"));
		 insertprice = price-point_ch;//총가격
		 
		 System.out.println(insertprice);
		 point_pu = (float) ((insertprice)*0.1);
		 ordercusdao.insertPoint(id, price, point_pu, point_ch, num);
		//num:구매상품번호
		
		 //포인트 차감시 총가격
		 
		   
		  
	
		dto.setORDER_CUSTOM_NUM(num);
		dto.setORDER_CUSTOM_RECEIVE_NAME(request.getParameter("ORDER_CUSTOM_RECEIVE_NAME"));
		dto.setORDER_CUSTOM_ZIPCODE1(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM_ZIPCODE1")));
		dto.setORDER_CUSTOM_ZIPCODE2(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM_ZIPCODE2")));
		dto.setORDER_CUSTOM_RECEIVE_ADDR1(request.getParameter("ORDER_CUSTOM_RECEIVE_ADDR1"));
		dto.setORDER_CUSTOM_RECEIVE_ADDR2(request.getParameter("ORDER_CUSTOM_RECEIVE_ADDR2"));
		dto.setORDER_CUSTOM_RECEIVE_PHONE(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM_RECEIVE_PHONE")));
		dto.setORDER_CUSTOM_RECEIVE_MOBILE(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM_RECEIVE_MOBILE")));
		dto.setORDER_CUSTOM_MEMO(request.getParameter("ORDER_CUSTOM_MEMO"));
		dto.setORDER_CUSTOM_TRADE_TYPE(request.getParameter("ORDER_CUSTOM_TRADE_TYPE"));
		dto.setORDER_CUSTOM_GALLERY(0);
		
		ordercusdao.updateOrder(dto);
		session.setAttribute("ordercusdao", ordercusdao);
		
		String nnum = request.getParameter("ORDER_CUSTOM_TRADE_TYPE");
		session.setAttribute("nnum", nnum);
		session.setAttribute("insertprice", insertprice);
		//결제상태
		int getordertype = ordercusdao.getOrderType(num);
		
		
		
		
		
		
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();  
		out.println("<script>");
		
		out.println("location.href='./index.jsp?page=/custom/custom_order_3'");
		/*out.println("location.href='./Custom_order_3.co';");*/
		out.println("</script>");			
		out.close();	
		return forward;
	}
}
