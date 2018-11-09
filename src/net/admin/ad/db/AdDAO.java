package net.admin.ad.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.gallery.db.GalleryBean;
import net.member.db.MemberBean;

public class AdDAO {
	DataSource ds;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public AdDAO() {
		try{
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		}catch(Exception ex){
			ex.printStackTrace();
		} 
	}
	
	
	
	
	
	//내 갤러리리스트 컬럼수
	public int getGalleryListCount(String id) {
		int count = 0;
		
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select count(*) from GALLERY where GALLERY_CUSTOM_ID = ?");
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
	//내 광고 가능한 갤러리리스트
	public List<GalleryBean> getGalleryList(String id) {
		String board_list_sql = "select * from "+
				"(select rownum rnum,GALLERY_NUM,GALLERY_CUSTOM_ID,GALLERY_CUSTOM13,"+
				"GALLERY_CUSTOM1,GALLERY_CUSTOM2,GALLERY_CUSTOM3,"+
				"GALLERY_CUSTOM4,GALLERY_CUSTOM5,GALLERY_CUSTOM6,"+
				"GALLERY_CUSTOM7,GALLERY_CUSTOM8,GALLERY_CUSTOM9,"+
				"GALLERY_CUSTOM10,GALLERY_CUSTOM11,GALLERY_CUSTOM12,"+
				"GALLERY_RE_REF,GALLERY_RE_LEV,"+
				"GALLERY_RE_SEQ,GALLERY_READCOUNT,GALLERY_DATE from "+
				"(select * from GALLERY order by GALLERY_RE_LEV desc )) "+
				"where GALLERY_CUSTOM_ID =? ";
		
		List<GalleryBean> list = new ArrayList<GalleryBean>();
		 
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				GalleryBean gb = new GalleryBean();
				
				gb.setGALLERY_NUM(rs.getInt("GALLERY_NUM"));
				gb.setGALLERY_CUSTOM_ID(rs.getString("GALLERY_CUSTOM_ID"));
				
				gb.setGALLERY_CUSTOM1(rs.getInt("GALLERY_CUSTOM1"));
				gb.setGALLERY_CUSTOM2(rs.getInt("GALLERY_CUSTOM2"));
				gb.setGALLERY_CUSTOM3(rs.getString("GALLERY_CUSTOM3"));
				gb.setGALLERY_CUSTOM4(rs.getInt("GALLERY_CUSTOM4"));
				gb.setGALLERY_CUSTOM5(rs.getInt("GALLERY_CUSTOM5"));
				gb.setGALLERY_CUSTOM6(rs.getInt("GALLERY_CUSTOM6"));
				gb.setGALLERY_CUSTOM7(rs.getInt("GALLERY_CUSTOM7"));
				gb.setGALLERY_CUSTOM8(rs.getInt("GALLERY_CUSTOM8"));
				gb.setGALLERY_CUSTOM9(rs.getInt("GALLERY_CUSTOM9"));
				gb.setGALLERY_CUSTOM10(rs.getInt("GALLERY_CUSTOM10"));
				gb.setGALLERY_CUSTOM11(rs.getInt("GALLERY_CUSTOM11"));
				gb.setGALLERY_CUSTOM12(rs.getString("GALLERY_CUSTOM12"));
				gb.setGALLERY_CUSTOM13(rs.getString("GALLERY_CUSTOM13"));
				gb.setGALLERY_RE_REF(rs.getInt("GALLERY_RE_REF"));
				gb.setGALLERY_RE_LEV(rs.getInt("GALLERY_RE_LEV"));
				gb.setGALLERY_RE_SEQ(rs.getInt("GALLERY_RE_SEQ"));
				gb.setGALLERY_READCOUNT(rs.getInt("GALLERY_READCOUNT"));
				gb.setGALLERY_DATE(rs.getTimestamp("GALLERY_DATE"));
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
	
	
	//광고 DB에 등록할 갤러리정보 가져오기
	public GalleryBean getGalleryListNum(int num) throws SQLException{
		GalleryBean gb=null;
		String sql=null;
		
		try{
			con = ds.getConnection();
			sql="select * from GALLERY where GALLERY_NUM=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				gb = new GalleryBean();
				
				gb.setGALLERY_NUM(rs.getInt("GALLERY_NUM"));
				gb.setGALLERY_CUSTOM_ID(rs.getString("GALLERY_CUSTOM_ID"));
				gb.setGALLERY_CUSTOM1(rs.getInt("GALLERY_CUSTOM1"));
				gb.setGALLERY_CUSTOM2(rs.getInt("GALLERY_CUSTOM2"));
				gb.setGALLERY_CUSTOM3(rs.getString("GALLERY_CUSTOM3"));
				gb.setGALLERY_CUSTOM4(rs.getInt("GALLERY_CUSTOM4"));
				gb.setGALLERY_CUSTOM5(rs.getInt("GALLERY_CUSTOM5"));
				gb.setGALLERY_CUSTOM6(rs.getInt("GALLERY_CUSTOM6"));
				gb.setGALLERY_CUSTOM7(rs.getInt("GALLERY_CUSTOM7"));
				gb.setGALLERY_CUSTOM8(rs.getInt("GALLERY_CUSTOM8"));
				gb.setGALLERY_CUSTOM9(rs.getInt("GALLERY_CUSTOM9"));
				gb.setGALLERY_CUSTOM10(rs.getInt("GALLERY_CUSTOM10"));
				gb.setGALLERY_CUSTOM11(rs.getInt("GALLERY_CUSTOM11"));
				gb.setGALLERY_CUSTOM12(rs.getString("GALLERY_CUSTOM12"));
				gb.setGALLERY_CUSTOM13(rs.getString("GALLERY_CUSTOM13"));
				gb.setGALLERY_RE_REF(rs.getInt("GALLERY_RE_REF"));
				gb.setGALLERY_RE_LEV(rs.getInt("GALLERY_RE_LEV"));
				gb.setGALLERY_RE_SEQ(rs.getInt("GALLERY_RE_SEQ"));
				gb.setGALLERY_READCOUNT(rs.getInt("GALLERY_READCOUNT"));
				gb.setGALLERY_DATE(rs.getTimestamp("GALLERY_DATE"));
				
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
		
		return gb;
	}
	
	
	
	
	
	//광고 DB에 insert
			public boolean insertADGallery(AdMyBean AD) throws SQLException{
				
			
			
			String sql="select max(AD_NUM) from AD";
			boolean result = false;
			int num=0;
			int result2 = 0;
			
			try{
				con = ds.getConnection();
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				rs.next();
				num=rs.getInt(1)+1;
				sql="insert into AD values "+
					"(?,?,?,?,sysdate)";
				
				
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setString(2, AD.getAD_ID()); 
				pstmt.setString(3, AD.getAD_NAME()); 
				pstmt.setInt(4, AD.getAD_PRICE());
				pstmt.executeUpdate();
				  
				
				result = true;
				
				
			}catch(Exception e){
				e.printStackTrace(); 
			}finally{
				try{
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				}catch(Exception ex) {}
			}
			
			return result;
		}
			
	//광고
	public List<AdMyBean> getAdList() {
		String board_list_sql = "select * from "+
				"(select rownum rnum, AD_NUM, AD_ID, AD_NAME, AD_PRICE, AD_DATE from "+
				"(select * from AD order by AD_PRICE desc )) "+
				"where rnum<=5";
		
		List<AdMyBean> list = new ArrayList<AdMyBean>();
		 
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			rs = pstmt.executeQuery();
			  
			while(rs.next()) { 
				AdMyBean gb = new AdMyBean();
				
				gb.setAD_NUM(rs.getInt("AD_NUM"));
				gb.setAD_ID(rs.getString("AD_ID"));
				gb.setAD_NAME(rs.getString("AD_NAME"));
				gb.setAD_PRICE(rs.getInt("AD_PRICE"));
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
			
	//광고리스트 컬럼 수
	public int getADListCount() {
		int count = 0;
		
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select count(*) from AD");
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
	
			
	//이미 등록되어있는 광고인지 확인
	public int AdCheck(String num, String id) throws SQLException{
		String sql=null;
		int x=-1;
		
		try{
			con = ds.getConnection();
			sql="select AD_NAME from AD where AD_NAME=? and AD_ID =?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, num);
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
			
			
	//===============================
		public List<AdMyBean> getADIDList(String id) {
			String board_list_sql = "select * from "+
					"(select rownum rnum, AD_NUM, AD_ID, AD_NAME, AD_PRICE, AD_DATE from "+
					"(select * from AD order by AD_PRICE desc )) "+
					"where AD_ID=?";
			
			List<AdMyBean> list = new ArrayList<AdMyBean>();
			 
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				  
				while(rs.next()) { 
					AdMyBean gb = new AdMyBean();
					
					gb.setAD_NUM(rs.getInt("AD_NUM"));
					gb.setAD_ID(rs.getString("AD_ID"));
					gb.setAD_NAME(rs.getString("AD_NAME"));
					gb.setAD_PRICE(rs.getInt("AD_PRICE"));
					gb.setAD_DATE(rs.getDate("AD_DATE"));
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
				
		//광고리스트 컬럼 수
		public int getADIDListCount(String id) {
			int count = 0;
			
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement("select count(*) from AD where AD_ID=?");
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
			
			
		//광고DB에서 삭제
				public boolean ADRemove(int num, String id) {
					String sql = "delete from AD where AD_NUM=? and AD_ID = ?";
					
					try {
						con = ds.getConnection();
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, num);
						pstmt.setString(2, id);
						if(pstmt.executeUpdate()!=0){
							return true;
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					finally{
						try{
							if(pstmt!=null)pstmt.close();
							if(con!=null)con.close();
						}catch(Exception ex) {}
					}
					return false;
				}		
			
			
			
			
			
			
			
			
			
			
}
