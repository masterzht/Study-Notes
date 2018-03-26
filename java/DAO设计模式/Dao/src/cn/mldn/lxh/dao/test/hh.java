package cn.mldn.lxh.dao.test;

public class hh {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("hhahahahahaha");
		int i = 128; //‭10111100 01100001 01001110‬ 
		
        byte a=(byte)(i);   //128 (int) 00 00 00 80==>byte  80
        System.out.println(a);
        byte b = (byte)(i&0xFF); // 00 00 00 80
		                         // 00 00 00 FF
								 //=00 00 00 80
		                            
        System.out.println(b);
        byte c = (byte)((i>>8)&0xFF);// 00 00 00 80
		                             //>00 00 00 00
		
        System.out.println(c);

	}

}
