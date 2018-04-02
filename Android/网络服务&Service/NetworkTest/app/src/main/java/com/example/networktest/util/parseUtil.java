package com.example.networktest.util;

import android.util.Log;

import com.example.networktest.App;
import com.example.networktest.ContentHandler;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by masterzht on 2018/1/5.
 */

public class parseUtil {

    public static void parseXMLWithPull(String xmlData){

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


}
