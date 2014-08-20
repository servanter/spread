package com.zhy.spread.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.dao.InfoClassDAO;
import com.zhy.spread.entity.InfoClass;
import com.zhy.spread.service.InfoClassService;

@Service
public class InfoClassServiceImpl implements InfoClassService {

    @Autowired
    private InfoClassDAO infoClassDAO;

    @Override
    public List<Object> findAllClasses() {
        List<Object> result = new ArrayList<Object>();
        List<InfoClass> classes = infoClassDAO.getAll();
        Collections.sort(classes, new Comparator<InfoClass>() {

            @Override
            public int compare(InfoClass o1, InfoClass o2) {
                if (o1.getParentId() < o2.getParentId()) {
                    return -1;
                } else {
                    return 1;
                }
            }

        });
        List<InfoClass> first = new ArrayList<InfoClass>();
        Map<Long, List<InfoClass>> secound = new HashMap<Long, List<InfoClass>>();
        for (InfoClass clazz : classes) {
            if (clazz.getParentId() == 1) {
                first.add(clazz);
            } else {
                List<InfoClass> smallClasses = new ArrayList<InfoClass>();
                if (secound.containsKey(clazz.getParentId())) {
                    smallClasses = secound.get(clazz.getParentId());
                }
                smallClasses.add(clazz);
            }
        }
        result.add(first);
        result.add(secound);
        return result;
    }

    @Override
    public InfoClass addOrModify(InfoClass infoClass) {
        return infoClassDAO.saveOrUpdate(infoClass);
    }

    @Override
    public List<InfoClass> findSubClasses(Long id) {
        return infoClassDAO.getSubClasses(id);
    }

    @Override
    public List<InfoClass> findTopClasses() {
        return infoClassDAO.getTopClasses();
    }

    @Override
    public InfoClass findById(Long id) {
        return infoClassDAO.getById(id);
    }

}
