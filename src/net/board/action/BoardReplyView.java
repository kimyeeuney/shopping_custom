package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;
import net.board.db.BoardDTO;

public class BoardReplyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boarddao = new BoardDAO();
		BoardDTO boarddata = new BoardDTO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		boarddata = boarddao.getDetail(num);
		
		if(boarddata == null) {
			System.out.println("댓글 상세보기 실패");
			return null;
		}
		System.out.println("댓글 상세보기 성공");
		
		request.setAttribute("boarddata", boarddata);
		
		ActionForward forward = new ActionForward();
		/*forward.setPath("./board/qna_board_reply.jsp");*/
		forward.setPath("./index.jsp?page=/board/qna_board_reply");
		forward.setRedirect(false);
		
		return forward;
	}

}
