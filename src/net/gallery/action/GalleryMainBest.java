package net.gallery.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.ad.db.AdDAO;
import net.admin.ad.db.AdMyBean;
import net.gallery.db.GalleryBean;
import net.gallery.db.GalleryDAO;

public class GalleryMainBest implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		
		GalleryDAO gallerydao = new GalleryDAO();
		
		// 리스트를 받아옴.
		List<GalleryBean> gallerylist = gallerydao.getMainList();
		System.out.println(gallerylist);
		
		request.setAttribute("gallerylist", gallerylist);
		
		
		
		
		//=============
		
		
		AdDAO addao = new AdDAO();
		
		AdDAO dao = new AdDAO();
		AdMyBean dto = new AdMyBean();
		
		int listcount = dao.getADListCount();
		List<AdMyBean> adlist = dao.getAdList();
		System.out.println(listcount); 
		request.setAttribute("adlist", adlist);
		request.setAttribute("listcount", listcount);  
		
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./index.jsp?page=ad_index"); 
		forward.setRedirect(false);
		return forward;
		
		
	}
}
