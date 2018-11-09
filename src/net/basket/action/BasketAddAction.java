package net.basket.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketBean;
import net.basket.db.BasketDAO;

public class BasketAddAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		BasketDAO basketdao=new BasketDAO();
		BasketBean bsdto = new BasketBean();
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		int num = Integer.parseInt(request.getParameter("ORDER_CUSTOM1"));
		System.out.println(num);
		
		
		bsdto.setBASKET_NUM(0);
		bsdto.setBASKET_CUSTOM1(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM1")));
		bsdto.setBASKET_CUSTOM2(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM2")));
		bsdto.setBASKET_CUSTOM3(request.getParameter("ORDER_CUSTOM3"));
		
		bsdto.setBASKET_CUSTOM4(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM4")));
		bsdto.setBASKET_CUSTOM5(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM5")));
		bsdto.setBASKET_CUSTOM6(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM6")));
		bsdto.setBASKET_CUSTOM7(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM7")));
		bsdto.setBASKET_CUSTOM8(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM8")));
		bsdto.setBASKET_CUSTOM9(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM9")));
		bsdto.setBASKET_CUSTOM10(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM10")));
		bsdto.setBASKET_CUSTOM11(
				Integer.parseInt(request.getParameter("ORDER_CUSTOM11")));
		
		bsdto.setBASKET_CUSTOM12(request.getParameter("ORDER_CUSTOM12"));
		bsdto.setBASKET_CUSTOM13(request.getParameter("ORDER_CUSTOM13"));
		bsdto.setBASKET_CUSTOM_ID(id);
		basketdao.basketAdd(bsdto, id);
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.href='BasketListAction.ba';");
		out.println("</script>");			
		out.close();	
		ActionForward forward=null;
		return forward;
	}
}
