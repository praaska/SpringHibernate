package org.haritha.learning.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.haritha.learning.dto.Login;
import org.haritha.learning.jdbc.dao.JdbcLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
@Component
public class JdbcLoginDaoImpl implements JdbcLoginDao {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}
    @Autowired 
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean isValidUser(String username, String password) {
		boolean userFound=false;
		String sql="select * from adminaccount where username=? and password=?";
		Login login= jdbcTemplate.queryForObject(sql, new Object[]{username,password},new LoginMapper());
		if(login!=null){
			userFound=true;
		}
		return userFound;
	}
	private static final class LoginMapper implements RowMapper<Login>{

		@Override
		public Login mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Login login=new Login();
			login.setUsername(resultSet.getString("username"));
			login.setPassword(resultSet.getString("password"));
			return login;
		}
		
	}

}
