package net.board.action;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

  
//@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
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
		if(command.equals("/BoardWrite.bo")) {
			
			forward = new ActionForward();
			forward.setRedirect(false);//false:직접적으로 페이지 이동해가서 서비스를 해주겠다.
			/*forward.setPath("./board/qna_board_write.jsp");*/
			forward.setPath("./index.jsp?page=/board/qna_board_write");

			
		}else if(command.equals("/BoardAddAction.bo")) {
			
			action = new BoardAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			   
			
		}else if(command.equals("/BoardList.bo")) {
			
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(command.equals("/BoardDetailAction.bo")) {
				
			 action = new BoardDetailAction();
			   try{
				   //실행하려면 forward에 담아줘야함
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }  

			   
		}else if(command.equals("/BoardReplyView.bo")){
			
			   action = new BoardReplyView();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   
			   
		}else if(command.equals("/BoardReplyAction.bo")){
			   action = new BoardReplyAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   
			   //수정
		}else if(command.equals("/BoardModify.bo")){
			
			   action = new BoardModifyView();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   
			   
		} else if(command.equals("/BoardModifyAction.bo")){
				
			   action = new BoardModifyAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   
			   
			   
			   //삭제
		}else if(command.equals("/BoardDelete.bo")){
			
			   forward=new ActionForward();
			   forward.setRedirect(false);
			  /* forward.setPath("./board/qna_board_delete.jsp");*/
			   forward.setPath("./index.jsp?page=/board/qna_board_delete");
			   
		} else if(command.equals("/BoardDeleteAction.bo")){
			
			   action = new BoardDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }	
		}else if(command.equals("/boardDownload.bo")) {
				
				forward = new ActionForward();
				forward.setRedirect(false);
				/*forward.setPath("./board/qna_board_download.jsp");*/
				forward.setPath("./index.jsp?page=/board/qna_board_download");
		   
		}else {
			
			System.out.println("요청 정보 확인 요망...");
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
 





