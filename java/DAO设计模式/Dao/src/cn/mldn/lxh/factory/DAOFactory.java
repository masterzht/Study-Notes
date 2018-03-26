package cn.mldn.lxh.factory ;
import cn.mldn.lxh.dao.IEmpDAO ;
import cn.mldn.lxh.dao.impl.EmpSqliteimpl;
import cn.mldn.lxh.dao.proxy.EmpMysqlProxy ;
import cn.mldn.lxh.dao.proxy.EmpProxy;
import cn.mldn.lxh.dao.proxy.EmpSqliteProxy;
import cn.mldn.lxh.dbc.DatabaseConnection;
import cn.mldn.lxh.dbc.SqliteConnection;
public class DAOFactory {
	public static IEmpDAO getIEmpDAOInstance() throws Exception{
		//��ʽһ��ֱ��return
		//return new EmpMysqlProxy() ;
		/*IEmpDAO dao = null;  
        try{  
            dao = new EmpMysqlProxy();      
        }  
        catch(Exception e){  
            e.printStackTrace();  
        }  
        return dao;  */
		//��ʽ����ͨ��DatabaseConnection����
		//return DAOFactory.
		IEmpDAO dao = null;  
        try{  
            dao = new EmpMysqlProxy();      
        }  
        catch(Exception e){  
            e.printStackTrace();  
        }  
        return dao; 
		
		
	
	}
	
	/**
	 * ��sqlite���ݿ�ʵ��
	 * @return
	 * @throws Exception
	 */
	public static IEmpDAO getIEmpSqliteInstance() throws Exception{
		
		DatabaseConnection dbc = new SqliteConnection();
		IEmpDAO dao = new EmpSqliteimpl(dbc.getConnection());
		return new EmpProxy(dbc,dao);
		
	}
	
	
	
	
}