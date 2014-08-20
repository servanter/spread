package com.zhy.spread.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.common.Paging;
import com.zhy.spread.dao.RechargeDAO;
import com.zhy.spread.entity.Recharge;
import com.zhy.spread.service.RechargeService;
import com.zhy.spread.util.DateUtils;
import com.zhy.spread.util.RandomUtils;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private RechargeDAO rechargeDAO;
    
    @Override
    public Paging<Recharge> findDetailsByUserId(Recharge recharge) {
        return rechargeDAO.getDetailsByUserId(recharge);
    }

    @Override
    public Recharge add(Recharge recharge) {
        Date start = new Date();
        String startTime = DateUtils.date2Str(start);
        Date end = new Date();
        end.setDate(end.getDate() - 1);
        String endTime = DateUtils.date2Str(end);
        recharge.setRechargeOrderId(DateUtils.date2Str("yyyyMMddHHmmss", new Date()) + (rechargeDAO.getMaxId(startTime, endTime) + 1) + RandomUtils.generateNumberString(6));
        return rechargeDAO.save(recharge);
    }

}
