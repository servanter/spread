package com.zhy.spread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.dao.ConfigDAO;
import com.zhy.spread.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigDAO configDAO;
    
    @Override
    public String getValue(String key) {
        return configDAO.getValue(key);
    }

}
