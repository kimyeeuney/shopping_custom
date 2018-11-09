package net.admin.sale.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.sale.db.SaleCouponBean;
import net.admin.sale.db.SaleDAO;

public class SaleCouponListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		SaleDAO saledao = new SaleDAO();
		int page = 1;
		int limit = 10; 
		
		int page2 = 1;
		int limit2 = 10; 
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		if(request.getParameter("page2") != null) {
			page2 = Integer.parseInt(request.getParameter("page2"));
		}
		
		//========1============
		
		// COUPON DB 총 리스트 수를 받아옴.
		int listcount_COUPON = saledao.getCouponListCount(id); 
		// 리스트를 받아옴.
		List<SaleCouponBean> couponlist = saledao.getCouponList(page, limit, id);
		// 총 페이지 수
		int maxpage = (int)((double) listcount_COUPON / limit + 0.9);
		
		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21, 31등...)
		int startpage = (((int)((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30등...)
		int endpage = startpage + 10 - 1;
		
		if(endpage > maxpage) endpage = maxpage;
		
		
		//========2============
		
		// COUPON_USER DB 총 리스트 수를 받아옴.
		int listcount_COUPON_USER = saledao.getCouponListCount2(id); 
		// 리스트를 받아옴.
		List<SaleCouponBean> couponlist2 = saledao.getCouponList2(page2, limit2, id);
		// 총 페이지 수
		int maxpage2 = (int)((double) listcount_COUPON_USER / limit2 + 0.9);
		
		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21, 31등...)
		int startpage2 = (((int)((double) page2 / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30등...)
		int endpage2 = startpage2 + 10 - 1;
		
		if(endpage2 > maxpage2) endpage2 = maxpage2;  

		
		
		
		System.out.println(listcount_COUPON);
		request.setAttribute("page", page);// 현재 페이지 수
		request.setAttribute("maxpage", maxpage);// 최대 페이지 수
		request.setAttribute("startpage", startpage);// 현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("endpage", endpage);// 현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listcount_COUPON", listcount_COUPON);// 총 글 수 
		request.setAttribute("couponlist", couponlist);//coupon구매
		
		System.out.println(listcount_COUPON_USER);
		request.setAttribute("page2", page2);// 현재 페이지 수
		request.setAttribute("maxpage2", maxpage2);// 최대 페이지 수
		request.setAttribute("startpage2", startpage2);// 현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("endpage2", endpage2);// 현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listcount_COUPON_USER", listcount_COUPON_USER);// 총 글 수 
		request.setAttribute("couponlist2", couponlist2);//coupon-admin
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./saleCenterMain.jsp?page=/userAdminCenter/saleCouponList");
		forward.setRedirect(false);
		return forward;
		
		
	}
}
