package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;
import net.board.db.BoardDTO;

public class BoardReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		BoardDAO boarddao = new BoardDAO();
		BoardDTO boarddata = new BoardDTO();
		
		boarddata.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
		boarddata.setBOARD_NAME(request.getParameter("BOARD_NAME"));
		boarddata.setBOARD_PASS(request.getParameter("BOARD_PASS"));
		boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
		boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
		boarddata.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
		boarddata.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
		boarddata.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));
		
		int num = boarddao.boardReply(boarddata);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardDetailAction.bo?num="+num);
		forward.setRedirect(true);
		
		return forward;
	}

}




