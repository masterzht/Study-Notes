package cn.mldn.lxh.dao.test;

import java.util.Iterator;
import java.util.List;

import cn.mldn.lxh.dao.IEmpDAO;
import cn.mldn.lxh.dbc.SqliteConnection;
import cn.mldn.lxh.factory.DAOFactory;
import cn.mldn.lxh.vo.Emp;

public class TestSqlite {
	
	public static void main(String args[]) throws Exception{
		
		List<Emp> all = DAOFactory.getIEmpSqliteInstance().findAll("œ˙ €") ;
		Iterator<Emp> iter = all.iterator() ;
		while(iter.hasNext()){
			Emp emp = iter.next() ;
			System.out.println(emp.getEmpno() + "°¢" + emp.getEname() + " --> " + emp.getJob()) ;
		}
		System.out.println("out");
	}

}
