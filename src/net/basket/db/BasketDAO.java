package net.basket.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.custom.db.OrderCustomBean;
import net.gallery.db.GalleryBean;
import net.member.db.MemberBean;

public class BasketDAO {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs, rs1;
	
	public BasketDAO(){
		try{
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	public void basketAdd(BasketBean ocb, String id) throws SQLException{
		String sql="select max(BASKET_NUM) from BASKET where BASKET_CUSTOM_ID = ?";
		int num=0;
		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			rs.next();
			num=rs.getInt(1)+1;
			
			sql="insert into BASKET values "+
				"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, ocb.getBASKET_CUSTOM1());
			pstmt.setInt(3, ocb.getBASKET_CUSTOM2());
			pstmt.setString(4, ocb.getBASKET_CUSTOM3());
			pstmt.setInt(5, ocb.getBASKET_CUSTOM4());
			pstmt.setInt(6, ocb.getBASKET_CUSTOM5());
			pstmt.setInt(7, ocb.getBASKET_CUSTOM6());
			pstmt.setInt(8, ocb.getBASKET_CUSTOM7());
			pstmt.setInt(9, ocb.getBASKET_CUSTOM8());
			pstmt.setInt(10, ocb.getBASKET_CUSTOM9());
			pstmt.setInt(11, ocb.getBASKET_CUSTOM10());
			pstmt.setInt(12, ocb.getBASKET_CUSTOM11());
			pstmt.setString(13, ocb.getBASKET_CUSTOM12());
			pstmt.setString(14, ocb.getBASKET_CUSTOM13());
			pstmt.setString(15, ocb.getBASKET_CUSTOM_ID());
			pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs != null) 
				try {rs.close();} catch (SQLException e) {} 
			if(pstmt != null) 
				try {pstmt.close();} catch (SQLException e) {}
			if(conn != null) 
				try {conn.close();} catch (SQLException e) {}
		}
	}
	
	
	public boolean basketRemove(int num) {
		String sql = "delete from BASKET where BASKET_NUM=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			if(pstmt.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		return false;
	}
	
	
	
	
	//컬럼수
	public int getListCount(String id) {
		int count = 0;
		
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select count(*) from BASKET where BASKET_CUSTOM_ID = ?");
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
			if(conn != null) 
				try {conn.close();} catch (SQLException e) {}
		}
		return count;
	}
	
	
	
	// 글 목록 보기
	public List<BasketBean> getBasketList(int page, int limit, String id) {
		String board_list_sql = "select * from "+
				"(select rownum rnum,BASKET_NUM,BASKET_CUSTOM1,BASKET_CUSTOM2,"+
				"BASKET_CUSTOM3,BASKET_CUSTOM4,BASKET_CUSTOM5,"+
				"BASKET_CUSTOM6,BASKET_CUSTOM7,BASKET_CUSTOM8,"+
				"BASKET_CUSTOM9,BASKET_CUSTOM10,BASKET_CUSTOM11,"+
				"BASKET_CUSTOM12,BASKET_CUSTOM13,BASKET_CUSTOM_ID from "+
				"(select * from BASKET order by BASKET_NUM desc )) "+
				"where rnum>=? and rnum<=? and BASKET_CUSTOM_ID = ?";
		
		List<BasketBean> list = new ArrayList<BasketBean>();
		 
		int startrow = (page-1)*10 + 1;
		int endrow = startrow + limit - 1;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			pstmt.setString(3, id);
			rs = pstmt.executeQuery();
			  
			while(rs.next()) { 
				BasketBean gb = new BasketBean();
				
				gb.setBASKET_NUM(rs.getInt("BASKET_NUM"));
				gb.setBASKET_CUSTOM1(rs.getInt("BASKET_CUSTOM1"));
				gb.setBASKET_CUSTOM2(rs.getInt("BASKET_CUSTOM2"));
				gb.setBASKET_CUSTOM3(rs.getString("BASKET_CUSTOM3"));
				gb.setBASKET_CUSTOM4(rs.getInt("BASKET_CUSTOM4"));
				gb.setBASKET_CUSTOM5(rs.getInt("BASKET_CUSTOM5"));
				gb.setBASKET_CUSTOM6(rs.getInt("BASKET_CUSTOM6"));
				gb.setBASKET_CUSTOM7(rs.getInt("BASKET_CUSTOM7"));
				gb.setBASKET_CUSTOM8(rs.getInt("BASKET_CUSTOM8"));
				gb.setBASKET_CUSTOM9(rs.getInt("BASKET_CUSTOM9"));
				gb.setBASKET_CUSTOM10(rs.getInt("BASKET_CUSTOM10"));
				gb.setBASKET_CUSTOM11(rs.getInt("BASKET_CUSTOM11"));
				gb.setBASKET_CUSTOM12(rs.getString("BASKET_CUSTOM12"));
				gb.setBASKET_CUSTOM13(rs.getString("BASKET_CUSTOM13"));
				gb.setBASKET_CUSTOM_ID(rs.getString("BASKET_CUSTOM_ID"));
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
			if(conn != null) 
				try {conn.close();} catch (SQLException e) {}
		}
		
		return null;
	}
	
	
	
	// 글 내용 보기(세부항목).
	public BasketBean getDetail(int num) {
		BasketBean basket = null;
		String sql = "select * from BASKET where BASKET_NUM = ?";
		
		try {
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		
		rs = pstmt.executeQuery();  
		
		if(rs.next()) {
			basket = new BasketBean();
			
			basket.setBASKET_NUM(rs.getInt("BASKET_NUM"));
			basket.setBASKET_CUSTOM1(rs.getInt("BASKET_CUSTOM1"));
			basket.setBASKET_CUSTOM2(rs.getInt("BASKET_CUSTOM2"));
			basket.setBASKET_CUSTOM3(rs.getString("BASKET_CUSTOM3"));
			basket.setBASKET_CUSTOM4(rs.getInt("BASKET_CUSTOM4"));
			basket.setBASKET_CUSTOM5(rs.getInt("BASKET_CUSTOM5"));
			basket.setBASKET_CUSTOM6(rs.getInt("BASKET_CUSTOM6"));
			basket.setBASKET_CUSTOM7(rs.getInt("BASKET_CUSTOM7"));
			basket.setBASKET_CUSTOM8(rs.getInt("BASKET_CUSTOM8"));
			basket.setBASKET_CUSTOM9(rs.getInt("BASKET_CUSTOM9"));
			basket.setBASKET_CUSTOM10(rs.getInt("BASKET_CUSTOM10"));
			basket.setBASKET_CUSTOM11(rs.getInt("BASKET_CUSTOM11"));
			basket.setBASKET_CUSTOM12(rs.getString("BASKET_CUSTOM12"));
			basket.setBASKET_CUSTOM13(rs.getString("BASKET_CUSTOM13"));
			basket.setBASKET_CUSTOM_ID(rs.getString("BASKET_CUSTOM_ID"));
			
		}
			
			return basket;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) 
				try {rs.close();} catch (SQLException e) {} 
			if(pstmt != null) 
				try {pstmt.close();} catch (SQLException e) {}
			if(conn != null) 
				try {conn.close();} catch (SQLException e) {}
		}
		
		return null;
	}
	
	
	public BasketBean getBasketCustom(String id, int num) throws SQLException{
		BasketBean basket=null;
		String sql=null;
		
		try{
			conn = ds.getConnection();
			sql="select * from BASKET where BASKET_CUSTOM_ID=? and BASKET_NUM = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				basket =new BasketBean();
				
				basket.setBASKET_NUM(rs.getInt("BASKET_NUM"));
				basket.setBASKET_CUSTOM1(rs.getInt("BASKET_CUSTOM1"));
				basket.setBASKET_CUSTOM2(rs.getInt("BASKET_CUSTOM2"));
				basket.setBASKET_CUSTOM3(rs.getString("BASKET_CUSTOM3"));
				basket.setBASKET_CUSTOM4(rs.getInt("BASKET_CUSTOM4"));
				basket.setBASKET_CUSTOM5(rs.getInt("BASKET_CUSTOM5"));
				basket.setBASKET_CUSTOM6(rs.getInt("BASKET_CUSTOM6"));
				basket.setBASKET_CUSTOM7(rs.getInt("BASKET_CUSTOM7"));
				basket.setBASKET_CUSTOM8(rs.getInt("BASKET_CUSTOM8"));
				basket.setBASKET_CUSTOM9(rs.getInt("BASKET_CUSTOM9"));
				basket.setBASKET_CUSTOM10(rs.getInt("BASKET_CUSTOM10"));
				basket.setBASKET_CUSTOM11(rs.getInt("BASKET_CUSTOM11"));
				basket.setBASKET_CUSTOM12(rs.getString("BASKET_CUSTOM12"));
				basket.setBASKET_CUSTOM13(rs.getString("BASKET_CUSTOM13"));
				basket.setBASKET_CUSTOM_ID(rs.getString("BASKET_CUSTOM_ID"));
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		
		return basket;
	}
	
	
	
}
