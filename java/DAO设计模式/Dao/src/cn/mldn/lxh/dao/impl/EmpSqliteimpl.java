package cn.mldn.lxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.mldn.lxh.dao.IEmpDAO;
import cn.mldn.lxh.vo.Emp;

public class EmpSqliteimpl implements IEmpDAO{
	private Connection conn = null ;
	Statement stmt=null;
	
	public EmpSqliteimpl(Connection conn){
		this.conn = conn ;
	}

	@Override
	public boolean doCreate(Emp emp) throws Exception {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public List<Emp> findAll(String keyWord) throws Exception {
		// TODO 自动生成的方法存根
		 String str1 = "\"keyWord\"";
		List<Emp> all = new ArrayList<Emp>();
		String sql = "SELECT empno,ename,job,hiredate,sal FROM emp WHERE ename="+"\"" +keyWord +"\"" +"or job="+"\"" +keyWord+"\"";
		stmt = conn.createStatement();
		System.out.println(sql);
		
		ResultSet rs = stmt.executeQuery(sql);
		Emp emp = null ;
		while ( rs.next() ) {
			emp = new Emp() ;
			emp.setEmpno(rs.getInt(1)) ;
			emp.setEname(rs.getString(2)) ;
			emp.setJob(rs.getString(3)) ;
			//emp.setHiredate(rs.getDate(4)) ;//这个目前还不清楚原因，放着
			emp.setSal(rs.getFloat(5)) ;
			all.add(emp) ;
		}

		this.stmt.close() ;
		return all ;
	}

	@Override
	public Emp findById(int empno) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

}
