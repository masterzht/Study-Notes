package com.masterzht.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**定义一个类，映射表结构，数据库中会出现对应的表
 * 因为是create，所以会先删除数据再出现
 * Hibernate: drop table if exists girl
 Hibernate: drop table if exists hibernate_sequence
 Hibernate: create table girl (id integer not null, age integer, cupsize varchar(255), primary key (id)) engine=MyISAM
 Hibernate: create table hibernate_sequence (next_val bigint) engine=MyISAM
 Hibernate: insert into hibernate_sequence values ( 1 )
 * Created by masterzht on 2018/4/13.
 */

@Entity
public class Girl {
    /**
     * 差不多是主键的意思吧
     */
    @Id
    @GeneratedValue
    private Integer id;

    private String cupsize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupsize() {
        return cupsize;
    }

    public void setCupsize(String cupsize) {
        this.cupsize = cupsize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

}
