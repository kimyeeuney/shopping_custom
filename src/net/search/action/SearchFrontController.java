package net.search.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchFrontController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;		 
		 
		 if(command.equals("/")){
			 forward=new ActionForward();
			 forward.setPath("/");
		 }else if(command.equals("/SearchAction.sc")){
			action  = new SearchAction(); 
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