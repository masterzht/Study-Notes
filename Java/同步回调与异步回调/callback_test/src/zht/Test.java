package zht;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Server server=new Server();
		Client client=new Client(server);
		
		//client.sendWithyibuMsg("Server,Hello~");//这里是异步的关键点，这步执行完就会返回这个方法，实现异步的方法就是新建线程，这样的话在这个方法里面就会有两道线执行了，互不干扰
		
		client.sendWithtongbuMsg("我要买书呀");
		//client.sendWithyibuMsg("我要买书呀");
		
		System.out.println("客户端：我要做的事情就此完成");
		
	
		

	}

}
