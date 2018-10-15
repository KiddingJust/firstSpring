package org.kidding.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import lombok.extern.log4j.Log4j;


@Log4j
public class JDBCTests {

	@Test
	public void testConnection()throws Exception {
		log.info("test Connection starts.........");
		
		String url = "jdbc:mysql://localhost:3306/jr?useSSL=false&serverTimezone=UTC";        // ����Ϸ��� �����ͺ��̽����� ������ URL ���. ����Ŭ�� XE. MySQL�� ����ڸ��� ��Ű���� �ٸ��� ����
		String id = "jr2018";                                 // ����� ����
		String pw = "jr2018";                                 // ����� ������ �н�����

		Class.forName("com.mysql.cj.jdbc.Driver");               // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.
		Connection conn = DriverManager.getConnection(url, id, pw);          // DriverManager ��ü�κ��� Connection ��ü�� ���´�.
		
		log.info(conn);
		
		PreparedStatement pstmt = conn.prepareStatement("select now()");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			log.info(rs.getString(1));
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		conn.close();
	}
}
