package zht;

public class Client implements CSCallBack {
	
	
	private Server server;

    public Client(Server server) {
        this.server = server;
    }

    //异步
    public void sendWithyibuMsg(final String msg){
        
        
        //新建一个线程去传送数据
        new Thread(new Runnable() {
            @Override
            public void run() {
//            	try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO 自动生成的 catch 块
//					e.printStackTrace();
//				}
                server.getClientMsg(Client.this,msg);
            }
        }).start();
        System.out.println("客户端：信息发送成功");
    }
    
    //同步
    public void sendWithtongbuMsg(final String msg){
    	server.getClientMsg(Client.this,msg);
    }
	
	
	
	
	
	
	//实现接口
	@Override
	public void Solve(String status) {
		// TODO Auto-generated method stub
		//判断有没有发送成功
		if(status =="200")
			//System.out.println("客户端：服务端回调状态为：" + status);
			System.out.println("服务器： 找到书了");
		else
			System.out.println("服务器： 没找到书");
			
		

	}

}
