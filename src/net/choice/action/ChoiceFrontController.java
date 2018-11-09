package net.choice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	//@WebServlet("*.ca")
	public class ChoiceFrontController extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doGet()호출..");
			doProcess(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doPost()호출..");
			doProcess(request, response);
		}
		
		//두 요청을 한번에 처리하게씀
		protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String uri =request.getRequestURI();
			//System.out.println(uri);
			String context = request.getContextPath();
			//System.out.println(context);
			String command = uri.substring(context.length());
			System.out.println(command); 
			
			Action action = null;
			ActionForward forward = null; //참조변수이자 지역변수. 반드시 초기화 할 것.
			
		//명령별로 수행해야할 조건들 체크
			if(command.equals("/")) {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("./");
			}else if(command.equals("/ChoiceAddAction.ca")) {
				action = new ChoiceAddAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("/ChoiceListAction.ca")) {
				action = new ChoiceListAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("/ChoiceCheck.ca")) {
				action = new ChoiceCheck();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
			
		
		if(forward != null) {//true라면
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());//재요청하겠음.
			}else {

				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			
			}
		}
	}
}
