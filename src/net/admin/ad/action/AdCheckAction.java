package net.admin.ad.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.ad.db.AdDAO;
import net.gallery.db.GalleryBean;


// AD Center 에서 광고 구좌 신청시 처음으로 오는 액션, 다음으로 Add로 감.
public class AdCheckAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		
		request.setCharacterEncoding("utf-8");
		ActionForward forward=null;
		
		AdDAO dao = new AdDAO();
		GalleryBean dto = new GalleryBean();
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('Login하세요.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		
		int num = Integer.parseInt(request.getParameter("add"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		//최저가격 체크
		if(price<50){
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('광고구좌의 최저가격은 60원부터입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		session.setAttribute("add", num);
		session.setAttribute("price", price);
		dto = dao.getGalleryListNum(num);
		String GALLERY_CUSTOM13 = dto.getGALLERY_CUSTOM13();
		
		//이미 등록한 상품은 등록할 수 없음
		int x = dao.AdCheck(GALLERY_CUSTOM13, id);//갤러리 번호
		
		if(x == 1) {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>"); 
			out.println("alert('이미 광고중인 상품입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}else {
			
			PrintWriter out=response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./AdMyAddAction.ad"); 			
			
		}
		
		return forward;
	}  
}
