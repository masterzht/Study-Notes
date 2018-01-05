package com.example.networktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.networktest.util.HttpCallbackListener;
import com.example.networktest.util.HttpUtil;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.response_text);
        Button sendRequest = (Button) findViewById(R.id.send_request);

        //为按钮设置点击事件
        sendRequest.setOnClickListener(this);
    }

    //点击事件先下载网页，然后用xml或者json解析
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request) {
//其实这种写法有点问题，因为app中不可能只有这里面才用网络服务，其他的地方可能也有，这样的话其他的地方就需要重新写了。这显然是不好的。于是就催生出了网络服务工具类！！！所以就先写一个util的文件夹package，然后在里面加入各类工具类
            //sendRequestWithHttpURLConnection();
            //sendRequestWithOkHttp();

//然后就要解析数据了
            //        parseJSONWithGSON(response);
            //        parseJSONWithJSONObject(response);
            //        parseXMLWithSAX(response);
            //        parseXMLWithPull(response);


            //规范用法，调用外部的http工具类
            HttpUtil.sendHttpRequest("https://www.baidu.com",
                    new HttpCallbackListener() {

                        @Override
                        public void onError(Exception e) {

                        }

                        @Override
                        public void onFinish(String response) {
                            String responseData = response;

                            //解析数据
//                    parseJSONWithGSON(responseData);
//                    parseJSONWithJSONObject(responseData);
//                    parseXMLWithSAX(responseData);
//                    parseXMLWithPull(responseData);


                            getSupportFragmentManager().beginTransaction().add(R.id.activity1, BlankFragment.newInstance(responseData)).commit();

                        }


                    });
           /* HttpUtil.sendOkHttpRequest("https://www.baidu.com", new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseData=response.body().string();
                    showResponse(responseData);

                }
            });*/
        }
    }


    //发起请求，获取网页，肯定是要在现场里面进行的
    private void sendRequestWithHttpURLConnection() {
        // 开启子线程来发起网络请求
        //始终记住第一步是给网络连接权限 <uses-permission android:name="android.permission.INTERNET" />
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    //get方式url的参数params就不要专门建一个变量了直接用
                    //至于post方式的别学了，垃圾到家的方法
                    URL url = new URL("https://www.baidu.com/s?wd=我嘞个去");
                    //String params ="wd=我嘞个去"
                    connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    //到了这里网络连接才算正式开始
                    InputStream in = connection.getInputStream();
                    // 下面对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    //显示界面的时候就犯难了，因为这里面是子线程，而子线程不能显示界面！！！
                    showResponse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();//流要关闭
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();//连接也要关闭
                    }
                }
            }
        }).start();
    }

    //用okhttp库发送请求
    private void sendRequestWithOkHttp() {

        //不能再UI线程运行io密集型的操作，所以要创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            // 指定访问的服务器地址是电脑本机
                            .url("http://192.168.1.208/get_data.json")
//                            .url("http://192.168.1.208/get_data.xml")
//                            .url("http://192.168.169.2/get_data2.json")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();

                    parseJSONWithGSON(responseData);
//                    parseJSONWithJSONObject(responseData);
//                 parseXMLWithSAX(responseData);、parseXMLWithPull(responseData);
//                    showResponse(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    //解析xml型的数据
/*<apps>
    <app>
        <id>1</id>
        <name>Google Maps</name>
        <version>1.0</version>
    </app>

    <app>
        <id>3</id>
        <name>Google Play</name>
        <version>2.3</version>
    </app>
</apps>*/
//首先要知道外面的app，apps不是我们要解析的点
    private void parseXMLWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            //获取解析事件
            int eventType = xmlPullParser.getEventType();

            String id = "";
            String name = "";
            String version = "";

            while (eventType != XmlPullParser.END_DOCUMENT) {

                String nodeName = xmlPullParser.getName();

                switch (eventType) {
                    // 开始解析某个结点
                    //所谓的节点是框的一半，就是一个<name>,end_tag就是</name>
                    case XmlPullParser.START_TAG: {
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                        break;
                    }
                    // 完成解析某个结点,解析到</xx>了
                    case XmlPullParser.END_TAG: {
                        if ("app".equals(nodeName)) {
                            Log.d("MainActivity", "id is " + id);
                            Log.d("MainActivity", "name is " + name);
                            Log.d("MainActivity", "version is " + version);
                        }
                        break;
                    }
                    default:
                        break;
                }

                eventType = xmlPullParser.next();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //SAX解析属于语义解析，需要contentHandler的支持
    private void parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new ContentHandler();
            // 将ContentHandler的实例设置到XMLReader中
            xmlReader.setContentHandler(handler);
            // 开始执行解析
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //解析json型的数据
    private void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("MainActivity", "id is " + id);
                Log.d("MainActivity", "name is " + name);
                Log.d("MainActivity", "version is " + version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        /*List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>() {
        }.getType());*/
        App appList = gson.fromJson(jsonData, App.class);
        /*for (App app : appList) {
            Log.d("MainActivity", "id is " + app.getClass());
            Log.d("MainActivity", "name is " + app.getData());
            Log.d("MainActivity", "version is " + app.getMessage());
        }*/
        Log.d("MainActivity", "version is " + appList.getMessage());
        List<App.DataBean.CommentsBean> g = appList.getData().getComments();//凭什么不给个泛型，还不能get到数据啦！！！！！！！！！怎么弄数组？
        //App.DataBean.CommentsBean[] h=appList.getData().getComments();
        //Log.d("MainActivity", "绘画 " +g.get(1).getText());

        Iterator a = g.iterator();
        while (a.hasNext()) {
            Log.d("MainActivity", "绘画 " + ((App.DataBean.CommentsBean) a.next()).getText());
        }


    }

    private void showResponse(final String response) {
        //使用匿名类，并且转换成UI线程
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，.将结果显示到界面上
                responseText.setText(response);
            }
        });
    }


}
