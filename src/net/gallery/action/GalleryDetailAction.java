package net.gallery.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gallery.db.GalleryBean;
import net.gallery.db.GalleryDAO;


public class GalleryDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GalleryDAO gallerydao = new GalleryDAO();
		GalleryBean dto = new GalleryBean();
		
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		//유저가 선택한 갤러리번호
		int num = Integer.parseInt(request.getParameter("num"));
		int price = gallerydao.getprice(num);
		int getprice = gallerydao.getprice_2(price);
		System.out.println(getprice);
		
		gallerydao.setReadCountUpdate(num);
		dto = gallerydao.getDetail(num);
		
		if(dto == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		
		
		session.setAttribute("gallerydto", dto);
		session.setAttribute("getprice", getprice);
		
		//내 포인트
		int point = gallerydao.getPoint(id);  
		session.setAttribute("point", point);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./index.jsp?page=/gallery/galleryDetail");
		
		forward.setRedirect(false);
		return forward;
	}
}
