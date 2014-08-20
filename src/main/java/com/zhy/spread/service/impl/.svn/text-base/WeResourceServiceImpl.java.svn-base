package com.zhy.spread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.dao.WeResourceDAO;
import com.zhy.spread.entity.WeResource;
import com.zhy.spread.service.WeResourceService;

@Service
public class WeResourceServiceImpl implements WeResourceService {

    @Autowired
    private WeResourceDAO weResourceDAO;
    
    @Override
    public WeResource addOrModify(WeResource weResource) {
        return weResourceDAO.saveOrUpdate(weResource);
    }

}
