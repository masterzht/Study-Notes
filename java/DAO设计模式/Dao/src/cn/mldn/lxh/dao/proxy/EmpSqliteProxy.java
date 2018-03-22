package cn.mldn.lxh.dao.proxy;

import java.util.List;

import cn.mldn.lxh.dao.IEmpDAO;
import cn.mldn.lxh.dao.impl.EmpDAOImpl;
import cn.mldn.lxh.dao.impl.EmpSqliteimpl;
import cn.mldn.lxh.dbc.MysqlConnection;
import cn.mldn.lxh.dbc.SqliteConnection;
import cn.mldn.lxh.vo.Emp;

public class EmpSqliteProxy implements IEmpDAO{
	
	private SqliteConnection dbc = null ;
	private IEmpDAO dao = null ;
	public EmpSqliteProxy() throws Exception {
		this.dbc = new SqliteConnection() ;
		this.dao = new EmpSqliteimpl(this.dbc.getConnection()) ;
	}
	@Override
	public boolean doCreate(Emp emp) throws Exception {
		boolean flag = false ;
		try{
			if(this.dao.findById(emp.getEmpno()) == null){
				flag = this.dao.doCreate(emp) ;
			}
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return flag ;
	}
	@Override
	public List<Emp> findAll(String keyWord) throws Exception {
		List<Emp> all = null ;
		try{
			all = this.dao.findAll(keyWord) ;
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return all ;
	}
	@Override
	public Emp findById(int empno) throws Exception {
		Emp emp = null ;
		try{
			emp = this.dao.findById(empno) ;
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return emp ;
	}

}
