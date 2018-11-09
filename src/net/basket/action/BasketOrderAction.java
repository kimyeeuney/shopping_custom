package net.basket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketBean;
import net.basket.db.BasketDAO;


public class BasketOrderAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		ActionForward forward=new ActionForward();
		HttpSession sesseion=request.getSession(true); 
		String id=(String)sesseion.getAttribute("id");		
		if(id==null){
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}  
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		BasketDAO dao = new BasketDAO();
		BasketBean dto = dao.getBasketCustom(id, num);
		System.out.println(num);
		
		
		request.setAttribute("dto", dto);
		forward.setPath("./index.jsp?page=/basket/basket_custom"); 			
		return forward;
		
	}
}
