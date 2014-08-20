package com.zhy.spread.service;

import java.util.List;

import com.zhy.spread.entity.Area;

/**
 * 地点业务
 * 
 * @author ZhangHongyan
 */
public interface AreaService {

    /**
     * 获取所有地点
     * 
     * @author ZhangHongyan
     * @return
     */
    public List<Object> findAllAreas();

    /**
     * 获取所有省份
     * 
     * @return
     */
    public List<Area> findAllProvinces();

    /**
     * 获取所有省份下的城市
     * 
     * @param id
     * @return
     */
    public List<Area> findCitiesByProvinceid(Long id);
}
