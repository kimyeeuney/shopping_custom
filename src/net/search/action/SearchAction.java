package net.search.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gallery.db.GalleryBean;
import net.gallery.db.GalleryDAO;
import net.search.db.SearchBean;
import net.search.db.SearchDAO;


public class SearchAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		request.setCharacterEncoding("utf-8");
		ActionForward forward=new ActionForward();
		HttpSession session = request.getSession();
		
		SearchDAO searchdao = new SearchDAO();
		SearchBean searchdto = new SearchBean();
		GalleryDAO gallerydao = new GalleryDAO();
		GalleryBean gallerydto = new GalleryBean();
		
		int page = 1;
		int limit = 10;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		
		
		
		
		String search_height = request.getParameter("search_height");
		String search_nek = request.getParameter("search_nek");
		String search_Upper = request.getParameter("search_Upper");
		String search_arm = request.getParameter("search_arm");
		String search_B = request.getParameter("search_B");
		String search_H = request.getParameter("search_H");
		String search_C = request.getParameter("search_C");
		
		
		System.out.println(search_height);
		List<GalleryBean> searchList = searchdao.detailsearch(search_height, search_nek,search_Upper, page, limit, search_arm, search_B, search_H, search_C);
		System.out.println(searchList); 
		
		int listcount = searchdao.getListCount(search_height, search_nek, search_Upper, search_arm, search_B, search_H, search_C); // 총 리스트 수를 받아옴.
		
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
		request.setAttribute("searchList", searchList);
		
		  
		forward.setPath("./index.jsp?page=/search/search_list");
		forward.setRedirect(false);
		return forward;
		  
		
	}
}
