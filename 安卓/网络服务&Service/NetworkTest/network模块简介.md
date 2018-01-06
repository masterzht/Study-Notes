## 知识点回顾

###  1.通过工具类HttpUtil获取网页内容（为什么用工具类？）

- 其实我把解析xml，json的也做成工具类了，工具类有个特定就是static

 - 看onClick方法，我把内部实现注释了，用的是工具类，是先跳转到fragment，再用fragment里面的HttpUtil实现
 - [看一下fragment里面的OnactivityCreated里面的工具类][1]

###  2.跳转到fragemnt（对fragment有误解，事实上，没有activity的话，fragment是不能存在的)
 - [看一下Mainactivity里面切换到fragment，其实就是用add或者replace，本质上还是在activity基础上变动](./app/src/main/java/com/example/networktest/MainActivity.java)

 - fragemnt还有一个有意思的知识点就是跳转时携带的数据，我们最好是用工厂方法，google有自带，newinstance，这样的话，B要什么数据，只要b一修改newinstance，我们传过去的只要针对这个就行了（因为程序永远是由最上层决定的，我们一级一级的传递数据，最终拿到数据的人才是王者，这个数据是它要的，它决定的，它提供接口给底下人一节一节实现

### 3.回调（什么是回调呢？)只有我的工具类里面都用到了回调，主activity里面的方法就不用

-  这是有原因的。主activity执行完了之后获取了网页内容，虽然是在子线程里面，但是因为它始终隶属于MainActivity的一部分，所以在获取了内容之后就直接调用showResponse(response.toString());,但是工具类不行，它获取内容是在工具类，得要现在主界面里面获取（String a=HttpUtil.sendHttpRequest()），这TMD就出问题了，因为下载send是在子线程进行的，所以String a直接获取空的就继续往下面执行了，而这个send方法还在子线程慢慢运行呢。
- 解决方案其实就是现在主activity弄一个方法可以显示界面，然后让工具类下载完之后调用这个方法。（这个是思路）
- [关于回调，这里还有一个很简单的的例子][2]

# 以上都是自编的方法，包括什么回调都是我们自己弄的，其实我们完全可以用okhttp设置好的回调




[1]: ./app/src/main/java/com/example/networktest/fragment/BlankFragment.java
[2]: https://github.com/masterzht/Study-Notes/blob/master/%E5%AE%89%E5%8D%93/%E5%89%8D%E4%BA%BA%E6%A0%BD%E6%A0%91%E5%90%8E%E4%BA%BA%E4%B9%98%E5%87%89/%E5%AE%89%E5%8D%93%E7%9A%84%E5%9B%9E%E8%B0%83/Test.java



