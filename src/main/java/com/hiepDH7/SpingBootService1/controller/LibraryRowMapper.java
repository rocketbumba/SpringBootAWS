package com.hiepDH7.SpingBootService1.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LibraryRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Library lib = new Library();
		lib.setID(rs.getString("ID"));
		lib.setBOOK_NAME(rs.getString("BOOK_NAME"));
		lib.setAUTHOR(rs.getString("AUTHOR"));
		lib.setAISLE(rs.getInt("AISLE"));
		lib.setISBN(rs.getString("ISBN"));
		return lib;
	}
	
}
