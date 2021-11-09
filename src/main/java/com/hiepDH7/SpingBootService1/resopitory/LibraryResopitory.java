package com.hiepDH7.SpingBootService1.resopitory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.hiepDH7.SpingBootService1.controller.Library;
import com.hiepDH7.SpingBootService1.controller.LibraryRowMapper;
@Repository
public class LibraryResopitory {
	@Autowired
	JdbcTemplate jdbc;
	public List<Library> getLib() {
		return jdbc.query("select * from STORAGE2 where ID = 1", new LibraryRowMapper());
	}
	public Library findById(String id) {
		String sql = "select * from STORAGE2 where ID = ?";
		try {
			return (Library) this.jdbc.queryForObject(sql, new Object[] {id},new LibraryRowMapper());
		} catch(EmptyResultDataAccessException ex) {
			return null;
		}
	}
	public Boolean saveLib(Library library) {
		String query = "insert into STORAGE2 values (?,?,?,?,?)";
		return jdbc.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1,library.getBOOK_NAME());
				ps.setString(2,library.getID());
				ps.setString(3,library.getISBN());
				ps.setInt(4, library.getAISLE());
				ps.setString(5,library.getAUTHOR());
				return ps.execute();
			}
			
		});
	}
	public Integer updateLib(Library library) {
		String query = "update  STORAGE2 set BOOK_NAME = ?, ISBN = ?, AISLE = ?, AUTHOR = ? WHERE ID = ?";
		Object[] params = {library.getBOOK_NAME(),library.getISBN(),library.getAISLE(),library.getAUTHOR(),library.getID()};
		int[] types = {Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.VARCHAR,Types.VARCHAR};
		return jdbc.update(query,params,types);
	}
	public Integer deletebyId(String id) {
		return jdbc.update("delete from STORAGE2 where ID = ?",id);
	}
}
