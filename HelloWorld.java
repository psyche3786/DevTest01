package org.opentutorial.javatutorial.eclipse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class HelloWorld {

	static final String drvier = "oracle.jdbc.OracleDriver";
	static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static final String id = "scott";
	static final String pw = "tiger";
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			addData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addData() throws Exception {
		// JDBC Driver ·Îµù
		Class.forName(drvier);
		Connection db = DriverManager.getConnection(url, id, pw);
		//
		String sql = "insert into test_table (test_idx, test_number, test_str) values (test_seq.nextval, ?, ?)";
		PreparedStatement psmt = db.prepareStatement(sql);
		
		psmt.setInt(1, 100);
		psmt.setString(2, "string1");
		psmt.execute();
		
		psmt.setInt(1, 200);
		psmt.setString(2, "string2");
		psmt.execute();
		
		db.close();
		System.out.println("Complete");
		
		System.out.println("Add Tets!~!!");
	}
}
