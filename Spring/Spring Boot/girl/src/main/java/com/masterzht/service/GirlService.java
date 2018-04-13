package com.masterzht.service;

import com.masterzht.entity.Girl;
import com.masterzht.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by masterzht on 2018/4/13.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;


    /**
     * 事务管理：日常购物过程，发货和付费两个数据库保存结果，只要有一个处理失败，另一个就不能保存，这个例子就是只要girl2保存失败，girl1也不保存
     * 关键就是transactional，就可以达到事务管理的效果
     */

    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl();
        girl1.setCupsize("A");
        girl1.setAge(1);
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setCupsize("B");
        girl2.setAge(2);
        girlRepository.save(girl2);
    }






}