package com.zhy.spread.dao;

import java.util.List;

import com.zhy.spread.entity.Area;

public interface AreaDAO {

    public List<Area> getAllAreas();

    public List<Area> getTopAreas();

    public List<Area> findSubAreas(Long id);

}
