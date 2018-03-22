package cn.mldn.lxh.factory ;
import cn.mldn.lxh.dao.IEmpDAO ;
import cn.mldn.lxh.dao.proxy.EmpMysqlProxy ;
import cn.mldn.lxh.dao.proxy.EmpSqliteProxy;
public class DAOFactory {
	public static IEmpDAO getIEmpDAOInstance() throws Exception{
		//return new EmpDAOProxy() ;
		
		
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
	 * 用sqlite数据库实现
	 * @return
	 * @throws Exception
	 */
	public static IEmpDAO getIEmpSqliteInstance() throws Exception{
		return new EmpSqliteProxy();
		
	}
	
	
	
	
}