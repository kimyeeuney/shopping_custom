package net.admin.ad.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.ad.db.AdDAO;
import net.admin.ad.db.AdMyBean;
import net.gallery.db.GalleryBean;

// 구좌 신청 액션 - List Action으로 감
public class AdMyAddAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ActionForward forward=null;
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('Login하세요.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		AdDAO dao = new AdDAO();
		GalleryBean dto = new GalleryBean();
		
		//갤러리 번호
		int num = (int)session.getAttribute("add");
		int price = (int)session.getAttribute("price");
		/*int num = Integer.parseInt(request.getParameter("add"));
		int price = Integer.parseInt(request.getParameter("price"));*/
		System.out.println(num);
		
		//갤러리 상품 가져오기
		dto = dao.getGalleryListNum(num);
		int GALLERY_NUM = (int)dto.getGALLERY_NUM();
		String GALLERY_CUSTOM_ID = dto.getGALLERY_CUSTOM_ID();
		String GALLERY_CUSTOM13 = dto.getGALLERY_CUSTOM13();
		
		//광고 DB에 insert
		AdMyBean AD = new AdMyBean();
		AD.setAD_NUM(0);
		AD.setAD_ID(GALLERY_CUSTOM_ID);
		AD.setAD_NAME(GALLERY_CUSTOM13);
		AD.setAD_PRICE(price);
		boolean result = dao.insertADGallery(AD);
		
		//이미 신청한 광고인지
		response.setContentType("text/html; charset=utf-8");
		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./AdMyListAction.ad"); 			
		return forward;
	
		
		
		
		
		
  }
}

