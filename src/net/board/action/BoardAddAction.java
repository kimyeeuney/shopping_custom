package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;
import net.board.db.BoardDTO;

public class BoardAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("BOARD_NAME");
		String pw = request.getParameter("BOARD_PASS");
		String subject = request.getParameter("BOARD_SUBJECT");
		String content = request.getParameter("BOARD_CONTENT");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		
		dto.setBOARD_NAME(name);
		dto.setBOARD_PASS(pw);
		dto.setBOARD_SUBJECT(subject);
		dto.setBOARD_CONTENT(content);
		
		boolean result = dao.boardInsert(dto);
		
		if(result) {
			System.out.println("data 저장 성공");
			
			//response.sendRedirect("BoardList.bo");
			forward = new ActionForward();
			forward.setRedirect(true);
		/*	out.println("location.href='./index.jsp?page=/custom/custom_order_2'");*/
			forward.setPath("./BoardList.bo");
//			forward.setPath("location.href='./BoardList.bo';");
		}else {
			System.out.println("data 저장 실패");
		}
		
		return forward;
	}
}





