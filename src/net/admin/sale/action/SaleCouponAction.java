package net.admin.sale.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.sale.db.SaleDAO;


//쿠폰 구매
public class SaleCouponAction implements Action{
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
		
		 
		int num = Integer.parseInt(request.getParameter("coupon"));
		
		SaleDAO gallerydao = new SaleDAO();
		int getNum = gallerydao.InsertCoupon(id, num);
		System.out.println(num);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>"); 
		out.println("alert('쿠폰 구매 완료.');");
		out.println("history.go(-1);");
		out.println("</script>");
		out.close();
		return forward;
	}
}
