package net.admin.ad.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.ad.db.AdDAO;


public class AdDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
	
		AdDAO dao = new AdDAO();
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		
		if(id==null){ //로그인되지 않았을 경우.
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		String num=request.getParameter("num");
		System.out.println(num);
		if(num==null){
			return null;
		}
		
		
		boolean re = dao.ADRemove(Integer.parseInt(num),id);
		if(re==false){ //로그인되지 않았을 경우.
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('취소 실패.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
				
		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./AdMyListAction.ad");
		return forward;
		
		
		
		
	}
}
