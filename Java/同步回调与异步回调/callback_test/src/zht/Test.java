package zht;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Server server=new Server();
		Client client=new Client(server);
		
		//client.sendWithyibuMsg("Server,Hello~");//�������첽�Ĺؼ��㣬�ⲽִ����ͻ᷵�����������ʵ���첽�ķ��������½��̣߳������Ļ��������������ͻ���������ִ���ˣ���������
		
		client.sendWithtongbuMsg("��Ҫ����ѽ");
		//client.sendWithyibuMsg("��Ҫ����ѽ");
		
		System.out.println("�ͻ��ˣ���Ҫ��������ʹ����");
		
	
		

	}

}
