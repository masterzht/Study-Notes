package com.example.networktest.util;

public class Test{


    public static void main(String[] args){

        TestCallbackclass a=new TestCallbackclass();
        a.dosomething();
        a.setCall(new TestCallbackclass.TestCallback(){

           public void onFinish(String response){
                System.out.println(response);
            }

            public void onError(Exception e){
                System.out.println("no");
            }

        }
        );


    }


    

}

class TestCallbackclass{

    TestCallback  call;

    public void setCall(TestCallback callto){
        this.call=callto;

    }

    public interface TestCallback{
        void onFinish(String response);

        void onError(Exception e);
    }


    public void dosomething(){
        //要做的事就是回调
        call.onFinish("传给你了的内容");
    }
}