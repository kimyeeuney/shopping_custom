package net.choice.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.basket.db.BasketBean;
import net.gallery.db.GalleryBean;

public class ChoiceDAO {
	DataSource ds;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public ChoiceDAO() {
		try{
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		}catch(Exception ex){
			ex.printStackTrace();
		} 
	}
	
	
	
	public boolean addChoice(ChoiceBean choice, int num) throws SQLException{
		
		
		String sql="select max(CHOICE_NUM) from CHOICE";
		boolean result = false;
		int choicenum=0;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			choicenum=rs.getInt(1)+1;
			sql="insert into CHOICE values (?,?,?,?,sysdate)";
			
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, choicenum);
			pstmt.setInt(2, choice.getCHOICE_GALLERY_NUM());
			pstmt.setString(3, choice.getCHOICE_ID()); 
			pstmt.setInt(4, 0);
			pstmt.executeUpdate();
			  
			
			result = true;
			
			
			sql = "update GALLERY set GALLERY_RE_LEV "
					+ "= GALLERY_RE_LEV+1 "
					+ "where GALLERY_NUM = "+num;
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			
			
		}catch(Exception e){
			e.printStackTrace(); 
		} finally {
			if(rs != null) 
				try {rs.close();} catch (SQLException e) {} 
			if(pstmt != null) 
				try {pstmt.close();} catch (SQLException e) {}
			if(con != null) 
				try {con.close();} catch (SQLException e) {}
		}
		
		return result;
	}
	
	
	//초이스 여부 체크
		public int ChoiceIDCheck(int num, String id) throws SQLException{
			String sql=null;
			int x=-1;
			
			try{
				con = ds.getConnection();
				sql="select CHOICE_NUM from CHOICE where CHOICE_GALLERY_NUM=? and CHOICE_ID= ?";
				
				pstmt=con.prepareStatement(sql); 
				pstmt.setInt(1, num);
				pstmt.setString(2, id);
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					x=1;
				}
			}catch(Exception e){
				e.printStackTrace();
			}	finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				}catch(Exception ex) {}
			}
			
			return x;
		}
	
		//컬럼수
		public int getListCount(String id) {
			int count = 0;
			
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement("select count(*) from CHOICE where CHOICE_ID = ?");
				pstmt.setString(1, id);
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
		public List<ChoiceBean> getChoiceList(int page, int limit, String id) {
			String board_list_sql = "select * from "+
					"(select rownum rnum,CHOICE_NUM,CHOICE_GALLERY_NUM,CHOICE_ID,"+
					"CHOICE_READCOUNT,CHOICE_DATE from "+
					"(select * from CHOICE order by CHOICE_NUM desc )) "+
					"where rnum>=? and rnum<=? and CHOICE_ID = ?";
			
			List<ChoiceBean> list = new ArrayList<ChoiceBean>();
			 
			int startrow = (page-1)*10 + 1;
			int endrow = startrow + limit - 1;
			int num=0;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
				pstmt.setString(3, id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) { 
					ChoiceBean gb = new ChoiceBean();
					
					gb.setCHOICE_NUM(rs.getInt("CHOICE_NUM"));
					gb.setCHOICE_GALLERY_NUM(rs.getInt("CHOICE_GALLERY_NUM"));
					gb.setCHOICE_ID(rs.getString("CHOICE_ID"));
					gb.setCHOICE_READCOUNT(rs.getInt("CHOICE_READCOUNT"));
					gb.setCHOICE_DATE(rs.getTimestamp("CHOICE_DATE"));
					list.add(gb);
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
		
		
		
		
		
		
		
}
