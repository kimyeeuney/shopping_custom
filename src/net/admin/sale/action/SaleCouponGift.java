package net.admin.sale.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.sale.db.SaleDAO;

public class SaleCouponGift implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ActionForward forward=null;
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		 
		String userId = request.getParameter("userId");
		int num = Integer.parseInt(request.getParameter("couponCount"));
		String couponName ="User10%할인쿠폰";
		SaleDAO gallerydao = new SaleDAO();
		//쿠폰보내기-차감
		int getNum = gallerydao.InsertUserCoupon(id, userId, num, couponName);
		System.out.println(num); 
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>"); 
		out.println("alert('쿠폰 선물 완료.');");
		out.println("history.go(-1);");
		out.println("</script>");
		out.close();
		return forward;
	}
}

