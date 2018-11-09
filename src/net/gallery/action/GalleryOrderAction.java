package net.gallery.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gallery.db.GalleryDAO;
import net.gallery.db.GalleryOrderBean;

public class GalleryOrderAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ActionForward forward=null;
		
		GalleryDAO gallery = new GalleryDAO();
		GalleryOrderBean dto = new GalleryOrderBean();
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		
		int getprice = Integer.parseInt(request.getParameter("getprice"));
		
		//주문하기
		
		dto.setGALLERY_ORDER_NUM(0);
		dto.setGALLERY_DESIGNER_ID(request.getParameter("GALLERY_CUSTOM_ID"));
		dto.setGALLERY_CUSTOM_NUM(Integer.parseInt(request.getParameter("GALLERY_CUSTOM_NUM")));
		dto.setGALLERY_NUM(Integer.parseInt(request.getParameter("GALLERY_NUM")));
		dto.setGALLERY_ORDER_CUSTOM1(Integer.parseInt(request.getParameter("GALLERY_CUSTOM1")));
		dto.setGALLERY_ORDER_CUSTOM2(Integer.parseInt(request.getParameter("GALLERY_CUSTOM2")));
		dto.setGALLERY_ORDER_CUSTOM3(request.getParameter("GALLERY_CUSTOM3"));
		dto.setGALLERY_ORDER_CUSTOM4(Integer.parseInt(request.getParameter("GALLERY_CUSTOM4")));
		dto.setGALLERY_ORDER_CUSTOM5(Integer.parseInt(request.getParameter("GALLERY_CUSTOM5")));
		dto.setGALLERY_ORDER_CUSTOM6(Integer.parseInt(request.getParameter("GALLERY_CUSTOM6")));
		dto.setGALLERY_ORDER_CUSTOM7(Integer.parseInt(request.getParameter("GALLERY_CUSTOM7")));
		dto.setGALLERY_ORDER_CUSTOM8(Integer.parseInt(request.getParameter("GALLERY_CUSTOM8")));
		dto.setGALLERY_ORDER_CUSTOM9(Integer.parseInt(request.getParameter("GALLERY_CUSTOM9")));
		dto.setGALLERY_ORDER_CUSTOM10(Integer.parseInt(request.getParameter("GALLERY_CUSTOM10")));
		dto.setGALLERY_ORDER_CUSTOM11(Integer.parseInt(request.getParameter("GALLERY_CUSTOM11")));
		dto.setGALLERY_ORDER_CUSTOM12(request.getParameter("GALLERY_CUSTOM12"));
		dto.setGALLERY_ORDER_CUSTOM13(request.getParameter("GALLERY_CUSTOM13"));
		dto.setGALLERY_ORDER_ID(id);
		dto.setGALLERY_ORDER_NAME(request.getParameter("ORDER_CUSTOM_RECEIVE_NAME"));
		dto.setGALLERY_ORDER_ZIPCODE1(Integer.parseInt(request.getParameter("ORDER_CUSTOM_ZIPCODE1")));
		dto.setGALLERY_ORDER_ZIPCODE2(Integer.parseInt(request.getParameter("ORDER_CUSTOM_ZIPCODE2")));
		dto.setGALLERY_ORDER_ADDR1(request.getParameter("ORDER_CUSTOM_RECEIVE_ADDR1"));
		dto.setGALLERY_ORDER_ADDR2(request.getParameter("ORDER_CUSTOM_RECEIVE_ADDR2"));
		dto.setGALLERY_ORDER_PHONE(getprice);
		dto.setGALLERY_ORDER_MOBILE(Integer.parseInt(request.getParameter("ORDER_CUSTOM_RECEIVE_MOBILE")));
		dto.setGALLERY_ORDER_MEMO(request.getParameter("ORDER_CUSTOM_MEMO"));
		dto.setGALLERY_ORDER_TRADE_TYPE(request.getParameter("ORDER_CUSTOM_TRADE_TYPE"));
		dto.setGALLERY_ORDER_TRADE_DATE(new Date(System.currentTimeMillis()));
		dto.setGALLERY_ORDER_TRADE_PAYER(0);
		gallery.insertUserGallery(dto);
		
		
		String nnum = request.getParameter("ORDER_CUSTOM_TRADE_TYPE");
		session.setAttribute("nnum", nnum);
		int customnum = (int)session.getAttribute("customnum");
		session.setAttribute("customnum", customnum);//포인트에 저장시킬 상품번호
		
		//포인트 겟
		int point = Integer.parseInt(request.getParameter("POINT"));
		session.setAttribute("point", point);
		System.out.println(point);
		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.href='./index.jsp?page=/gallery/galleryOrder2'");
		session.setAttribute("getprice", getprice);
		out.println("</script>");			
		out.close();	
		return forward;
		
	}
}
