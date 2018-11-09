package net.search.db;

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

import net.gallery.db.GalleryBean;

public class SearchDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public SearchDAO() {
		try {
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//컬럼수
		public int getListCount(String search_height, String search_nek, String search_Upper, 
				String search_arm, String search_B, String search_H, String search_C) {
			int count = 0;
			int height_start=0;
			int height_final=0;
			int upper_start=0;
			int upper_final=0;
			int arm_start=0;
			int arm_final=0;
			int B_start=0;
			int B_final=0;
			int H_start=0;
			int H_final=0;
			
			
			
			System.out.println(search_height);
			if(search_height.equals("149")){
				height_start = 1;
				height_final = 149;
			}else if(search_height.equals("150")){
				height_start = 150;  
				height_final = 159;
			}else if(search_height.equals("160")){
				height_start = 160;
				height_final = 169;
			}else if(search_height.equals("170")){
				height_start = 170;
				height_final = 179;
			}else if(search_height.equals("180")){
				height_start = 180;
				height_final = 189;
			}else if(search_height.equals("190")){
				height_start = 190;
				height_final = 10000;
			}else {
				height_start=0;
				height_final=0;
			}
			System.out.println(height_start);
			System.out.println(height_final);
			
			
			//총기장
			System.out.println(search_Upper);
			if(search_Upper.equals("39")){
				upper_start = 1;
				upper_final = 39;
			}else if(search_Upper.equals("40")){
				upper_start = 40;  
				upper_final = 49;
			}else if(search_Upper.equals("50")){
				upper_start = 50;
				upper_final = 59;
			}else if(search_height.equals("60")){
				upper_start = 60;
				upper_final = 69;
			}else {
				upper_start=0;
				upper_final=0;
			}
			System.out.println(upper_start);
			System.out.println(upper_final);
			
			
			//팔 : 양 팔 통합으로 검색
			System.out.println(search_arm);
			if(search_arm.equals("19")){
				arm_start = 1;
				arm_final = 19;
			}else if(search_arm.equals("20")){
				arm_start = 20;  
				arm_final = 1000;
			}else {
				arm_start=0;
				arm_final=0;
			}
			System.out.println(arm_start);
			System.out.println(arm_final);
			
			
			//가슴둘레
			System.out.println(search_B);
			if(search_B.equals("44")){
				B_start = 1;
				B_final = 44;
			}else if(search_B.equals("45")){
				B_start = 45;  
				B_final = 1000;
			}else {
				B_start=0;
				B_final=0;
			}
			System.out.println(B_start);
			System.out.println(B_final);
			
			
			//허리둘레
			System.out.println(search_H);
			if(search_H.equals("39")){
				H_start = 1;
				H_final = 39;
			}else if(search_H.equals("40")){
				H_start = 40;  
				H_final = 1000;
			}else {
				H_start=0;
				H_final=0;
			}
			System.out.println(H_start);
			System.out.println(H_final);
			
			
			
			
			
			String sql="select count(*) from GALLERY where "+
						"GALLERY_CUSTOM1>=? and GALLERY_CUSTOM1<=? and "+
						"GALLERY_CUSTOM3 like ? and "+
						"GALLERY_CUSTOM11>=? and GALLERY_CUSTOM11<=? and " + 
						"GALLERY_CUSTOM5>=? and GALLERY_CUSTOM5<=? and " + 
						"GALLERY_CUSTOM7>=? and GALLERY_CUSTOM7<=? and " +
						"GALLERY_CUSTOM9>=? and GALLERY_CUSTOM9<=? and " +
						"GALLERY_CUSTOM10>=? and GALLERY_CUSTOM10<=? and " +
						"GALLERY_CUSTOM12 like ? ";
			
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, height_start);
				pstmt.setInt(2, height_final);
				pstmt.setString(3, "%"+search_nek+"%");
				pstmt.setInt(4, upper_start);
				pstmt.setInt(5, upper_final);
				pstmt.setInt(6, arm_start);
				pstmt.setInt(7, arm_final);
				pstmt.setInt(8, arm_start);
				pstmt.setInt(9, arm_final);
				pstmt.setInt(10, B_start);
				pstmt.setInt(11, B_final);
				pstmt.setInt(12, H_start);
				pstmt.setInt(13, H_final);
				pstmt.setString(14, search_C);
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
	
		
		
		
		
		/*상세검색*/
		public List<GalleryBean> detailsearch(String search_height, String search_nek, String search_Upper, 
				int page, int limit, String search_arm, String search_B, String search_H, String search_C){
			/*String search_height = null;*/
			int height_start=0;
			int height_final=0;
			int upper_start=0;
			int upper_final=0;
			int arm_start=0;
			int arm_final=0;
			int B_start=0;
			int B_final=0;
			int H_start=0;
			int H_final=0;
			
			
			
			System.out.println(search_height);
			if(search_height.equals("149")){
				height_start = 1;
				height_final = 149;
			}else if(search_height.equals("150")){
				height_start = 150;  
				height_final = 159;
			}else if(search_height.equals("160")){
				height_start = 160;
				height_final = 169;
			}else if(search_height.equals("170")){
				height_start = 170;
				height_final = 179;
			}else if(search_height.equals("180")){
				height_start = 180;
				height_final = 189;
			}else if(search_height.equals("190")){
				height_start = 190;
				height_final = 10000;
			}else {
				height_start=0;
				height_final=0;
			}
			System.out.println(height_start);
			System.out.println(height_final);
			
			
			//총기장
			System.out.println(search_Upper);
			if(search_Upper.equals("39")){
				upper_start = 1;
				upper_final = 39;
			}else if(search_Upper.equals("40")){
				upper_start = 40;  
				upper_final = 49;
			}else if(search_Upper.equals("50")){
				upper_start = 50;
				upper_final = 59;
			}else if(search_height.equals("60")){
				upper_start = 60;
				upper_final = 69;
			}else {
				upper_start=0;
				upper_final=0;
			}
			System.out.println(upper_start);
			System.out.println(upper_final);
			
			
			//팔 : 양 팔 통합으로 검색
			System.out.println(search_arm);
			if(search_arm.equals("19")){
				arm_start = 1;
				arm_final = 19;
			}else if(search_arm.equals("20")){
				arm_start = 20;  
				arm_final = 1000;
			}else {
				arm_start=0;
				arm_final=0;
			}
			System.out.println(arm_start);
			System.out.println(arm_final);
			
			
			//가슴둘레
			System.out.println(search_B);
			if(search_B.equals("44")){
				B_start = 1;
				B_final = 44;
			}else if(search_B.equals("45")){
				B_start = 45;  
				B_final = 1000;
			}else {
				B_start=0;
				B_final=0;
			}
			System.out.println(B_start);
			System.out.println(B_final);
			
			
			//허리둘레
			System.out.println(search_H);
			if(search_H.equals("39")){
				H_start = 1;
				H_final = 39;
			}else if(search_H.equals("40")){
				H_start = 40;  
				H_final = 1000;
			}else {
				H_start=0;
				H_final=0;
			}
			System.out.println(H_start);
			System.out.println(H_final);
			
			
			
			
			
			String sql="select * from "+
							"(select rownum rnum, GALLERY_NUM, GALLERY_CUSTOM_NUM, GALLERY_CUSTOM_ID,"+
							"GALLERY_CUSTOM13,"+
							"GALLERY_CUSTOM1, GALLERY_CUSTOM2, GALLERY_CUSTOM3, "+
							"GALLERY_CUSTOM4, GALLERY_CUSTOM5, GALLERY_CUSTOM6, "+
							"GALLERY_CUSTOM7, GALLERY_CUSTOM8, GALLERY_CUSTOM9, "+
							"GALLERY_CUSTOM10, GALLERY_CUSTOM11, GALLERY_CUSTOM12, "+
							"GALLERY_RE_REF, GALLERY_RE_LEV, GALLERY_RE_SEQ, "+
							"GALLERY_READCOUNT, GALLERY_DATE from "+
							"(select * from GALLERY order by GALLERY_NUM desc, GALLERY_RE_SEQ asc)) "+
							"where rnum>=? and rnum<=? and "+
							"GALLERY_CUSTOM1>=? and GALLERY_CUSTOM1<=? and "+
							"GALLERY_CUSTOM3 like ? and "+
							"GALLERY_CUSTOM11>=? and GALLERY_CUSTOM11<=? and " +
							"GALLERY_CUSTOM5>=? and GALLERY_CUSTOM5<=? and " +
							"GALLERY_CUSTOM7>=? and GALLERY_CUSTOM7<=? and " + 
							"GALLERY_CUSTOM9>=? and GALLERY_CUSTOM9<=? and " +
							"GALLERY_CUSTOM10>=? and GALLERY_CUSTOM10<=? and " +
							"GALLERY_CUSTOM12 like ? ";
			
			
			List <GalleryBean>searchList = new ArrayList<GalleryBean>();
			int startrow = (page-1)*10 + 1; 
			int endrow = startrow + limit - 1;
			
			try{
				con = ds.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
				pstmt.setInt(3, height_start);
				pstmt.setInt(4, height_final);
				pstmt.setString(5, "%"+search_nek+"%");
				pstmt.setInt(6, upper_start);
				pstmt.setInt(7, upper_final);
				pstmt.setInt(8, arm_start);
				pstmt.setInt(9, arm_final);
				pstmt.setInt(10, arm_start);
				pstmt.setInt(11, arm_final);
				pstmt.setInt(12, B_start);
				pstmt.setInt(13, B_final);
				pstmt.setInt(14, H_start);
				pstmt.setInt(15, H_final);
				pstmt.setString(16, search_C);
				rs=pstmt.executeQuery();
				 
				
				while(rs.next()){
					GalleryBean gb = new GalleryBean();
					
					gb.setGALLERY_NUM(rs.getInt("GALLERY_NUM"));
					gb.setGALLERY_CUSTOM_NUM(rs.getInt("GALLERY_CUSTOM_NUM"));
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
					searchList.add(gb);
					 
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
			 
			return searchList;
			
		}
	} 

	

