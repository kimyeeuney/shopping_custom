package net.admin.sale.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SaleFrontController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
	
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null; 
		 Action action=null;		 
		 
		 if(command.equals("/useradmincenter.sa")){
			 forward=new ActionForward();
			 forward.setPath("./useradmincenter.jsp");
		 }else if(command.equals("./centerG.sa")){
			 forward=new ActionForward();
			 forward.setPath("./userAdminCenter/gaide.jsp");  
		 }else if(command.equals("/SaleListAction.sa")){
			 action  = new SaleListAction(); 
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }else if(command.equals("/SaleAddAction.sa")){
			 action  = new SaleAddAction();  
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }else if(command.equals("/SaleOkListAction.sa")){
			 action  = new SaleOkListAction(); 
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }else if(command.equals("/SalePointListAction.sa")){
			 action  = new SalePointListAction(); 
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {
				 e.printStackTrace();  
			 }
		 }else if(command.equals("/SaleCouponAction.sa")){
			 action  = new SaleCouponAction(); 
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }else if(command.equals("/SalePointListAction_2.sa")){
			 action  = new SalePointListAction_2(); 
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }else if(command.equals("/SaleCouponGift.sa")){
			 action  = new SaleCouponGift(); 
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }else if(command.equals("/SaleCouponListAction.sa")){
			 action  = new SaleCouponListAction(); 
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
		 
		 
		 
		 
		 
		 
		 
		 if(forward != null){
			 if(forward.isRedirect()){
			 response.sendRedirect(forward.getPath());
		 }else{
			 RequestDispatcher dispatcher=
				 request.getRequestDispatcher(forward.getPath());
			 dispatcher.forward(request, response);
		  }	 
	   }
	}
}
