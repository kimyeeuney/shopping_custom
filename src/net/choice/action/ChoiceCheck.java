package net.choice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.choice.db.ChoiceBean;
import net.choice.db.ChoiceDAO;

public class ChoiceCheck  implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		
		request.setCharacterEncoding("utf-8");
		ActionForward forward=new ActionForward();
		
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
		int idC = dao.ChoiceIDCheck(num, id);
		
		if(idC==1){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("history.go(-1);");
			out.println("alert('이미 찜한 디자인입니다.');");
			out.println("</script>");
			out.close();
		}else {
			forward.setRedirect(false);
			forward.setPath("/ChoiceAddAction.ca");
			return forward;
		
		}
	
		return null;
	}
}
