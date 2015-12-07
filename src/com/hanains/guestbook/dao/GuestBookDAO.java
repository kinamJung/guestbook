package com.hanains.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanains.guestbook.vo.GuestBookVo;

public class GuestBookDAO {

	public List<GuestBookVo> getList() {

		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Load Driver(Class Dynamic Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Connect DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// Create Statement
			stmt = conn.createStatement();

			// Execute SQL
			String sql = "select no, name, password, message, to_char(reg_date,'YYYY-MM-DD HH:MI:SS') from GUESTBOOK";
			rs = stmt.executeQuery(sql); // select문만 executeQuery, 이 외에는
											// executeUpdate

			while (rs.next()) {
				int index = 1;
				Long no = rs.getLong(index++);
				String name = rs.getString(index++);
				String password = rs.getString(index++);
				String message = rs.getString(index++);
				String date = rs.getString(index);
				
				GuestBookVo vo = new GuestBookVo(no, name, password, message, date);				
				list.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("[error] Fail Diver loading :" + e);
		} catch (SQLException e) {
			System.out.println("[error] SQL :" + e);
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}
	
	public void delete( GuestBookVo vo )
	{
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			// Load Driver(Class Dynamic Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Connect DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// Ready Statement
			String sql = "delete from GUESTBOOK  where no = ? and password=?";
			pstmt = conn.prepareStatement(sql);
			
			//binding
			int index = 1;
			pstmt.setLong(index++, vo.getNo() );
			pstmt.setString(index, vo.getPassword());

			
			// Execute SQL
			pstmt.executeUpdate();
			

		} catch (ClassNotFoundException e) {
			System.out.println("[error] Fail Diver loading :" + e);
		} catch (SQLException e) {
			System.out.println("[error] SQL :" + e);
		} finally {

			try {
				if( pstmt != null )
				{
					pstmt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		
		
		
	}
	
	
	public void insert(GuestBookVo vo) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			// Load Driver(Class Dynamic Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Connect DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// Ready Statement
			String sql = "insert into GUESTBOOK values( GUESTBOOK_SEQ.nextval,? ,? , ?, SYSDATE )";
			pstmt = conn.prepareStatement(sql);
			
			//binding
			int index = 1;
			pstmt.setString(index++, vo.getName());
			pstmt.setString(index++, vo.getPassword());
			pstmt.setString(index, vo.getMessage());
			
			// Execute SQL
			pstmt.executeUpdate();
			

		} catch (ClassNotFoundException e) {
			System.out.println("[error] Fail Diver loading :" + e);
		} catch (SQLException e) {
			System.out.println("[error] SQL :" + e);
		} finally {

			try {
				if( pstmt != null )
				{
					pstmt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	
	
}
