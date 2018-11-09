package net.admin.ad.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.ad.db.AdDAO;
import net.admin.ad.db.AdMyBean;
import net.gallery.db.GalleryBean;

//Main에 내 광고가능 리스트와, 광고구좌 출력하는 액션
public class AdMyListAction implements Action{
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
		
		//========1=========
		// 총 광고할 리스트 수를 받아옴.
		int Glistcount = addao.getGalleryListCount(id); 
		// 총 광고할 리스트를 받아옴.
		List<GalleryBean> gallerylist = addao.getGalleryList(id);
		
		System.out.println(Glistcount);
		request.setAttribute("Glistcount", Glistcount);// 총 글 수 
		request.setAttribute("gallerylist", gallerylist);
		
		
		
		//========2=========
		//광고 게재 대기중인 리스트(내가 신청해놓은 광고 리스트)
		List<AdMyBean> adIdlist = addao.getADIDList(id);
		int ADcount = addao.getADIDListCount(id);
		request.setAttribute("adIdlist", adIdlist);
		request.setAttribute("ADcount", ADcount);
		System.out.println(adIdlist);
		
		
		
		//========3=========
		AdDAO dao = new AdDAO();
		AdMyBean dto = new AdMyBean();
		
		int listcount = dao.getADListCount();
		List<AdMyBean> adlist = dao.getAdList();
		System.out.println(listcount); 
		
		//세션에 올려주기
		request.setAttribute("adlist", adlist);
		request.setAttribute("listcount", listcount);  
		request.setAttribute("id", id);  
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./adCenterMain.jsp?page=/adAdminCenter/saleAdForm");
		forward.setRedirect(false);
		return forward;
		
		
		
	}	
}
