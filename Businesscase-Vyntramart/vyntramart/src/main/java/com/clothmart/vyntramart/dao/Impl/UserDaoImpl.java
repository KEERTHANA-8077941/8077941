package com.clothmart.vyntramart.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.clothmart.vyntramart.dao.UserDao;
import com.clothmart.vyntramart.model.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertUser(User u) {
		String sql = "INSERT INTO employee " +
				"(uId, uName) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				u.getUId(), u.getUName()
		});
	}
	
	@Override
	public void insertUsers(final List<User> users) {
		String sql = "INSERT INTO user " + "(uId, uName) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				User user = users.get(i);
				ps.setString(1, user.getUId());
				ps.setString(2, user.getUName());
			}
			
			public int getBatchSize() {
				return users.size();
			}
		});

	}
	@Override
	public List<User> getAllUsers(){
		String sql = "SELECT * FROM user";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<User> result = new ArrayList<User>();
		for(Map<String, Object> row:rows){
			User u = new User();
			u.setUId((String)row.get("uId"));
			u.setUName((String)row.get("uName"));
			result.add(u);
		}
		
		return result;
	}

	@Override
	public User getUserById(String uId) {
		String sql = "SELECT * FROM user WHERE uId = ?";
		return (User)getJdbcTemplate().queryForObject(sql, new Object[]{uId}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				User u = new User();
				u.setUId(rs.getString("uId"));
				u.setUName(rs.getString("uName"));
				return u;
			}
		});
	}
}