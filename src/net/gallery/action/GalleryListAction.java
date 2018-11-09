package net.gallery.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gallery.db.GalleryBean;
import net.gallery.db.GalleryDAO;


//갤러리 리스트
public class GalleryListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		GalleryDAO gallerydao = new GalleryDAO();
		int page = 1;
		int limit = 10; 
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// 총 리스트 수를 받아옴.
		int listcount = gallerydao.getListCount(); 
		// 리스트를 받아옴.
		List<GalleryBean> gallerylist = gallerydao.getGalleryList(page, limit);
		
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
		request.setAttribute("gallerylist", gallerylist);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./index.jsp?page=/gallery/galleryForm");
		forward.setRedirect(false);
		return forward;
		
		
	}
}
