package net.basket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketBean;
import net.basket.db.BasketDAO;

public class BasketDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BasketDAO basketdao = new BasketDAO();
		BasketBean dto = new BasketBean();
		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		
		dto = basketdao.getDetail(num);
		
		if(dto == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		
		HttpSession session = request.getSession();
		session.setAttribute("basketdto", dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./index.jsp?page=/basket/basket_detail");
		
		forward.setRedirect(false);
		return forward;
	}
}
