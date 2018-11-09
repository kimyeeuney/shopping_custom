package net.choice.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.choice.db.ChoiceBean;
import net.choice.db.ChoiceDAO;

// - 찜하기 기능
// 1. 장바구니겸 - 마이페이지에서 내가 찜한 디자인 보기에서 불러올거임
// 2. 인기있는 상품 불러올때, 찜 횟수로 불러온다.

public class ChoiceAddAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{

		request.setCharacterEncoding("utf-8");
		ActionForward forward=null;
		
		// 시퀀스역할, 가져온 갤러리 번호, 찜한 사람 아이디, 찜 카운트 올리기
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		  
		ChoiceDAO dao = new ChoiceDAO();
		ChoiceBean dto = new ChoiceBean();
		
		//갤러리 번호
		int num = Integer.parseInt(request.getParameter("num"));
		
		  
		
		System.out.println(num);
		dto.setCHOICE_NUM(0);
		dto.setCHOICE_GALLERY_NUM(num);
		dto.setCHOICE_ID(id);
		dto.setCHOICE_READCOUNT(0);//대신 갤러리 레벨 컬럼을 쓰겠음
		dto.setCHOICE_DATE(new Timestamp(System.currentTimeMillis()));
		dao.addChoice(dto, num);
		
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>"); 
		out.println("history.go(-1);");
		out.println("alert('디자인을 찜하셨습니다.');");
		out.println("</script>");
		out.close();
		return forward;
	}
}
