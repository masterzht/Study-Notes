package cn.mldn.lxh.dao ;
import java.util.* ;
import cn.mldn.lxh.vo.* ;
public interface IEmpDAO {
	
	/**
	 * 数据增加插入操作
	 * @param emp 要增加的数据对象	
	 * @return 是否增加成功
	 * @throws Exception
	 */
	public boolean doCreate(Emp emp) throws Exception ;
	
	/**
	 * 查询全部的数据
	 * @param keyWord 查询的关键字
	 * @return 返回全部的查询结果，每一个Emp对象表示表的一行记录
	 * @throws Exception 有异常处理
	 */
	public List<Emp> findAll(String keyWord) throws Exception ;
	
	
	/**
	 * 根据雇员编号查询雇员信息
	 * @param empno 雇员编号
	 * @return 雇员的vo对象
	 * @throws Exception
	 */
	public Emp findById(int empno) throws Exception ;
}