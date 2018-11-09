package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;
import net.board.db.BoardDTO;

public class BoardModifyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO boarddao=new BoardDAO();
	   	BoardDTO boarddata=new BoardDTO();
		
		ActionForward forward = new ActionForward();
	 	request.setCharacterEncoding("utf-8");
   		
		int num=Integer.parseInt(request.getParameter("num"));

	   	boarddata=boarddao.getDetail(num);
	   	
	   	if(boarddata==null){
	   		System.out.println("수정 성공");
	   		return null;
	   	}
	   	System.out.println("수정 실패");
	   	
	   	request.setAttribute("boarddata", boarddata);
	   	forward.setRedirect(false);
   		/*forward.setPath("/board/qna_board_modify.jsp");*/
   		forward.setPath("./index.jsp?page=/board/qna_board_modify");
   		return forward;
   		
	}

}
