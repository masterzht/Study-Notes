package cn.mldn.lxh.dbc;

import java.sql.Connection;

public interface DatabaseConnection {
//	ȡ�����ݿ������
	public Connection getConnection();
//	�ر����ݿ������
	public void close() throws Exception;

}
