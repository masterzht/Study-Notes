package zht;

public class Client implements CSCallBack {
	
	
	private Server server;

    public Client(Server server) {
        this.server = server;
    }

    //�첽
    public void sendWithyibuMsg(final String msg){
        
        
        //�½�һ���߳�ȥ��������
        new Thread(new Runnable() {
            @Override
            public void run() {
//            	try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO �Զ����ɵ� catch ��
//					e.printStackTrace();
//				}
                server.getClientMsg(Client.this,msg);
            }
        }).start();
        System.out.println("�ͻ��ˣ���Ϣ���ͳɹ�");
    }
    
    //ͬ��
    public void sendWithtongbuMsg(final String msg){
    	server.getClientMsg(Client.this,msg);
    }
	
	
	
	
	
	
	//ʵ�ֽӿ�
	@Override
	public void Solve(String status) {
		// TODO Auto-generated method stub
		//�ж���û�з��ͳɹ�
		if(status =="200")
			//System.out.println("�ͻ��ˣ�����˻ص�״̬Ϊ��" + status);
			System.out.println("�������� �ҵ�����");
		else
			System.out.println("�������� û�ҵ���");
			
		

	}

}
