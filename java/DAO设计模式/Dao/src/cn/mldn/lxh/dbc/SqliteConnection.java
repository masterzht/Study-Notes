package cn.mldn.lxh.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqliteConnection implements DatabaseConnection {
	
	private static final String DBDRIVER = "org.sqlite.JDBC" ; 
	private static final String DBURL = "jdbc:sqlite:test.db" ;
	//private static final String DBUSER = "root" ;
	//private static final String DBPASSWORD = "123456" ;
	private Connection conn ;
	
	
	public SqliteConnection() throws Exception{
		
		
		try {
		      Class.forName( DBDRIVER);
		      conn = DriverManager.getConnection(DBURL);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Opened database successfully");
		
	}


	@Override
	public Connection getConnection() {
		return this.conn ;
	}


	@Override
	public void close() throws Exception {
		if(this.conn != null){
			try{
				this.conn.close() ;
			}catch(Exception e){
				throw e ;
			}
		}
		
	}
	
	
	

}
