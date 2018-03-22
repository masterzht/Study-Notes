package cn.mldn.lxh.factory;

import cn.mldn.lxh.dbc.MysqlConnection;
import cn.mldn.lxh.dbc.SqliteConnection;

public class DatebaseConnectionFactory {
	public static MysqlConnection getMysqlConnection() throws Exception {
		return new MysqlConnection();
	}
	
	public static SqliteConnection getSqliteConnection() throws Exception{
		return new SqliteConnection();
		
	}

}
