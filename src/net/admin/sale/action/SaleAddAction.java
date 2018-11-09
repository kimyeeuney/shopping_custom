package net.admin.sale.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.sale.db.SaleDAO;
import net.custom.db.OrderCustomBean;
import net.gallery.db.GalleryBean;



public class SaleAddAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ActionForward forward=null;
		SaleDAO saledao = new SaleDAO();
		OrderCustomBean dto = new OrderCustomBean();
		
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		int num = Integer.parseInt(request.getParameter("num"));
		boolean ok = saledao.UpdateOKgallery(id, num);
		
		
		// 리스트를 받아옴.
		dto = saledao.getAddList(num);
		
		String GALLERY_CUSTOM_ID = dto.getORDER_CUSTOM_ID();
		int GALLERY_CUSTOM1 = (int)dto.getORDER_CUSTOM1();
		int GALLERY_CUSTOM2 = (int)dto.getORDER_CUSTOM2();
		String GALLERY_CUSTOM3 = dto.getORDER_CUSTOM3();
		int GALLERY_CUSTOM4 = (int)dto.getORDER_CUSTOM4();
		int GALLERY_CUSTOM5 = (int)dto.getORDER_CUSTOM5();
		int GALLERY_CUSTOM6 = (int)dto.getORDER_CUSTOM6();
		int GALLERY_CUSTOM7 = (int)dto.getORDER_CUSTOM7();
		int GALLERY_CUSTOM8 = (int)dto.getORDER_CUSTOM8();
		int GALLERY_CUSTOM9 = (int)dto.getORDER_CUSTOM9();
		int GALLERY_CUSTOM10 = (int)dto.getORDER_CUSTOM10();
		int GALLERY_CUSTOM11 = (int)dto.getORDER_CUSTOM11();
		String GALLERY_CUSTOM12 = dto.getORDER_CUSTOM12();
		String GALLERY_CUSTOM13 = dto.getORDER_CUSTOM13();
		
		
		//갤러리DB에 insert하기.
		GalleryBean gallery = new GalleryBean();
		gallery.setGALLERY_CUSTOM_NUM(num);
		gallery.setGALLERY_CUSTOM_ID(GALLERY_CUSTOM_ID);
		gallery.setGALLERY_CUSTOM1(GALLERY_CUSTOM1);
		gallery.setGALLERY_CUSTOM2(GALLERY_CUSTOM2);
		gallery.setGALLERY_CUSTOM3(GALLERY_CUSTOM3);
		gallery.setGALLERY_CUSTOM4(GALLERY_CUSTOM4);
		gallery.setGALLERY_CUSTOM5(GALLERY_CUSTOM5);
		gallery.setGALLERY_CUSTOM6(GALLERY_CUSTOM6);
		gallery.setGALLERY_CUSTOM7(GALLERY_CUSTOM7);
		gallery.setGALLERY_CUSTOM8(GALLERY_CUSTOM8);
		gallery.setGALLERY_CUSTOM9(GALLERY_CUSTOM9);
		gallery.setGALLERY_CUSTOM10(GALLERY_CUSTOM10);
		gallery.setGALLERY_CUSTOM11(GALLERY_CUSTOM11);
		gallery.setGALLERY_CUSTOM12(GALLERY_CUSTOM12);
		gallery.setGALLERY_CUSTOM13(GALLERY_CUSTOM13);
		boolean result = saledao.insertGallery(gallery);
		
		
		
		if(result == true) {
			System.out.println("갤러리 등록 성공");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("SaleOkListAction.sa"); 
		}else{
			System.out.println("갤러리 등록 실패");
		} 
		
		return forward;
		
	}
}
