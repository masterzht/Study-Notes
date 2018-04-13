package com.masterzht.repository;

import com.masterzht.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by masterzht on 2018/4/13.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //自定义查询方法

    /**
     * 通过年龄来查询女生，这个find的写法是规定的，不能乱写
     * 而且必须用List，不想通过id肯定是一个结果
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);



}
