package com.hiepDH7.SpingBootService1.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hiepDH7.SpingBootService1.controller.Library;



public class ConnectToOracle {
	private static String hostName = "oracle.cpzvx7imbbmq.us-east-2.rds.amazonaws.com";
	private static String dbName = "ORCL";
	private static String url = "jdbc:oracle:thin:@oracle.cpzvx7imbbmq.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String userName = "admin";
	private static String password = "hienhiep1999";
	public static Connection layKetNoi() {
		Connection ketNoi = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ketNoi = DriverManager.getConnection(url, userName, password);
			System.out.println("Thanh cong ket noi len aws");
			
		} catch(ClassNotFoundException | SQLException ex) {
			System.out.println("Khong thanh cong");
			System.out.println(ex);
		}
		return ketNoi;
	}
	public static Library layThongTin(String id) {
		Library lib = new Library();
		Connection ketNoi = layKetNoi();
		String sql = "select * from STORAGE2 where ID = 1";
		try {
			PreparedStatement ps = ketNoi.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				lib.setID(rs.getString("ID"));
				lib.setBOOK_NAME(rs.getString("BOOK_NAME"));
				lib.setAUTHOR(rs.getString("AUTHOR"));
				lib.setAISLE(rs.getInt("AISLE"));
				lib.setISBN(rs.getString("ISBN"));
				System.out.println(lib.getID());
			}
			
			rs.close();
			ps.close();
		} catch(SQLException ex) {
			System.out.print(ex);
		}
		return lib;
		
	}
//	public static void main(String[] args) {
//		layThongTin("2");
//	}
}
