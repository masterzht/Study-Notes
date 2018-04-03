package zht;

public class Server {

    public void getClientMsg(CSCallBack csCallBack , String msg) {
        System.out.println("服务端：服务端接收到客户端发送的消息为:" + msg);

        // 模拟服务端需要对数据处理
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("服务端:数据处理成功，返回成功状态 200");
        String status = "200";
        
        //到这里已经处理完了发送端Client的数据，接下来要通知Client已经完成，可以用回调机制的callback
        
        //调用了Client发送端的
        csCallBack.Solve(status);
    }
}
