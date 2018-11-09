package net.admin.sale.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.sale.db.SaleDAO;
import net.admin.sale.db.SalePointBean;

//판매포인트
public class SalePointListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		int page = 1;
		int limit = 10; 
		ActionForward forward=new ActionForward();
		HttpSession sesseion=request.getSession(true);
		String id=(String)sesseion.getAttribute("id");		
		if(id==null){
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		} 
		
		SaleDAO saledao = new SaleDAO();
		
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// 총 리스트 수를 받아옴.
		int listcount = saledao.getPointListCount(id); 
		// 리스트를 받아옴. 
		List<SalePointBean> Pointlist = saledao.getPoint(page, limit, id);
		
		
		
		float maxPoint = saledao.getMaxPoint(id);  
		// 총 페이지 수  
		int maxpage = (int)((double) listcount / limit + 0.9);  
		
		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21, 31등...)
		int startpage = (((int)((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30등...) 
		int endpage = startpage + 10 - 1;
		
		if(endpage > maxpage) endpage = maxpage;
		 
		System.out.println(listcount);
		request.setAttribute("page", page);// 현재 페이지 수
		request.setAttribute("maxpage", maxpage);// 최대 페이지 수
		request.setAttribute("startpage", startpage);// 현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("endpage", endpage);// 현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listcount", listcount);// 총 글 수 
		request.setAttribute("Pointlist", Pointlist);//포인트 리스트
		request.setAttribute("maxPoint", maxPoint);//현재 포인트
		
		
		
		forward.setPath("./saleCenterMain.jsp?page=/userAdminCenter/salePointList");
		
		forward.setRedirect(false);
		return forward;
	}
}