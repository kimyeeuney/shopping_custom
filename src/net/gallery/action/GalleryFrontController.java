package net.gallery.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GalleryFrontController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
		
		 if(command.equals("/galleryOrder.ua")){
			 forward=new ActionForward();
			 forward.setPath("./index.jsp?page=/gallery/galleryOrder");
			
		 }else if(command.equals("/")){
			 forward=new ActionForward();
			/* forward.setPath("./gallery/galleryOrder3.jsp");*/
			 forward.setPath("/");
		 }else if(command.equals("/GalleryListAction.ua")){
			 action  = new GalleryListAction();
			 try {
				 forward=action.execute(request, response);  
			 } catch (Exception e) {  
				 e.printStackTrace();   
			 }  
		 }else if(command.equals("/GalleryAddAction.ua")){//등록후-액션-갤러리로이동
			 action  = new GalleryAddAction();
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {  
				 e.printStackTrace();
			 }    
		 }else if(command.equals("/GalleryDetailAction.ua")){//등록후-액션-갤러리로이동
			 action  = new GalleryDetailAction(); 
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {  
				 e.printStackTrace();
			 }  
		 }else if(command.equals("/GalleryOrderAction.ua")){//등록후-액션-갤러리로이동
			 action  = new GalleryOrderAction();
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {  
				 e.printStackTrace();
			 }  
		 }else if(command.equals("/GalleryDeleteAction.ua")){//등록후-액션-갤러리로이동
			 action  = new GalleryDeleteAction();
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {  
				 e.printStackTrace();
			 }  
		 }else if(command.equals("/galleryOrdeAction.ua")){//등록후-액션-갤러리로이동
			 action  = new galleryordertypeAction();
			 try {
				 forward=action.execute(request, response);
			 } catch (Exception e) {  
				 e.printStackTrace();
			 }  
		 }else if(command.equals("/GalleryMainBest.ua")){//등록후-액션-갤러리로이동
			 action  = new GalleryMainBest();
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
