package net.admin.ad.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.ad.db.AdDAO;
import net.admin.ad.db.AdMyBean;

public class AdMainListAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response)  
			throws Exception{
		
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter(); 
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		AdDAO addao = new AdDAO();
		
		AdDAO dao = new AdDAO();
		AdMyBean dto = new AdMyBean();
		
		int listcount = dao.getADListCount();
		List<AdMyBean> adlist = dao.getAdList();
		System.out.println(listcount); 
		
		//세션에 올려주기
		request.setAttribute("adlist", adlist);
		request.setAttribute("listcount", listcount);  
		
		ActionForward forward = new ActionForward();
		forward.setPath("./index.jsp?page=ad_index");
		forward.setRedirect(false);
		return forward;
		
		
	}
}
