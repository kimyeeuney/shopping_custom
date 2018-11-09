package net.admin.sale.db;

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

import net.board.db.BoardDTO;
import net.choice.db.ChoiceBean;
import net.custom.db.OrderCustomBean;
import net.gallery.db.GalleryBean;
import net.member.db.MemberPointBean;

public class SaleDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;  
	
	public SaleDAO(){
		try { 
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	//컬럼수
		public int getListCount(String id) {
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
	
		// 판매중인 디자인리스트
		public List<SaleBean> getSaleList(int page, int limit, String id) {
			String board_list_sql = "select * from "+
					"(select rownum rnum,GALLERY_NUM,GALLERY_CUSTOM_ID,GALLERY_CUSTOM13,"+
					"GALLERY_CUSTOM1,GALLERY_CUSTOM2,GALLERY_CUSTOM3,"+
					"GALLERY_CUSTOM4,GALLERY_CUSTOM5,GALLERY_CUSTOM6,"+
					"GALLERY_CUSTOM7,GALLERY_CUSTOM8,GALLERY_CUSTOM9,"+
					"GALLERY_CUSTOM10,GALLERY_CUSTOM11,GALLERY_CUSTOM12,"+
					"GALLERY_RE_REF,GALLERY_RE_LEV,"+
					"GALLERY_RE_SEQ,GALLERY_READCOUNT,GALLERY_DATE from "+
					"(select * from GALLERY order by GALLERY_NUM desc, GALLERY_RE_SEQ asc)) "+
					"where rnum>=? and rnum<=? and GALLERY_CUSTOM_ID = ?";
			
			List<SaleBean> list = new ArrayList<SaleBean>();
			
			int startrow = (page-1)*10 + 1;
			int endrow = startrow + limit - 1;
			 
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
				pstmt.setString(3, id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					SaleBean gb = new SaleBean();
					
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
	
	
	
		
		
		//갤러리에 등록가능한 결제완료된 디자인 수.
				public int getSaleOkCount(String id) {
					int count = 0;
					int num1 = 0;
					int num2 = 1;
					
					try {
						con = ds.getConnection();
						pstmt = con.prepareStatement("select count(*) from CUSTOM_ORDER_2 where ORDER_CUSTOM_ID=? and ORDER_CUSTOM_GALLERY=? and ORDER_CUSTOM_TRADE_PAYER=? ");
						pstmt.setString(1, id);
						pstmt.setInt(2, 0);
						pstmt.setInt(3, 1);
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
				
				
				
				// 판매가능한 리스트
	public List<OrderCustomBean> getSaleOkList(int page, int limit, String id) {
		String board_list_sql = "select * from "+
  				"(select rownum rnum, ORDER_CUSTOM_NUM, ORDER_CUSTOM_ID, ORDER_CUSTOM13,"+
  				"ORDER_CUSTOM1,ORDER_CUSTOM2,ORDER_CUSTOM3,"+
  				"ORDER_CUSTOM4,ORDER_CUSTOM5,ORDER_CUSTOM6,"+
  				"ORDER_CUSTOM7,ORDER_CUSTOM8,ORDER_CUSTOM9,"+
  				"ORDER_CUSTOM10,ORDER_CUSTOM11,ORDER_CUSTOM12,"+
  				"ORDER_CUSTOM_RECEIVE_NAME, ORDER_CUSTOM_ZIPCODE1, ORDER_CUSTOM_ZIPCODE2,"+
  				"ORDER_CUSTOM_RECEIVE_ADDR1, ORDER_CUSTOM_RECEIVE_ADDR2, ORDER_CUSTOM_RECEIVE_PHONE,"+
  				"ORDER_CUSTOM_RECEIVE_MOBILE, ORDER_CUSTOM_MEMO, ORDER_CUSTOM_TRADE_TYPE,"+
  				"ORDER_CUSTOM_TRADE_DATE, ORDER_CUSTOM_TRADE_PAYER, ORDER_CUSTOM_GALLERY from "+
  				"(select * from CUSTOM_ORDER_2 order by ORDER_CUSTOM_NUM desc)) "+
  				"where rnum>=? and rnum<=? and ORDER_CUSTOM_ID=? and ORDER_CUSTOM_GALLERY=? and ORDER_CUSTOM_TRADE_PAYER=?";
		
		List<OrderCustomBean> list = new ArrayList<OrderCustomBean>();
		 
		int startrow = (page-1)*10 + 1;
		int endrow = startrow + limit - 1;
		int num=0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			pstmt.setString(3, id);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 1);
			rs=pstmt.executeQuery();
			  
			while(rs.next()) { 
				
				OrderCustomBean odt = new OrderCustomBean();
  				odt.setORDER_CUSTOM_NUM(rs.getInt("ORDER_CUSTOM_NUM"));
  				odt.setORDER_CUSTOM1(rs.getInt("ORDER_CUSTOM1"));
  				odt.setORDER_CUSTOM2(rs.getInt("ORDER_CUSTOM2"));
  				odt.setORDER_CUSTOM3(rs.getString("ORDER_CUSTOM3"));
  				odt.setORDER_CUSTOM4(rs.getInt("ORDER_CUSTOM4"));
  				odt.setORDER_CUSTOM5(rs.getInt("ORDER_CUSTOM5"));
  				odt.setORDER_CUSTOM6(rs.getInt("ORDER_CUSTOM6"));
  				odt.setORDER_CUSTOM7(rs.getInt("ORDER_CUSTOM7"));
  				odt.setORDER_CUSTOM8(rs.getInt("ORDER_CUSTOM8"));
  				odt.setORDER_CUSTOM9(rs.getInt("ORDER_CUSTOM9"));
  				odt.setORDER_CUSTOM10(rs.getInt("ORDER_CUSTOM10"));
  				odt.setORDER_CUSTOM11(rs.getInt("ORDER_CUSTOM11"));
  				odt.setORDER_CUSTOM12(rs.getString("ORDER_CUSTOM12"));
  				odt.setORDER_CUSTOM13(rs.getString("ORDER_CUSTOM13"));
  				odt.setORDER_CUSTOM_ID(rs.getString("ORDER_CUSTOM_ID"));
  				odt.setORDER_CUSTOM_RECEIVE_NAME(rs.getString("ORDER_CUSTOM_RECEIVE_NAME"));
  				odt.setORDER_CUSTOM_ZIPCODE1(rs.getInt("ORDER_CUSTOM_ZIPCODE1"));
  				odt.setORDER_CUSTOM_ZIPCODE2(rs.getInt("ORDER_CUSTOM_ZIPCODE2"));
  				odt.setORDER_CUSTOM_RECEIVE_ADDR1(rs.getString("ORDER_CUSTOM_RECEIVE_ADDR1"));
  				odt.setORDER_CUSTOM_RECEIVE_ADDR2(rs.getString("ORDER_CUSTOM_RECEIVE_ADDR2"));
  				odt.setORDER_CUSTOM_RECEIVE_PHONE(rs.getInt("ORDER_CUSTOM_RECEIVE_PHONE"));
  				odt.setORDER_CUSTOM_RECEIVE_MOBILE(rs.getInt("ORDER_CUSTOM_RECEIVE_MOBILE"));
  				odt.setORDER_CUSTOM_MEMO(rs.getString("ORDER_CUSTOM_MEMO"));
  				odt.setORDER_CUSTOM_TRADE_TYPE(rs.getString("ORDER_CUSTOM_TRADE_TYPE"));
  				odt.setORDER_CUSTOM_TRADE_DATE(rs.getTimestamp("ORDER_CUSTOM_TRADE_DATE"));
  				odt.setORDER_CUSTOM_TRADE_PAYER(rs.getInt("ORDER_CUSTOM_TRADE_PAYER"));
  				odt.setORDER_CUSTOM_GALLERY(rs.getInt("ORDER_CUSTOM_GALLERY"));
				list.add(odt);
				
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
	
	
	
	//결제된 상품 갤러리에 등록
	public boolean UpdateOKgallery(String id, int num) throws SQLException{
		String sql=null;
		
		try{
			con = ds.getConnection();
			sql="update CUSTOM_ORDER_2 set ORDER_CUSTOM_GALLERY=? where ORDER_CUSTOM_NUM=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, 1);	
			pstmt.setInt(2, num);	
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return true;
	}
		
	
	//User-admin : 갤러리에 등록  
	public OrderCustomBean getAddList(int getnum){
		OrderCustomBean ocb=null;
		String sql="select * from CUSTOM_ORDER_2 where ORDER_CUSTOM_NUM=?";
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getnum);
			rs=pstmt.executeQuery();  
			
			
			if(rs.next()){
				ocb=new OrderCustomBean();
				
				ocb.setORDER_CUSTOM_NUM(rs.getInt("ORDER_CUSTOM_NUM"));
				ocb.setORDER_CUSTOM1(rs.getInt("ORDER_CUSTOM1"));
				ocb.setORDER_CUSTOM2(rs.getInt("ORDER_CUSTOM2"));
				
				ocb.setORDER_CUSTOM3(rs.getString("ORDER_CUSTOM3"));
				
				ocb.setORDER_CUSTOM4(rs.getInt("ORDER_CUSTOM4"));
				ocb.setORDER_CUSTOM5(rs.getInt("ORDER_CUSTOM5"));
				ocb.setORDER_CUSTOM6(rs.getInt("ORDER_CUSTOM6"));
				ocb.setORDER_CUSTOM7(rs.getInt("ORDER_CUSTOM7"));
				ocb.setORDER_CUSTOM8(rs.getInt("ORDER_CUSTOM8"));
				ocb.setORDER_CUSTOM9(rs.getInt("ORDER_CUSTOM9"));
				ocb.setORDER_CUSTOM10(rs.getInt("ORDER_CUSTOM10"));
				ocb.setORDER_CUSTOM11(rs.getInt("ORDER_CUSTOM11"));
				
				ocb.setORDER_CUSTOM12(rs.getString("ORDER_CUSTOM12"));
				ocb.setORDER_CUSTOM13(rs.getString("ORDER_CUSTOM13"));
				ocb.setORDER_CUSTOM_ID(rs.getString("ORDER_CUSTOM_ID"));
				ocb.setORDER_CUSTOM_RECEIVE_NAME(rs.getString("ORDER_CUSTOM_RECEIVE_NAME"));
				
				ocb.setORDER_CUSTOM_ZIPCODE1(rs.getInt("ORDER_CUSTOM_ZIPCODE1"));
				ocb.setORDER_CUSTOM_ZIPCODE2(rs.getInt("ORDER_CUSTOM_ZIPCODE2"));
				
				ocb.setORDER_CUSTOM_RECEIVE_ADDR1(rs.getString("ORDER_CUSTOM_RECEIVE_ADDR1"));
				ocb.setORDER_CUSTOM_RECEIVE_ADDR2(rs.getString("ORDER_CUSTOM_RECEIVE_ADDR2"));
				
				ocb.setORDER_CUSTOM_RECEIVE_PHONE(rs.getInt("ORDER_CUSTOM_RECEIVE_PHONE"));
				ocb.setORDER_CUSTOM_RECEIVE_MOBILE(rs.getInt("ORDER_CUSTOM_RECEIVE_MOBILE"));
				
				ocb.setORDER_CUSTOM_MEMO(rs.getString("ORDER_CUSTOM_MEMO"));
				
				ocb.setORDER_CUSTOM_TRADE_TYPE(rs.getString("ORDER_CUSTOM_TRADE_TYPE"));
				ocb.setORDER_CUSTOM_TRADE_DATE(rs.getTimestamp("ORDER_CUSTOM_TRADE_DATE"));
				ocb.setORDER_CUSTOM_TRADE_PAYER(rs.getInt("ORDER_CUSTOM_TRADE_PAYER"));
				ocb.setORDER_CUSTOM_GALLERY(rs.getInt("ORDER_CUSTOM_GALLERY"));
				
			}
			
			return ocb;
			
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return ocb;
	}
	
	
public boolean insertGallery(GalleryBean gallery) throws SQLException{
		
		
		String sql="select max(GALLERY_NUM) from GALLERY";
		boolean result = false;
		int num=0;
		int gallerynum=0;
		int result2 = 0;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			gallerynum=rs.getInt(1)+1;
			sql="insert into GALLERY values "+
				"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, gallerynum);
			pstmt.setInt(2, gallery.getGALLERY_CUSTOM_NUM());
			pstmt.setString(3, gallery.getGALLERY_CUSTOM_ID()); 
			pstmt.setInt(4, gallery.getGALLERY_CUSTOM1());
			pstmt.setInt(5, gallery.getGALLERY_CUSTOM2());
			pstmt.setString(6, gallery.getGALLERY_CUSTOM3());
			pstmt.setInt(7, gallery.getGALLERY_CUSTOM4());
			pstmt.setInt(8, gallery.getGALLERY_CUSTOM5());
			pstmt.setInt(9, gallery.getGALLERY_CUSTOM6());
			pstmt.setInt(10, gallery.getGALLERY_CUSTOM7());
			pstmt.setInt(11, gallery.getGALLERY_CUSTOM8());
			pstmt.setInt(12, gallery.getGALLERY_CUSTOM9());
			pstmt.setInt(13, gallery.getGALLERY_CUSTOM10());
			pstmt.setInt(14, gallery.getGALLERY_CUSTOM11());
			pstmt.setString(15, gallery.getGALLERY_CUSTOM12());
			pstmt.setString(16, gallery.getGALLERY_CUSTOM13());
			pstmt.setInt(17, gallerynum);
			pstmt.setInt(18, 0);
			pstmt.setInt(19, 0);
			pstmt.setInt(20, 0);
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
	

//POINT
//point컬럼수=====================================
	public int getPointListCount(String id) {
		int count = 0;
		
		 
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select count(*) from POINT_SALE where POINT_DE_ID = ?");
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



// 포인트 글목록
	public List<SalePointBean> getPoint(int page, int limit, String id) {
		String board_list_sql = "select * from "+
				"(select rownum rnum, POINT_DE_ID, POINT_OR_ID,"+
				"POINT_CUSTOM_NUM, POINT_PLUS, POINT_DATE from "+
				"(select * from POINT_SALE order by POINT_DATE desc)) "+
				"where rnum>=? and rnum<=? and POINT_DE_ID = ?";
		
		List<SalePointBean> list = new ArrayList<SalePointBean>();
		 
		int startrow = (page-1)*10 + 1;
		int endrow = startrow + limit - 1;
		
		try {  
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			pstmt.setString(3, id);
			rs = pstmt.executeQuery();
			  
			while(rs.next()) { 
				SalePointBean gb = new SalePointBean();
				
				
				gb.setPOINT_DE_ID(rs.getString("POINT_DE_ID"));
				gb.setPOINT_OR_ID(rs.getString("POINT_OR_ID"));
				gb.setPOINT_CUSTOM_NUM(rs.getInt("POINT_CUSTOM_NUM"));
				gb.setPOINT_PLUS(rs.getInt("POINT_PLUS"));
				gb.setPOINT_DATE(rs.getDate("POINT_DATE"));
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

//현재 내 포인트
	public float getMaxPoint(String id) {  
		int count = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select sum(POINT_PLUS) from POINT_SALE where POINT_DE_ID = ?");
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

		
	//COUPON==================================================	
	//갤러리 DB에 insert
	public int InsertCoupon(String id, int num) throws SQLException{
	int x=0;
	  
	String sql="insert into COUPON values (?,?,?,sysdate)";
	
	try{
		con = ds.getConnection();
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setInt(2, num);
		pstmt.setInt(3, 0);
		pstmt.executeUpdate();
		
		x = 1;
		
		
	}catch(Exception e){
		e.printStackTrace(); 
	}finally{
		try{
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}catch(Exception ex) {}
	}
		
		return x;
	}	
		
		
		
	// 현재 내 쿠폰
	public int getCoupon(String id) {
		String board_list_sql = "select sum(COUPON_SUM) from COUPON where COUPON_ID = ?";
		int COUPON_SUM=0;
		int COUPON_CH=0;
		
		int count=0;
		try {  
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			  
			
			while(rs.next()) { 
				COUPON_SUM = rs.getInt(1);
			}
			
			
			
			board_list_sql = "select sum(COUPON_CH) from COUPON where COUPON_ID = ?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			  
			while(rs.next()) { 
				COUPON_CH = rs.getInt(1);
			}
			
			
			count = COUPON_SUM-COUPON_CH;    
			
			return count;
			
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
	
		
	//쿠폰COUPON_USER(선물하기)insert >> COUPON(구매내역)누적
		public int InsertUserCoupon(String id, String userId, int num, String couponName) throws SQLException{
		int x=0;
		int PointDate =0;
		int PointSum=0;
		String sql="insert into COUPON_USER values (?,?,?,?,sysdate)";
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, id);
			pstmt.setInt(3, num);
			pstmt.setString(4, couponName);
			pstmt.executeUpdate();
			
			x = 1;
			
			//누적시켜야함
			sql="insert into COUPON values (?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, 0);
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace(); 
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
			
			return x;
		}		
		
		
	
		
		//================COUPON
		public int getCouponListCount(String id) {
			int count = 0;
			
			 
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement("select count(*) from COUPON where COUPON_ID = ?");
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


		// 글 목록 보기2
		public List<SaleCouponBean> getCouponList(int page, int limit, String id) {
			String board_list_sql = "select * from "+
					"(select rownum rnum, COUPON_ID, COUPON_SUM,"+
					"COUPON_DATE from "+
					"(select * from COUPON order by COUPON_DATE desc)) "+
					"where rnum>=? and rnum<=? and COUPON_ID = ?";
			
			List<SaleCouponBean> list = new ArrayList<SaleCouponBean>();
			 
			int startrow = (page-1)*10 + 1;
			int endrow = startrow + limit - 1;
			
			try {  
				con = ds.getConnection();
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
				pstmt.setString(3, id);
				rs = pstmt.executeQuery();
				  
				while(rs.next()) { 
					SaleCouponBean gb = new SaleCouponBean();
					
					
					gb.setCOUPON_ID(rs.getString("COUPON_ID"));
					gb.setCOUPON_SUM(rs.getInt("COUPON_SUM"));
					gb.setCOUPON_DATE(rs.getDate("COUPON_DATE"));
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

		
		
		
		//==============22222===============
		public int getCouponListCount2(String id) {
			int count = 0;
			
			 
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement("select count(*) from COUPON_USER where COUPON_ADMIN_ID = ?");
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
		public List<SaleCouponBean> getCouponList2(int page, int limit, String id) {
			String board_list_sql = "select * from "+
					"(select rownum rnum, COUPON_USER_ID, COUPON_ADMIN_ID,"+
					"COUPON_USER_SUM,COUPON_NAME, COUPON_DATE  from "+
					"(select * from COUPON_USER order by COUPON_DATE desc)) "+
					"where rnum>=? and rnum<=? and COUPON_ADMIN_ID = ?";
			
			List<SaleCouponBean> list = new ArrayList<SaleCouponBean>();
			 
			int startrow = (page-1)*10 + 1;
			int endrow = startrow + limit - 1;
			
			try {  
				con = ds.getConnection();
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
				pstmt.setString(3, id);
				rs = pstmt.executeQuery();
				  
				while(rs.next()) { 
					SaleCouponBean gb = new SaleCouponBean();
					
					gb.setCOUPON_USER_ID(rs.getString("COUPON_USER_ID"));
					gb.setCOUPON_ADMIN_ID(rs.getString("COUPON_ADMIN_ID"));
					gb.setCOUPON_USER_SUM(rs.getInt("COUPON_USER_SUM"));
					gb.setCOUPON_NAME(rs.getString("COUPON_NAME"));
					gb.setCOUPON_DATE(rs.getDate("COUPON_DATE"));
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
