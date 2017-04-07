package com.cts.springjdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.springjdbc.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public User getById(int id) {
		String query = "SELECT name,age,salary from users WHERE id=?";
/*		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSalary(rs.getDouble("salary"));
				System.out.println(user);
			}
		}catch(SQLException ex){
			ex.getStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch (SQLException ex) {
				ex.getStackTrace();
			}
		}*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		User user = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSalary(rs.getDouble("salary"));
				return user;
			}
			
		});
		return user;
	}

	@Override
	public List<User> getAll() {
		String query = "SELECT name,age,salary from users";
		List<User> userList = new ArrayList<>();
/*		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSalary(rs.getDouble("salary"));
				userList.add(user);
			}
			System.out.println(userList.size());
		}catch (SQLException ex) {
			ex.getStackTrace();
		}finally {
			try{
				rs.close();
				ps.close();
				con.close();
			}catch (SQLException ex) {
				ex.getStackTrace();
			}
		}*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> userRows = jdbcTemplate.queryForList(query);
		for (Map<String, Object> userRow : userRows) {
			User user = new User();
			user.setName(String.valueOf(userRow.get("name")));
			user.setAge(Integer.parseInt(String.valueOf(userRow.get("age"))));
			user.setSalary(Double.parseDouble(String.valueOf(userRow.get("salary"))));
			userList.add(user);
		}
		return userList;
	}

}
