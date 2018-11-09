package net.custom.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.member.db.MemberBean;


public class OrderCustomDAO {
	DataSource ds;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null, rs1=null;
	private java.sql.Date sysdate;
	
	public OrderCustomDAO() {
		try{
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	//주문
	public boolean insertOrderCustom(OrderCustomBean ocb) throws SQLException{
		
		
		String sql="select max(ORDER_CUSTOM_NUM) from CUSTOM_ORDER_2";
		boolean result = false;
		int num=0;
		int ordernum=0;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			num=rs.getInt(1)+1;
			sql="insert into CUSTOM_ORDER_2 values "+
				"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, ocb.getORDER_CUSTOM1());
			pstmt.setInt(3, ocb.getORDER_CUSTOM2());
			
			pstmt.setString(4, ocb.getORDER_CUSTOM3());
			
			pstmt.setInt(5, ocb.getORDER_CUSTOM4());
			pstmt.setInt(6, ocb.getORDER_CUSTOM5());
			pstmt.setInt(7, ocb.getORDER_CUSTOM6());
			pstmt.setInt(8, ocb.getORDER_CUSTOM7());
			pstmt.setInt(9, ocb.getORDER_CUSTOM8());
			pstmt.setInt(10, ocb.getORDER_CUSTOM9());
			pstmt.setInt(11, ocb.getORDER_CUSTOM10());
			pstmt.setInt(12, ocb.getORDER_CUSTOM11());
			
			pstmt.setString(13, ocb.getORDER_CUSTOM12());
			pstmt.setString(14, ocb.getORDER_CUSTOM13());
			pstmt.setString(15, ocb.getORDER_CUSTOM_ID());
			pstmt.setString(16, ocb.getORDER_CUSTOM_RECEIVE_NAME());
			
			pstmt.setInt(17, ocb.getORDER_CUSTOM_ZIPCODE1());
			pstmt.setInt(18, ocb.getORDER_CUSTOM_ZIPCODE2());
			
			pstmt.setString(19, ocb.getORDER_CUSTOM_RECEIVE_ADDR1());
			pstmt.setString(20, ocb.getORDER_CUSTOM_RECEIVE_ADDR2());
			
			pstmt.setInt(21, ocb.getORDER_CUSTOM_RECEIVE_PHONE());
			pstmt.setInt(22, ocb.getORDER_CUSTOM_RECEIVE_MOBILE());
			
			pstmt.setString(23, ocb.getORDER_CUSTOM_MEMO());
			pstmt.setString(24, ocb.getORDER_CUSTOM_TRADE_TYPE());
			
			pstmt.setTimestamp(25, ocb.getORDER_CUSTOM_TRADE_DATE());
			pstmt.setInt(26, ocb.getORDER_CUSTOM_TRADE_PAYER());
			pstmt.setInt(27, ocb.getORDER_CUSTOM_GALLERY()); 
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
	
	
	//주문내역2에 불러오기
	public OrderCustomBean getOrderCustom(int getnum){
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
	
	
	
	//주문번호얻어오기
	public int getnum(String id) throws SQLException{
		OrderCustomBean ocb=null;
		String sql=null;
		int getnnum=0;
		try{
			con = ds.getConnection();
			sql="select max(ORDER_CUSTOM_NUM) from CUSTOM_ORDER_2 where ORDER_CUSTOM_ID=?";
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
	 
	
	//주문2
	public void updateOrder(OrderCustomBean ocb) throws SQLException{
		String sql=null;
		
		try{
			con = ds.getConnection();
			sql="update CUSTOM_ORDER_2 set ORDER_CUSTOM_RECEIVE_NAME=?,ORDER_CUSTOM_ZIPCODE1=?,"+
			"ORDER_CUSTOM_ZIPCODE2=?,ORDER_CUSTOM_RECEIVE_ADDR1=?,ORDER_CUSTOM_RECEIVE_ADDR2=?,"+
			"ORDER_CUSTOM_RECEIVE_PHONE=?,ORDER_CUSTOM_RECEIVE_MOBILE=?,ORDER_CUSTOM_MEMO=?,"+
			"ORDER_CUSTOM_TRADE_TYPE=? where ORDER_CUSTOM_NUM=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ocb.getORDER_CUSTOM_RECEIVE_NAME());
			pstmt.setInt(2, ocb.getORDER_CUSTOM_ZIPCODE1());
			pstmt.setInt(3, ocb.getORDER_CUSTOM_ZIPCODE2());
			pstmt.setString(4, ocb.getORDER_CUSTOM_RECEIVE_ADDR1());
			pstmt.setString(5, ocb.getORDER_CUSTOM_RECEIVE_ADDR2());
			pstmt.setInt(6, ocb.getORDER_CUSTOM_RECEIVE_PHONE());
			pstmt.setInt(7, ocb.getORDER_CUSTOM_RECEIVE_MOBILE());
			pstmt.setString(8, ocb.getORDER_CUSTOM_MEMO());
			pstmt.setString(9, ocb.getORDER_CUSTOM_TRADE_TYPE());
			pstmt.setInt(10, ocb.getORDER_CUSTOM_NUM());	
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
	
	//결제상태 업데이트
	public int updateOrder2(OrderCustomBean ocb) throws SQLException{
		String sql=null;
		int nnu=0;
		
		try{
			con = ds.getConnection();
			sql="update CUSTOM_ORDER_2 set ORDER_CUSTOM_TRADE_PAYER=? where ORDER_CUSTOM_NUM=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, ocb.getORDER_CUSTOM_TRADE_PAYER());
			pstmt.setInt(2, ocb.getORDER_CUSTOM_NUM());	
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
	
	
	
	
	public OrderCustomBean getDetail(int no) {   // 해당 데이터에 대한 테이블을 읽어오기 위한 메소드
		   
		   Connection con = null;
		   OrderCustomBean bean = new OrderCustomBean();
		   String query = "select * from CUSTOM_ORDER where ORDER_CUSTOM_NUM = ?";
		   
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   
		   try {
			   con = ds.getConnection();

		      pstmt = con.prepareStatement(query);   // 괄호 안에 명령문을 넣는다.

		      pstmt.setInt(1, no);
		      rs = pstmt.executeQuery();
		      
		      while(rs.next()) {   // 데이터를 꺼내와서 변수에 담음
		         
		         bean.setORDER_CUSTOM_NUM(rs.getInt("ORDER_CUSTOM_NUM"));   // DTO에 값을보냄?
		         bean.setORDER_CUSTOM1(rs.getInt("ORDER_CUSTOM1"));
		         bean.setORDER_CUSTOM2(rs.getInt("ORDER_CUSTOM2"));
		         bean.setORDER_CUSTOM3(rs.getString("ORDER_CUSTOM3"));
		         bean.setORDER_CUSTOM4(rs.getInt("ORDER_CUSTOM4"));
		         bean.setORDER_CUSTOM5(rs.getInt("ORDER_CUSTOM5"));
		         bean.setORDER_CUSTOM6(rs.getInt("ORDER_CUSTOM6"));
		         bean.setORDER_CUSTOM7(rs.getInt("ORDER_CUSTOM7"));
		         bean.setORDER_CUSTOM8(rs.getInt("ORDER_CUSTOM8"));
		         bean.setORDER_CUSTOM9(rs.getInt("ORDER_CUSTOM9"));
		         bean.setORDER_CUSTOM10(rs.getInt("ORDER_CUSTOM10"));
		         bean.setORDER_CUSTOM11(rs.getInt("ORDER_CUSTOM11"));
		         bean.setORDER_CUSTOM12(rs.getString("ORDER_CUSTOM12"));
		         bean.setORDER_CUSTOM13(rs.getString("ORDER_CUSTOM13"));
		         bean.setORDER_CUSTOM_ID(rs.getString("ORDER_CUSTOM_ID"));
		         bean.setORDER_CUSTOM_RECEIVE_NAME(rs.getString("ORDER_CUSTOM_RECEIVE_NAME"));
		         bean.setORDER_CUSTOM_ZIPCODE1(rs.getInt("ORDER_CUSTOM_ZIPCODE1"));
		         bean.setORDER_CUSTOM_ZIPCODE2(rs.getInt("ORDER_CUSTOM_ZIPCODE2"));
		         bean.setORDER_CUSTOM_RECEIVE_ADDR1(rs.getString("ORDER_CUSTOM_RECEIVE_ADDR1"));
		         bean.setORDER_CUSTOM_RECEIVE_ADDR2(rs.getString("ORDER_CUSTOM_RECEIVE_ADDR2"));
		         bean.setORDER_CUSTOM_RECEIVE_PHONE(rs.getInt("ORDER_CUSTOM_RECEIVE_PHONE"));
		         bean.setORDER_CUSTOM_RECEIVE_MOBILE(rs.getInt("ORDER_CUSTOM_RECEIVE_MOBILE"));
		         bean.setORDER_CUSTOM_MEMO(rs.getString("ORDER_CUSTOM_MEMO"));
		         bean.setORDER_CUSTOM_TRADE_TYPE(rs.getString("ORDER_CUSTOM_TRADE_TYPE"));   // 주문상태
		         bean.setORDER_CUSTOM_TRADE_DATE(rs.getTimestamp("ORDER_CUSTOM_TRADE_DATE"));
		         bean.setORDER_CUSTOM_TRADE_PAYER(rs.getInt("ORDER_CUSTOM_TRADE_PAYER"));
		         
		         
		      }
		      return bean;
		      
		   } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		      System.out.println("DB 연결 실패 : " + e);
		      
		   } finally {
		      try {
		         if(rs != null)   {rs.close();}
		         if(pstmt != null) {pstmt.close();}
		         if(con != null) {con.close();}
		      } catch (SQLException e) {
		         System.out.println(e.getMessage());
		      }
		   }
		   return null;
		}
	
	
	
	//결제상태반환
	public int getOrderType(int num) {
		int getOrderType = 0;
		
		
		try {  
			con = ds.getConnection();
			pstmt = con.prepareStatement("select ORDER_CUSTOM_TRADE_PAYER from CUSTOM_ORDER_2 where ORDER_CUSTOM_NUM = ? ");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				getOrderType = rs.getInt(1);
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
		return getOrderType;
	}
	
	
	
	
	//point
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
	
	
	
}
