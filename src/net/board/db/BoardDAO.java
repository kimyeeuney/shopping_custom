package net.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BoardDAO(){
		try { 
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 데이터 저장
	public boolean boardInsert(BoardDTO dto) {
		String sql = "select max(BOARD_NUM) from board";
		int num = 0;
		int result = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1)+1;
			} else {
				num = 1;
			}
			
			sql = "insert into board values (?,?,?,?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getBOARD_NAME());
			pstmt.setString(3, dto.getBOARD_PASS());
			pstmt.setString(4, dto.getBOARD_SUBJECT());
			pstmt.setString(5, dto.getBOARD_CONTENT());
			pstmt.setString(6, dto.getBOARD_FILE());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			
			result = pstmt.executeUpdate();
			
			if(result == 0) return false;
			
			return true;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("boardInsert 에러:"+ e);
		} finally {
			if(rs != null) 
				try {rs.close();} catch (SQLException e) {} 
			if(pstmt != null) 
				try {pstmt.close();} catch (SQLException e) {}
			if(con != null) 
				try {con.close();} catch (SQLException e) {}
		}
		
		return false;
	}
	
	//컬럼수
	public int getListCount() {
		int count = 0;
		
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) 
				try {rs.close();} catch (SQLException e) {} 
			if(pstmt != null) 
				try {pstmt.close();} catch (SQLException e) {}
			if(con != null) 
				try {con.close();} catch (SQLException e) {}
		}
		
		return count;
	}
	
	// 글 목록 보기
	public List<BoardDTO> getBoardList(int page, int limit) {
		String board_list_sql = "select * from "+
				"(select rownum rnum, BOARD_NUM, BOARD_NAME, BOARD_SUBJECT,"+
				"BOARD_CONTENT,BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,"+
				"BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE from "+
				"(select * from board order by BOARD_RE_REF desc, BOARD_RE_SEQ asc)) "+
				"where rnum>=? and rnum<=?";
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		int startrow = (page-1)*10 + 1;
		int endrow = startrow + limit - 1;
		 
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				
				list.add(board);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) 
				try {rs.close();} catch (SQLException e) {} 
			if(pstmt != null) 
				try {pstmt.close();} catch (SQLException e) {}
			if(con != null) 
				try {con.close();} catch (SQLException e) {}
		}
		
		return null;
	}
	
		
	
	// 조회수 업데이트
	public void setReadCountUpdate(int num) {
		String sql = "update board set BOARD_READCOUNT "
							+ "= BOARD_READCOUNT+1 "
							+ "where BOARD_NUM = "+num;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) 
				try {pstmt.close();} catch (SQLException e) {}
			if(con != null) 
				try {con.close();} catch (SQLException e) {}
		}
	}
	
	
	
	// 글 내용 보기(세부항목).
	public BoardDTO getDetail(int num) {
		BoardDTO board = null;
		String sql = "select * from board where BOARD_NUM = ?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardDTO();
				
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));

			}
			
			return board;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) 
				try {rs.close();} catch (SQLException e) {} 
			if(pstmt != null) 
				try {pstmt.close();} catch (SQLException e) {}
			if(con != null) 
				try {con.close();} catch (SQLException e) {}
		}
		
		return null;
	}
	
	// 답변 글 저장
	public int boardReply(BoardDTO board) {
		String sql = "select max(board_num) from board";
		
		int re_ref = board.getBOARD_RE_REF();
		int re_lev = board.getBOARD_RE_LEV();
		int re_seq = board.getBOARD_RE_SEQ();
		int num = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;
			
			sql = "update board set BOARD_RE_SEQ = "
					+ "BOARD_RE_SEQ+1 "
					+ "where BOARD_RE_REF = ?"
					+ "and BOARD_RE_SEQ > ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			pstmt.executeUpdate();
			
			re_lev++;
			re_seq++;
			
			sql = "insert into board values (?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getBOARD_NAME());
			pstmt.setString(3, board.getBOARD_PASS());
			pstmt.setString(4, board.getBOARD_SUBJECT());
			pstmt.setString(5, board.getBOARD_CONTENT());
			pstmt.setString(6, ""); // 답글에는 파일을 업로드하지 않음.
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			
			pstmt.executeUpdate();
			
			return num;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) 
				try {rs.close();} catch (SQLException e) {} 
			if(pstmt != null) 
				try {pstmt.close();} catch (SQLException e) {}
			if(con != null) 
				try {con.close();} catch (SQLException e) {}
		}
		
		return 0;
	}
	
	public boolean isBoardWriter(int num,String pass){
		String board_sql="select * from board where BOARD_NUM=?";
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(board_sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			rs.next();
			
			if(pass.equals(rs.getString("BOARD_PASS"))){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	//게시글 수정
		public boolean boardModify(BoardDTO modifyboard) throws Exception{
			String sql="update board set BOARD_SUBJECT=?, BOARD_CONTENT=? where BOARD_NUM=?";
			
			try{
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, modifyboard.getBOARD_SUBJECT());
				pstmt.setString(2, modifyboard.getBOARD_CONTENT());
				pstmt.setInt(3, modifyboard.getBOARD_NUM());
				pstmt.executeUpdate();
				return true;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(rs!=null)
					try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null)
					try{pstmt.close();}catch(SQLException ex){}
				if(con !=null)  
					try{con.close();}catch(SQLException ex){}
				}
			return false;
		}
		
		//게시글 삭제
		public boolean boardDelete(int num){
			String board_delete_sql="delete from board where BOARD_NUM=?";
			
			int result=0;
			 
			try{
				con = ds.getConnection();
				pstmt=con.prepareStatement(board_delete_sql);
				pstmt.setInt(1, num);
				
				//명령실행문장
				result=pstmt.executeUpdate();
				if(result==0)return false;
				
				return true;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
					if(pstmt!=null)
						try{pstmt.close();}catch(SQLException ex){}
					if(con !=null) 
						try{con.close();}catch(SQLException ex){}
			}  
			
			return false;
		}
		

}







