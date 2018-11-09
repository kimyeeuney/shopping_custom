package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.board.db.BoardDTO;
import net.custom.db.OrderCustomBean;
import net.gallery.db.GalleryBean;

public class MemberDAO {
	DataSource ds;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public MemberDAO() {
		try{
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public boolean insertMember(MemberBean mb) throws SQLException{
		String sql=null;
		boolean result = false;
		try{
			con = ds.getConnection();
			sql="insert into member values "+
				"(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mb.getMEMBER_ID());
			pstmt.setString(2, mb.getMEMBER_PW());
			pstmt.setString(3, mb.getMEMBER_NAME());
			pstmt.setInt(4, mb.getMEMBER_JUMIN1());
			pstmt.setInt(5, mb.getMEMBER_JUMIN2());
			pstmt.setString(6, mb.getMEMBER_EMAIL());
			pstmt.setString(7, mb.getMEMBER_EMAIL_GET());
			pstmt.setString(8, mb.getMEMBER_MOBILE());
			pstmt.setString(9, mb.getMEMBER_PHONE());
			pstmt.setString(10, mb.getMEMBER_ZIPCODE());
			pstmt.setString(11, mb.getMEMBER_ADDR1());
			pstmt.setString(12, mb.getMEMBER_ADDR2());
			pstmt.setInt(13, mb.getMEMBER_ADMIN());
			pstmt.setTimestamp(14, mb.getMEMBER_JOIN_DATE());
			pstmt.executeUpdate();
			
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return result;
	}
	
	public int userCheck(String id, String pw) throws SQLException{
		String sql=null;
		int x=-1;
		
		try{
			con = ds.getConnection();
			sql="select MEMBER_PW from member where MEMBER_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String memberpw=rs.getString("MEMBER_PW");
				
				if(memberpw.equals(pw)){
					x=1;
				}else{
					x=0;
				}
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
	
	public int confirmId(String id) throws SQLException{
		String sql=null;
		int x=-1;
		
		try{
			con = ds.getConnection();
			sql="select MEMBER_ID from member where MEMBER_ID=? ";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
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
	
	public MemberBean getMember(String id) throws SQLException{
		MemberBean member=null;
		String sql=null;
		
		try{
			con = ds.getConnection();
			sql="select * from member where MEMBER_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				member=new MemberBean();
				
				member.setMEMBER_ID(rs.getString("MEMBER_ID"));
				member.setMEMBER_NAME(rs.getString("MEMBER_NAME"));
				member.setMEMBER_JUMIN1(rs.getInt("MEMBER_JUMIN1"));
				member.setMEMBER_JUMIN2(rs.getInt("MEMBER_JUMIN2"));
				member.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL"));
				member.setMEMBER_EMAIL_GET(rs.getString("MEMBER_EMAIL_GET"));
				member.setMEMBER_MOBILE(rs.getString("MEMBER_MOBILE"));
				member.setMEMBER_PHONE(rs.getString("MEMBER_PHONE"));
				member.setMEMBER_ZIPCODE(rs.getString("MEMBER_ZIPCODE"));
				member.setMEMBER_ADDR1(rs.getString("MEMBER_ADDR1"));
				member.setMEMBER_ADDR2(rs.getString("MEMBER_ADDR2"));
				
				
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
		
		return member;
	}
	
	public void updateMember(MemberBean mb) throws SQLException{
		String sql=null;
		
		try{
			con = ds.getConnection();
			sql="update member set MEMBER_PW=?,MEMBER_NAME=?,"+
			"MEMBER_EMAIL=?,MEMBER_EMAIL_GET=?,MEMBER_MOBILE=?,"+
			"MEMBER_PHONE=?,MEMBER_ZIPCODE=?,MEMBER_ADDR1=?,"+
			"MEMBER_ADDR2=? where MEMBER_ID=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mb.getMEMBER_PW());
			pstmt.setString(2, mb.getMEMBER_NAME());
			pstmt.setString(3, mb.getMEMBER_EMAIL());
			pstmt.setString(4, mb.getMEMBER_EMAIL_GET());
			pstmt.setString(5, mb.getMEMBER_MOBILE());
			pstmt.setString(6, mb.getMEMBER_PHONE());
			pstmt.setString(7, mb.getMEMBER_ZIPCODE());
			pstmt.setString(8, mb.getMEMBER_ADDR1());
			pstmt.setString(9, mb.getMEMBER_ADDR2());
			pstmt.setString(10, mb.getMEMBER_ID());			
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
	
	public int deleteMember(String id, String pw) throws SQLException{
		String sql=null;
		int x=-1;
		
		try{
			con = ds.getConnection();
			sql="select MEMBER_PW from member where MEMBER_ID=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				String memberpw=rs.getString("MEMBER_PW");
				if(memberpw.equals(pw)){
					sql="delete from member where MEMBER_ID=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					x=1;
				}else{
					x=0;
				}
				
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
	
	public MemberBean findId(String name, String jumin1, String jumin2)
	throws SQLException{
		String sql=null;
		MemberBean member=null;
		
		try{
			con = ds.getConnection();
			sql="select MEMBER_ID, MEMBER_PW, MEMBER_JUMIN1,"+
				"MEMBER_JUMIN2 from member where MEMBER_NAME=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				String memberjumin1=rs.getString("MEMBER_JUMIN1");
				String memberjumin2=rs.getString("MEMBER_JUMIN2");
				
				if(memberjumin1.equals(jumin1) && 
						memberjumin2.equals(jumin2)){
					member = new MemberBean();
					member.setMEMBER_ID(rs.getString("MEMBER_ID"));
					member.setMEMBER_PW(rs.getString("MEMBER_PW"));
					
				}
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
		
		return member;
	}
	
	public boolean isAdmin(String id){
		String sql="select MEMBER_ADMIN from MEMBER where MEMBER_ID=?";
		int member_admin=0;
		boolean result = false;
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			rs.next();
			
			member_admin=rs.getInt("MEMBER_ADMIN");
			
			if(member_admin==1){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return result;
	}
	
	public List searchZipcode(String searchdong){
		String sql="select * from zipcode where dong like ?";
		List zipcodeList=new ArrayList();
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchdong+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String sido=rs.getString("sido");
				String gugun=rs.getString("gugun");
				String dong=rs.getString("dong");  
				String ri=rs.getString("ri"); 
				String bunji=rs.getString("bunji");
				if(ri == null) ri="";
				if(bunji == null) bunji="";
				
				String zipcode=rs.getString("zipcode");
				String addr=sido+ " "+gugun+ " "+dong+ " "+ri+ " "+bunji;
				
				zipcodeList.add(zipcode+","+addr);
			}
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return zipcodeList;
	}
	
	
	
	
	
	
	//회원 리스트 보기     
    public List getMemberList(){ 
        String sql="SELECT * FROM BOARDMEMBER"; 
        List memberlist=new ArrayList(); 
         
        try{ 
            pstmt=con.prepareStatement(sql); 
            rs=pstmt.executeQuery(); 
             
            while(rs.next()){ 
                MemberBean mb=new MemberBean(); 
                mb.setMEMBER_ID(rs.getString("MEMBER_ID")); 
                mb.setMEMBER_PW(rs.getString("MEMBER_PW")); 
                mb.setMEMBER_NAME(rs.getString("MEMBER_NAME")); 
                /*mb.setMEMBER_AGE(rs.getInt("MEMBER_AGE")); 
                mb.setMEMBER_GENDER(rs.getString("MEMBER_GENDER"));*/ 
                mb.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL")); 
                 
                memberlist.add(mb); 
            } 
             
            return memberlist; 
        }catch(Exception ex){ 
            System.out.println("getDeatilMember 에러: " + ex);             
        }finally{ 
            if(rs!=null) try{rs.close();}catch(SQLException ex){} 
            if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){} 
        } 
        return null; 
    } 
     
    //해당 회원 정보 보기 
    public MemberBean getDetailMember(String id){ 
        String sql="SELECT * FROM BOARDMEMBER WHERE MEMBER_ID=?"; 
         
        try{ 
            pstmt=con.prepareStatement(sql); 
            pstmt.setString(1, id); 
            rs=pstmt.executeQuery(); 
            rs.next(); 
             
            MemberBean mb=new MemberBean(); 
            mb.setMEMBER_ID(rs.getString("MEMBER_ID")); 
            mb.setMEMBER_PW(rs.getString("MEMBER_PW")); 
            mb.setMEMBER_NAME(rs.getString("MEMBER_NAME")); 
          /*  mb.setMEMBER_AGE(rs.getInt("MEMBER_AGE")); 
            mb.setMEMBER_GENDER(rs.getString("MEMBER_GENDER")); */
            mb.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL")); 
             
            return mb; 
        }catch(Exception ex){ 
            System.out.println("getDeatilMember 에러: " + ex);             
        }finally{ 
            if(rs!=null) try{rs.close();}catch(SQLException ex){} 
            if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){} 
        } 
         
        return null; 
    }
	
    
    
    
    
    
    //----------------------------------------------------------------------------------//
	// Member Order List - ID / List
	
    
  //컬럼수
  	public int getListCount(String id) {
  		int count = 0;
  		
  		
  		try {
  			con = ds.getConnection();
  			pstmt = con.prepareStatement("select count(*) from CUSTOM_ORDER_2 where ORDER_CUSTOM_ID=?");
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
  	public List<OrderCustomBean> getMemberOrderList(int page, int limit, String id) {
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
  				"where rnum>=? and rnum<=? and ORDER_CUSTOM_ID=?";
  		System.out.println(id);
  		List<OrderCustomBean> list = new ArrayList<OrderCustomBean>();
  		
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
  	
  	
 
  	
  	
 	
 	
 	
 	/*//where team in("cow", "pig"); 
 	// 글 목록 보기
   	public List<OrderCustomBean> getMemberOrderList2(int page, int limit, String id) {
   		String board_list_sql = "select * from CUSTOM_ORDER_2"+
   				"where ORDER_CUSTOM_ID in(?)";
   		System.out.println(id);
   		List<OrderCustomBean> list = new ArrayList<OrderCustomBean>();
   		
   		int startrow = (page-1)*10 + 1;
   		int endrow = startrow + limit - 1;
   		
   		try {
   			con = ds.getConnection(); 
   			pstmt = con.prepareStatement(board_list_sql);
   			pstmt.setString(1, id);
   			rs = pstmt.executeQuery();
   			
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
   	
   	*/
   	
   	
   	//============delivery================
   
   	
  //컬럼수
  	public int getDeCount(String id) {
  		int count = 0;
  		
  		
  		try {
  			con = ds.getConnection();
  			pstmt = con.prepareStatement("select count(*) from CUSTOM_ORDER_2 where ORDER_CUSTOM_ID=? and  ORDER_CUSTOM_TRADE_PAYER = ?");
  			pstmt.setString(1, id);
  			pstmt.setInt(2, 1);
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
  	
  	// 글 목록 보기-
  	public List<OrderCustomBean> getDeliveryList(int page, int limit, String id) {
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
  				"(select * from CUSTOM_ORDER_2 order by ORDER_CUSTOM_NUM desc )) "+
  				"where rnum>=? and rnum<=? and ORDER_CUSTOM_ID=? and ORDER_CUSTOM_TRADE_PAYER=? ";
  		  
  		List<OrderCustomBean> list = new ArrayList();
  		int startrow = (page-1)*10 + 1;  
  		int endrow = startrow + limit - 1; 
  		 
  		try {
  			con = ds.getConnection();
  			pstmt = con.prepareStatement(board_list_sql);
  			pstmt.setInt(1, startrow);
  			pstmt.setInt(2, endrow);
  			pstmt.setString(3, id);
  			pstmt.setInt(4, 1);
  			rs = pstmt.executeQuery();
  			
  			while(rs.next()) {
  				OrderCustomBean ocb = new OrderCustomBean();
  				
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
				
				
  				list.add(ocb);
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
  	
  	
  	
  	
  //point컬럼수
  		public int getPointListCount(String id) {
  			int count = 0;
  			
  			
  			try {
  				con = ds.getConnection();
  				pstmt = con.prepareStatement("select count(*) from POINT where POINT_ID = ?");
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
  		public List<MemberPointBean> getPoint(int page, int limit, String id) {
  			String board_list_sql = "select * from "+
  					"(select rownum rnum,POINT_ID,POINT_DATE,POINT_TYPE,"+
  					"POINT_PRICE,POINT_PLUS,POINT_DEDUCTION,"+
  					"POINT_SUM,POINT_GOODS_NUM,POINT_MAXNUM from "+
  					"(select * from POINT order by POINT_MAXNUM desc)) "+
  					"where rnum>=? and rnum<=? and POINT_ID = ?";
  			
  			List<MemberPointBean> list = new ArrayList<MemberPointBean>();
  			 
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
  					MemberPointBean gb = new MemberPointBean();
  					
  					
  					gb.setPOINT_ID(rs.getString("POINT_ID"));
  					gb.setPOINT_DATE(rs.getDate("POINT_DATE"));
  					gb.setPOINT_TYPE(rs.getInt("POINT_TYPE"));
  					gb.setPOINT_PRICE(rs.getInt("POINT_PRICE"));
  					gb.setPOINT_PLUS(rs.getInt("POINT_PLUS"));
  					gb.setPOINT_DEDUCTION(rs.getInt("POINT_DEDUCTION"));
  					gb.setPOINT_SUM(rs.getInt("POINT_SUM"));
  					gb.setPOINT_GOODS_NUM(rs.getInt("POINT_GOODS_NUM"));
  					gb.setPOINT_MAXNUM(rs.getInt("POINT_MAXNUM"));
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
  	
  	//point
  		public float getMaxPoint(String id) {
  			int count = 0;
  			float count2=0;
  			
  			try {
  				con = ds.getConnection();
  				pstmt = con.prepareStatement("select max(POINT_MAXNUM) from POINT where POINT_ID = ?");
  				pstmt.setString(1, id);
  				rs = pstmt.executeQuery();
  				
  				if(rs.next()) {
  					count = rs.getInt(1);
  				}
  				
  				
  				pstmt = con.prepareStatement("select POINT_SUM from POINT where POINT_MAXNUM = ?");
  				pstmt.setInt(1, count);
  				rs = pstmt.executeQuery();
  				
  				
  				if(rs.next()) {
  					count2 = rs.getInt(1);
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
  			return count2;
  		}
  	
  	
  	
  	//판매자센터 오픈여부
  		public int centerOpenCheck(String id) throws SQLException{
  			String sql=null;
  			int x=-1;
  			int num=1;
  			
  			try{
  				con = ds.getConnection();
  				sql="select ORDER_CUSTOM_GALLERY from CUSTOM_ORDER_2 where ORDER_CUSTOM_ID=? and ORDER_CUSTOM_GALLERY= ?";
  				
  				pstmt=con.prepareStatement(sql);
  				pstmt.setString(1, id);
  				pstmt.setInt(2, num);
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
  	
  		
  	
  	// 글 내용 보기(세부항목).
  			public OrderCustomBean getDetailOrder(int num) {
  				OrderCustomBean ocb = null;
  				String sql = "select * from CUSTOM_ORDER_2 where ORDER_CUSTOM_NUM = ?";
  				
  				try {
  					con = ds.getConnection();
  					pstmt = con.prepareStatement(sql);
  					pstmt.setInt(1, num);
  					
  					rs = pstmt.executeQuery();  
  					
  					if(rs.next()) {
  						ocb = new OrderCustomBean();
  						
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
