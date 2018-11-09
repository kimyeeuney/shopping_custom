package net.gallery.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gallery.db.GalleryDAO;
import net.gallery.db.GalleryOrderBean;

public class galleryordertypeAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
	
	ActionForward forward=new ActionForward();
	request.setCharacterEncoding("utf-8");
	
	//로그인체크
	 HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
	GalleryDAO gallerydao = new GalleryDAO();
	GalleryOrderBean dto = new GalleryOrderBean();
	//계좌번호 체크
	String orderNumber=request.getParameter("orderNumber");
	System.out.println(orderNumber);
	int check=(int)gallerydao.confirmNum(orderNumber);
	String check2=null;  
	
	//가격얻어오기
	/*int getprice2 = Integer.parseInt(request.getParameter("getprice2"));*/
	int getprice = (int)session.getAttribute("getprice2");
	System.out.println(getprice);
	
	
	//결제상태1업데이트
	int getnum = gallerydao.getnum(id);
	int orderNum =0;
	if(check == 1) {
	orderNum = gallerydao.updateOrder3(getnum);
	}
	 
	//디자이너에게 결제 포인트쌓기
	//1. 상품가격
	int point_ch=0;
	float point_pu=0;
	int insertprice =0;//저장시킬 총 가격
	//getprice:상품가격
	//2. 넘어온 포인트가 있으면 차감해준다.
	 point_ch = (int)session.getAttribute("point");
	 insertprice = getprice-point_ch;//총가격
	 
	 System.out.println(insertprice);
	 point_pu = (float) ((insertprice)*0.1);
	 
	 int customnum = (int)session.getAttribute("customnum");//상품번호
	 System.out.println(customnum);
	 gallerydao.insertPoint(id, getprice, point_pu, point_ch, customnum);
	
	
	
	
	request.setAttribute("orderNumber", orderNumber);
	request.setAttribute("check", check);
	request.setAttribute("orderNum", orderNum);//결제완료
	forward.setPath("./custom/ordertype.jsp");
	
	return forward;
	
	}
}
