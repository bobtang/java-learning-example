package com.example.demoreactiveweb.module.system.repository;

import com.example.demoreactiveweb.module.system.model.SystemData;

import java.util.List;

/**
 * @author liupei
 * @date 2018/10/15 15:42
 */
public interface SystemDao {
    /**
     * 添加
     */
    int add(SystemData entity);
    
    /**
     * 删除
     */
    int delete(int id);
    
    /**
     * 获取全部数据
     *
     * @return
     */
    List<SystemData> getAllList();
}
