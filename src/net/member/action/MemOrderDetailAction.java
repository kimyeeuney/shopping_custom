package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.custom.db.OrderCustomBean;
import net.member.db.MemberDAO;

public class MemOrderDetailAction  implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO memberdao = new MemberDAO();
		OrderCustomBean dto = new OrderCustomBean();
		
		//유저가 선택한 갤러리번호
		int num = Integer.parseInt(request.getParameter("num"));
		 
		
		dto = memberdao.getDetailOrder(num);
		
		if(dto == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		
		
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./index.jsp?page=/member/member_order_detail");
		forward.setRedirect(false);
		return forward;
	}
}
