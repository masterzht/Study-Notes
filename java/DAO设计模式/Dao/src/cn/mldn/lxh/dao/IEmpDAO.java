package cn.mldn.lxh.dao ;
import java.util.* ;
import cn.mldn.lxh.vo.* ;
public interface IEmpDAO {
	
	/**
	 * �������Ӳ������
	 * @param emp Ҫ���ӵ����ݶ���	
	 * @return �Ƿ����ӳɹ�
	 * @throws Exception
	 */
	public boolean doCreate(Emp emp) throws Exception ;
	
	/**
	 * ��ѯȫ��������
	 * @param keyWord ��ѯ�Ĺؼ���
	 * @return ����ȫ���Ĳ�ѯ�����ÿһ��Emp�����ʾ���һ�м�¼
	 * @throws Exception ���쳣����
	 */
	public List<Emp> findAll(String keyWord) throws Exception ;
	
	
	/**
	 * ���ݹ�Ա��Ų�ѯ��Ա��Ϣ
	 * @param empno ��Ա���
	 * @return ��Ա��vo����
	 * @throws Exception
	 */
	public Emp findById(int empno) throws Exception ;
}