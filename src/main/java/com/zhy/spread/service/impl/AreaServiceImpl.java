package com.zhy.spread.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.dao.AreaDAO;
import com.zhy.spread.entity.Area;
import com.zhy.spread.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDAO areaDAO;

    @Override
    public List<Object> findAllAreas() {
        List<Object> result = new ArrayList<Object>();
        List<Area> allAreas = areaDAO.getAllAreas();
        List<Area> first = new ArrayList<Area>();
        Map<Long, List<Area>> secound = new HashMap<Long, List<Area>>();
        for (Area area : allAreas) {
            if (area.getParentId() == 0) {
                first.add(area);
            } else {
                List<Area> smallClasses = new ArrayList<Area>();
                if (secound.containsKey(area.getParentId())) {
                    smallClasses = secound.get(area.getParentId());
                }
                smallClasses.add(area);
                secound.put(area.getParentId(), smallClasses);
            }
        }
        result.add(first);
        result.add(secound);
        return result;
    }

    @Override
    public List<Area> findCitiesByProvinceid(Long id) {
        return areaDAO.findSubAreas(id);
    }

    @Override
    public List<Area> findAllProvinces() {
        return areaDAO.getTopAreas();
    }

}
