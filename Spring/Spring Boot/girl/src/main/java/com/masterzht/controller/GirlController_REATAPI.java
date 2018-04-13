package com.masterzht.controller;

import com.masterzht.entity.Girl;
import com.masterzht.repository.GirlRepository;
import com.masterzht.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by masterzht on 2018/4/13.
 */
@RestController
public class GirlController_REATAPI {
    //自动注入对girl进行操作的repo
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;
    /**
     * 查询所以女生列表
     * [{"id":1,"cupsize":"W","age":18},{"id":0,"cupsize":null,"age":null}]
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girllist(){
        return girlRepository.findAll();
    }

    /**
     * 用post请求创建一个女生
     */
    @PostMapping(value = "/girls")
    public Girl girladd(@RequestParam("age") Integer age,@RequestParam("cupsize") String cupsize) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupsize(cupsize);
        return girlRepository.save(girl);

    }


    /**
     * 根据id查询一个女生
     * 默认提供的查询方法只有工具id的，因为id默认是唯一的可以定制返回类型，如果要工具其他的字段必须要自定义，再repo里面添加
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl findonegirl(@PathVariable("id") Integer id){
        //springboot2.x貌似改版了，原来是girlRepository.findOne(id)
        return girlRepository.findById(id).orElse(null);
    }

    /**
     * 根据年龄查询女生，由于url会和上面的查询重叠，所以要更改
     * [{"id":1,"cupsize":"W","age":18}]
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findonegirlByage(@PathVariable("age") Integer age){
        //springboot2.x貌似改版了，原来是girlRepository.findOne(id)
        return girlRepository.findByAge(age);
    }

    /**
     * 修改某id女生的相关信息
     * @param id
     * @param age
     * @param cupsize
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateonegirl(@PathVariable("id") Integer id,@RequestParam("age") Integer age,@RequestParam("cupsize") String cupsize){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupsize(cupsize);
        return girlRepository.save(girl);
    }

    /**
     * 工具id删除女生
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteonegirl(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);

    }


    /**
     * 同时保存两个女生，只要有一个失败就不保存，要引入service事务进行具体分析管理
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }




}
