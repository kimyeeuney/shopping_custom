package net.custom.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.custom.db.OrderCustomBean;
import net.custom.db.OrderCustomDAO;


public class CustomOrderTradeAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		ActionForward forward=new ActionForward();
		OrderCustomDAO ordercusdao=new OrderCustomDAO();
		OrderCustomBean dto = new OrderCustomBean();
		request.setCharacterEncoding("utf-8");
		
		
		String orderNumber=request.getParameter("orderNumber");
		int check=(int)ordercusdao.confirmNum(orderNumber);
		String check2=null;
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
			 
			int getnum = ordercusdao.getnum(id);
			int orderNum =0;
			if(check == 1) {
			dto.setORDER_CUSTOM_NUM(getnum);
			dto.setORDER_CUSTOM_TRADE_PAYER(1);
			orderNum = ordercusdao.updateOrder2(dto);
			
			}
		System.out.println(orderNumber);
		
		request.setAttribute("orderNumber", orderNumber);
		request.setAttribute("check", check);
		request.setAttribute("orderNum", orderNum);//결제완료
		forward.setPath("./custom/ordertype.jsp");
		
		return forward;
	}
}
