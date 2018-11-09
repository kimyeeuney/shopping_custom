package net.custom.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class OrderCustomFrontController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
		
		 if(command.equals("/Custom_order_2.co")){
			 forward=new ActionForward();
			 forward.setPath("./custom/custom_order_2.jsp");
		 }else if(command.equals("/Custom_order_3.co")){
			 forward=new ActionForward();
			 forward.setPath("location.href='index.jsp?page='./Custom_order_3.co'");
		 }else if(command.equals("/ordertype.co")){
			 forward=new ActionForward();//X
			 forward.setPath("./custom/ordertype.jsp");
		 }else if(command.equals("/")){  
			 /*action  = new OrderCustomAction();*/
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }  
		 }else if(command.equals("/CustomOrderAction_1.co")){
			 action  = new CustomOrderAction_1();
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {  
				 e.printStackTrace();
			 }  
		 }else if(command.equals("/CustomOrderAction_2.co")){
			 action  = new CustomOrderAction_2();
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {  
				 e.printStackTrace();
			 }  
		 }else if(command.equals("/CustomOrderAction_3.co")){
			 action  = new CustomOrderAction_3();
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {  
				 e.printStackTrace();
			 }  
		 }else if(command.equals("/CustomOrderAction_4.co")){
			 action  = new CustomOrderAction_4();
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {  
				 e.printStackTrace();
			 }  
		 }else if(command.equals("/ordertypeAction.co")){
			 action  = new CustomOrderTradeAction();
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