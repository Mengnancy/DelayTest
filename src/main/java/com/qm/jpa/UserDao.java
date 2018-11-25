package com.qm.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Linglingxin
 * @Date: 2018/10/29 23:09
 */
// 必须继承 Repository 及其子接口(CrudRepository, PagingAndSortingRepository 等), 各种查询方法才会起作用
// Repository 为空接口，必须自己定义相关的方法
@Component
public interface UserDao extends CrudRepository<User, Long> {

    // 解析方法名创建查询
    public User findByName(String name);

    // 使用 @Query 创建查询
    @Query("select bean from User bean where bean.name like %?1%")
    public List<User> findUserByQuery(String name);

}
