package com.poscoict.emaillist.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.poscoict.emaillist.vo.EmaillistVo;

@Repository
public class EmaillistRepository {
	public List<EmaillistVo> findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmaillistVo> result = new ArrayList<EmaillistVo>();

		try {

			conn = getconnConnection();

			// 3. SQL 준비
			String sql = "select no, first_name, last_name, email from emaillist order by no desc";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);

				EmaillistVo vo = new EmaillistVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.print("error : " + e.getMessage());
		} finally {
			// 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean insert(EmaillistVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getconnConnection();
			
			// 3. SQL 준비
			String sql = "insert into emaillist values(null, ?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			// 5. SQL 실행

			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.print("error : " + e.getMessage());
		} finally {
			// 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private Connection getconnConnection() throws SQLException{
		Connection conn =null;
		try {
			// 1. JDBC드라이버 로딩
			Class.forName("com.mariadb.cj.jdbc.Driver");
			// 2.연결하기
			String url = "jdbc:mysql://192.168.0.47:3307/webdb?characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		}catch (ClassNotFoundException e) {
			System.out.print("드라이버 로딩 실패 : " + e.getMessage());
		}
		return conn;
		}

}
