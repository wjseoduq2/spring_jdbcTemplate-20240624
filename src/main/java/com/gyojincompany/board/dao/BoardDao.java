package com.gyojincompany.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.gyojincompany.board.util.Constant;

public class BoardDao {
	
	// 멤버변수(멤버객체)
	DataSource dataSource;
	JdbcTemplate template;
	
	public BoardDao() {
		
		this.template = Constant.template;
		
	}
	
	public void writeOk(final String bname, final String btitle, final String bcontent) {
	
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "INSERT INTO springboard(bname, btitle, bcontent, bhit) VALUES (?,?,?,0)";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, bname);
				pstmt.setString(2, btitle);
				pstmt.setString(3, bcontent);
				
				return pstmt;
			}
		});
		
	}
	
	
}
