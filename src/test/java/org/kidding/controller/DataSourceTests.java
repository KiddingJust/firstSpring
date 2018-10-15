package org.kidding.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	@Autowired
	private DataSource ds;
	
	@Test
	public void test1() {	
		
		//root-context.xml이 제대로 되는지 체크하는 것. 
		log.info("test1..................");
	}
	
	@Test
	public void testConnection() throws SQLException {
		log.info(ds.getConnection());
		
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select now()");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			log.info(rs.getString(1));
		}
		
		rs.close();
		conn.close();
				
	}
	
}
