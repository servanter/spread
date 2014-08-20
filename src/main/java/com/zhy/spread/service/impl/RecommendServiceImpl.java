package com.zhy.spread.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.dao.RecommendDAO;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.service.RecommendService;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendDAO recommendDAO;

    @Override
    public Recommend addOrModify(Recommend recommend) {
        return recommendDAO.saveOrUpdate(recommend);
    }

    @Override
    public List<Recommend> findAllRecommends() {
        return recommendDAO.getAllRecommends();
    }

    @Override
    public Recommend findById(Long id) {
        return recommendDAO.getById(id);
    }

}
