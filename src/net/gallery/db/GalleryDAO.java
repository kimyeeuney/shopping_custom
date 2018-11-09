package net.gallery.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.custom.db.OrderCustomBean;

public class GalleryDAO {
	DataSource ds;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public GalleryDAO() {
		try{
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		}catch(Exception ex){
			ex.printStackTrace();
		} 
	}
	
	//오더커스텀2 db에 1업데이트
	public boolean updateGallery(OrderCustomBean ocb) throws SQLException{
		String sql=null;
		
		try{
			con = ds.getConnection();
			sql="update CUSTOM_ORDER_2 set ORDER_CUSTOM_GALLERY=? where ORDER_CUSTOM_NUM=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, ocb.getORDER_CUSTOM_GALLERY());	
			pstmt.setInt(2, ocb.getORDER_CUSTOM_NUM());	
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
	
	
	
	//갤러리 DB에 insert
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
	
	
		//컬럼수
		public int getListCount() {
			int count = 0;
			
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement("select count(*) from GALLERY");
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
public List<GalleryBean> getGalleryList(int page, int limit) {
	String board_list_sql = "select * from "+
			"(select rownum rnum,GALLERY_NUM,GALLERY_CUSTOM_ID,GALLERY_CUSTOM13,"+
			"GALLERY_CUSTOM1,GALLERY_CUSTOM2,GALLERY_CUSTOM3,"+
			"GALLERY_CUSTOM4,GALLERY_CUSTOM5,GALLERY_CUSTOM6,"+
			"GALLERY_CUSTOM7,GALLERY_CUSTOM8,GALLERY_CUSTOM9,"+
			"GALLERY_CUSTOM10,GALLERY_CUSTOM11,GALLERY_CUSTOM12,"+
			"GALLERY_RE_REF,GALLERY_RE_LEV,"+
			"GALLERY_RE_SEQ,GALLERY_READCOUNT,GALLERY_DATE from "+
			"(select * from GALLERY order by GALLERY_NUM desc, GALLERY_RE_SEQ asc)) "+
			"where rnum>=? and rnum<=?";
	
	List<GalleryBean> list = new ArrayList<GalleryBean>();
	 
	int startrow = (page-1)*10 + 1;
	int endrow = startrow + limit - 1;
	
	try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(board_list_sql);
		pstmt.setInt(1, startrow);
		pstmt.setInt(2, endrow);
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
	
	// 조회수 업데이트
	public boolean setReadCountUpdate(int num) {
		String sql = "update GALLERY set GALLERY_READCOUNT "
							+ "= GALLERY_READCOUNT+1 "
							+ "where GALLERY_NUM = "+num;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) 
				try {pstmt.close();} catch (SQLException e) {} 
			if(con != null) 
				try {con.close();} catch (SQLException e) {}
		}
		return false;
	}
	
	
	// 글 내용 보기(세부항목).
		public GalleryBean getDetail(int num) {
			GalleryBean gallery = null;
			String sql = "select * from GALLERY where GALLERY_NUM = ?";
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				
				rs = pstmt.executeQuery();  
				
				if(rs.next()) {
					gallery = new GalleryBean();
					
					gallery.setGALLERY_NUM(rs.getInt("GALLERY_NUM"));
					gallery.setGALLERY_CUSTOM_NUM(rs.getInt("GALLERY_CUSTOM_NUM"));
					gallery.setGALLERY_CUSTOM_ID(rs.getString("GALLERY_CUSTOM_ID"));
					gallery.setGALLERY_CUSTOM1(rs.getInt("GALLERY_CUSTOM1"));
					gallery.setGALLERY_CUSTOM2(rs.getInt("GALLERY_CUSTOM2"));
					gallery.setGALLERY_CUSTOM3(rs.getString("GALLERY_CUSTOM3"));
					gallery.setGALLERY_CUSTOM4(rs.getInt("GALLERY_CUSTOM4"));
					gallery.setGALLERY_CUSTOM5(rs.getInt("GALLERY_CUSTOM5"));
					gallery.setGALLERY_CUSTOM6(rs.getInt("GALLERY_CUSTOM6"));
					gallery.setGALLERY_CUSTOM7(rs.getInt("GALLERY_CUSTOM7"));
					gallery.setGALLERY_CUSTOM8(rs.getInt("GALLERY_CUSTOM8"));
					gallery.setGALLERY_CUSTOM9(rs.getInt("GALLERY_CUSTOM9"));
					gallery.setGALLERY_CUSTOM10(rs.getInt("GALLERY_CUSTOM10"));
					gallery.setGALLERY_CUSTOM11(rs.getInt("GALLERY_CUSTOM11"));
					gallery.setGALLERY_CUSTOM12(rs.getString("GALLERY_CUSTOM12"));
					gallery.setGALLERY_CUSTOM13(rs.getString("GALLERY_CUSTOM13"));
					gallery.setGALLERY_RE_REF(rs.getInt("GALLERY_RE_REF"));
					gallery.setGALLERY_RE_LEV(rs.getInt("GALLERY_RE_LEV"));
					gallery.setGALLERY_RE_SEQ(rs.getInt("GALLERY_RE_SEQ"));
					gallery.setGALLERY_READCOUNT(rs.getInt("GALLERY_READCOUNT"));
					gallery.setGALLERY_DATE(rs.getTimestamp("GALLERY_DATE"));
					
				}
				
				return gallery;
				
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
	
	  
		
		
		
		
		//갤러리주문
		public boolean insertUserGallery(GalleryOrderBean ocb) throws SQLException{
			
			
			String sql="select max(GALLERY_ORDER_NUM) from GALLERY_ORDER";
			boolean result = false;
			int num=0;
			int ordernum=0;
			
			try{
				con = ds.getConnection();
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				rs.next();
				num=rs.getInt(1)+1;
				sql="insert into GALLERY_ORDER values "+
					"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?)";
				
				
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setString(2, ocb.getGALLERY_DESIGNER_ID());
				
				pstmt.setInt(3, ocb.getGALLERY_CUSTOM_NUM());
				pstmt.setInt(4, ocb.getGALLERY_NUM());
				pstmt.setInt(5, ocb.getGALLERY_ORDER_CUSTOM1());
				pstmt.setInt(6, ocb.getGALLERY_ORDER_CUSTOM2());
				
				pstmt.setString(7, ocb.getGALLERY_ORDER_CUSTOM3());
				
				pstmt.setInt(8, ocb.getGALLERY_ORDER_CUSTOM4());
				pstmt.setInt(9, ocb.getGALLERY_ORDER_CUSTOM5());
				pstmt.setInt(10, ocb.getGALLERY_ORDER_CUSTOM6());
				pstmt.setInt(11, ocb.getGALLERY_ORDER_CUSTOM7());
				pstmt.setInt(12, ocb.getGALLERY_ORDER_CUSTOM8());
				pstmt.setInt(13, ocb.getGALLERY_ORDER_CUSTOM9());
				pstmt.setInt(14, ocb.getGALLERY_ORDER_CUSTOM10());
				pstmt.setInt(15, ocb.getGALLERY_ORDER_CUSTOM11());
				
				pstmt.setString(16, ocb.getGALLERY_ORDER_CUSTOM12());
				pstmt.setString(17, ocb.getGALLERY_ORDER_CUSTOM13());
				pstmt.setString(18, ocb.getGALLERY_ORDER_ID());
				pstmt.setString(19, ocb.getGALLERY_ORDER_NAME());
				
				pstmt.setInt(20, ocb.getGALLERY_ORDER_ZIPCODE1());
				pstmt.setInt(21, ocb.getGALLERY_ORDER_ZIPCODE2());
				
				pstmt.setString(22, ocb.getGALLERY_ORDER_ADDR1());
				pstmt.setString(23, ocb.getGALLERY_ORDER_ADDR2());
				
				pstmt.setInt(24, ocb.getGALLERY_ORDER_PHONE());
				pstmt.setInt(25, ocb.getGALLERY_ORDER_MOBILE());
				
				pstmt.setString(26, ocb.getGALLERY_ORDER_MEMO());
				pstmt.setString(27, ocb.getGALLERY_ORDER_TRADE_TYPE());
				
				pstmt.setInt(28, ocb.getGALLERY_ORDER_TRADE_PAYER());
				
				pstmt.executeUpdate();
				  
				result = true;
				ordernum=num;
				
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
		
	
		//1
				public int getprice(int price) {
					int getprice = 0;
					
					
					try {  
						con = ds.getConnection();
						pstmt = con.prepareStatement("select GALLERY_CUSTOM_NUM from GALLERY where GALLERY_NUM = ? ");
						pstmt.setInt(1, price);
						rs = pstmt.executeQuery();
						
						if(rs.next()) {
							getprice = rs.getInt(1);
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
					return getprice;
				}
	
	
				//2
				public int getprice_2(int price) {
					int getprice = 0;
					
					
					try {  
						con = ds.getConnection();
						pstmt = con.prepareStatement("select ORDER_CUSTOM_RECEIVE_PHONE from CUSTOM_ORDER_2 where ORDER_CUSTOM_NUM = ? ");
						pstmt.setInt(1, price);
						rs = pstmt.executeQuery();
						
						if(rs.next()) {
							getprice = rs.getInt(1);
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
					return getprice;
				}
	
				
		//sale에서 갤러리 등록 취소
		public boolean galleryRemove(int num) {
			String sql = "delete from GALLERY where GALLERY_NUM=?";
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
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
					if(con!=null)con.close();
				}catch(Exception ex) {}
			}
			return false;
		}
		
		//갤러리 등록 취소시 오더테이블 갤러리여부 0으로 업데이트.
		public boolean remove_updateGallery(int num) throws SQLException{
			String sql=null;
			int customNum = 0;
			try{
				con = ds.getConnection();
				
				sql = "select GALLERY_CUSTOM_NUM from GALLERY where GALLERY_NUM = ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);	
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					customNum = rs.getInt(1);
				}
				
				
				sql="update CUSTOM_ORDER_2 set ORDER_CUSTOM_GALLERY=? where ORDER_CUSTOM_NUM=?";
				
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, 0);	
				pstmt.setInt(2, customNum);	
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
		
		
		//계좌번호체크
		public int confirmNum(String orderNumber) throws SQLException{
			String sql=null;
			int x=-1;
			
			try{
				con = ds.getConnection();
				sql="select CADE_NUM from ORDER_CADE where CADE_NUM=? ";
				
				pstmt=con.prepareStatement(sql); 
				pstmt.setString(1, orderNumber);
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
		
		
		//주문번호얻어오기
		public int getnum(String id) throws SQLException{
			OrderCustomBean ocb=null;
			String sql=null;
			int getnnum=0;
			try{
				con = ds.getConnection();
				sql="select max(GALLERY_ORDER_NUM) from GALLERY_ORDER where GALLERY_ORDER_ID=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();  
				
				
			if(rs.next()) {
				getnnum = rs.getInt(1);
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
			
			return getnnum;
			
		}
		
		//결제상태 업데이트
		public int updateOrder3(int num) throws SQLException{
			String sql=null;
			int nnu=0;
			
			try{
				con = ds.getConnection();
				sql="update GALLERY_ORDER set GALLERY_ORDER_TRADE_PAYER=? where GALLERY_ORDER_NUM=?";
				
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, 1);
				pstmt.setInt(2, num);	
				pstmt.executeUpdate();
				nnu=1;
				return nnu;
			}catch(Exception e){
				e.printStackTrace();
			}	finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				}catch(Exception ex) {}
			}
			return nnu;
		}
		
		
		
		
		
		//get포인트
		//Point
	public int getPoint(String id) throws SQLException{
		String sql=null;
		int x=-1;
		int count=0;
		
		try{
			con = ds.getConnection();
			sql="select max(POINT_MAXNUM) from POINT where POINT_ID=? ";
			
			pstmt=con.prepareStatement(sql); 
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			
			if(rs.next()){
				x=rs.getInt(1);
			}
			
			
			sql="select POINT_SUM from POINT where POINT_MAXNUM=? ";
			pstmt=con.prepareStatement(sql); 
			pstmt.setInt(1, x);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				count=rs.getInt(1);
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
		
		return count;
	}
		
		
		
		
	//point 누적
		//===============================
		public void insertPoint(String id, int price, float point_pu, int point_ch, int num) throws SQLException{
			
			String sql="select max(POINT_MAXNUM) from POINT where POINT_ID = ?";
			boolean result = false;
			int maxnum=0;
			int ordernum=0;
			int nnnum =0;
			int sum=0;
			int sum2=0;
			int Pointtype=1;
			String deId = null;
			
			try{ 
				con = ds.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				rs.next();
				nnnum = rs.getInt(1);
				maxnum=rs.getInt(1)+1;
				
				
			sql="insert into POINT values "+
					"(?,sysdate,?,?,?,?,?,?,?)";
				
				
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				/*pstmt.setDate(2, sysdate);*/
				pstmt.setInt(2, Pointtype);
				pstmt.setInt(3, price);
				pstmt.setFloat(4, point_pu);
				pstmt.setInt(5, point_ch);
				pstmt.setDouble(6, sum);
				pstmt.setInt(7, num);
				pstmt.setInt(8, maxnum);
				pstmt.executeUpdate();
					
				maxnum = maxnum-1;
					
				sql = "select POINT_SUM from POINT where POINT_MAXNUM = ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, maxnum);
				rs=pstmt.executeQuery();
				rs.next();
				sum = rs.getInt(1);
				sum = sum + (int)point_pu;
				sum2 = sum - point_ch;
				
				maxnum = maxnum+1;
				
				sql = "update POINT set POINT_SUM=? where POINT_MAXNUM=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, sum2);
				pstmt.setInt(2, maxnum);
				pstmt.executeUpdate();
				
				
				
				
				
				//판매자 Point DB에 인설트
				//1.디자이너 아이디 얻어오기
				sql = "select ORDER_CUSTOM_ID from CUSTOM_ORDER_2 where ORDER_CUSTOM_NUM = ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs=pstmt.executeQuery();
				rs.next();
				deId = rs.getString(1);
				
				sum = price - point_ch;
				float sum3 = (float) ((float)sum*0.01);
				
				
				sql="insert into POINT_SALE values "+
						"(?,?,?,?,sysdate)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, deId);
				pstmt.setString(2, id);
				pstmt.setInt(3, num);
				pstmt.setFloat(4, sum3);
				pstmt.executeUpdate();
				
				  
				result = true;
				ordernum=num;
				
			}catch(Exception e){
				e.printStackTrace(); 
			}finally{
				try{
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				}catch(Exception ex) {}
			}
			
		}
		
		
		
		
		//main===============================	

	public List<GalleryBean> getMainList() {
		String board_list_sql = "select * from "+
				"(select rownum rnum,GALLERY_NUM,GALLERY_CUSTOM_ID,GALLERY_CUSTOM13,"+
				"GALLERY_CUSTOM1,GALLERY_CUSTOM2,GALLERY_CUSTOM3,"+
				"GALLERY_CUSTOM4,GALLERY_CUSTOM5,GALLERY_CUSTOM6,"+
				"GALLERY_CUSTOM7,GALLERY_CUSTOM8,GALLERY_CUSTOM9,"+
				"GALLERY_CUSTOM10,GALLERY_CUSTOM11,GALLERY_CUSTOM12,"+
				"GALLERY_RE_REF,GALLERY_RE_LEV,"+
				"GALLERY_RE_SEQ,GALLERY_READCOUNT,GALLERY_DATE from "+
				"(select * from GALLERY order by GALLERY_RE_LEV desc )) "+
				"where rnum<=5";
		
		List<GalleryBean> list = new ArrayList<GalleryBean>();
		 
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
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
	
		
		
		
		
		
		
	
}
