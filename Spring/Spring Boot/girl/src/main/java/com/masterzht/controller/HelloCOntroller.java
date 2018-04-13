package com.masterzht.controller;

import com.masterzht.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by masterzht on 2018/4/13.
 */
//这个注释等同于Controller和ResponseBody的结合
@RestController
@RequestMapping("/")
public class HelloCOntroller {

    //这是最基础的获取application.properties的方式
    @Value("${girl.cupsize}")
    private String cupsize;
    @Value("${girl.age}")
    private Integer age;
    @Value("${girl.content}")
    private String content;
    //采用自动注入，有了这个注解之后，会自动扫描这个类里面的值，然后新建这个类（映射）
    @Autowired
    private GirlProperties girlproperties;

    /**获取url上面的输入
     * http://localhost:8080/cupsize/小红
     * */
    @GetMapping(value = "/cupsize/{name}")
    public String cupsize(@PathVariable("name") String name){
        return name +":是"+ cupsize + "罩杯" ;
    }

    /**
     * 返回param的值，输入返回get方法的请求参数
     * defaultvakue:默认传值
     * requeired:是不是一定要传值
     * http://localhost:8080/age?id=10086*/
    @GetMapping(value = "/age")
    public String age(@RequestParam(value = "id",required = false,defaultValue = "10086") Integer myid){
        return myid +"已经"+ age +"岁了";
    }
    @GetMapping(value = "/content")
    public String content(){
        return girlproperties.getContent();
    }




    @GetMapping(value = "/")
    public String hello(){
        return "hello spring boot!";
    }

}
