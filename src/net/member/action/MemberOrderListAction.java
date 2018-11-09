package net.member.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.custom.db.OrderCustomBean;
import net.member.db.MemberDAO;


public class MemberOrderListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO memberdao = new MemberDAO();
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		
		//1. 아이디를 보내서 체크해서
		//2. 리스트를 가져온다.
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		 
		
		
		int listcount = memberdao.getListCount(id); // 총 리스트 수를 받아옴.
		List<OrderCustomBean> memberOrderlist = memberdao.getMemberOrderList(page, limit, id); // 리스트를 받아옴.
		
		System.out.println(id);
		System.out.println(listcount);
		System.out.println(memberOrderlist);
		
		// 총 페이지 수
		int maxpage = (int)((double) listcount / 10.0 + 0.9);
		
		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21, 31등...)
		int startpage = (((int)((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30등...)
		int endpage = startpage + 10 - 1;
		
		if(endpage > maxpage) endpage = maxpage;
		
		
		request.setAttribute("page", page);// 현재 페이지 수
		request.setAttribute("maxpage", maxpage);// 최대 페이지 수
		request.setAttribute("startpage", startpage);// 현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("endpage", endpage);// 현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listcount", listcount);// 총 글 수 
		request.setAttribute("memberOrderlist", memberOrderlist);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./index.jsp?page=/member/member_order_list");//경로 바꿔줘야함
		forward.setRedirect(false);
		return forward;
		
	}
}
