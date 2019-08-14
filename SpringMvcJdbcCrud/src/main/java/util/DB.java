package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {

	final private String url = "jdbc:mysql://localhost:3307/";
	final private String dbName = "DBcalisma"; // baglanti yapilacak olan dbnin yolu
	final private String dbUser = "root";
	final private String dbPass = "";

	final private String driver = "com.mysql.jdbc.Driver";
	
	private Connection conn = null;
	private PreparedStatement st;
	
	public DB() {
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url + dbName, dbUser, dbPass);
			System.out.println("Bağlantı Başarılı");
			
		} catch (Exception e) {
			System.err.println("Bağlantı Hatası: " + e);
		}
			
	}
	
	public PreparedStatement connect(String query) {
		
		try {
			st = conn.prepareStatement(query);
			return st;
		} catch (Exception e) {
			System.err.println("Pre st Hatası " + e);
		}
		
		return st;
	}
	
	
}
