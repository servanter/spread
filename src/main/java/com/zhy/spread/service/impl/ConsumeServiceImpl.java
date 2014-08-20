package com.zhy.spread.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.dao.ConsumeDAO;
import com.zhy.spread.entity.Consume;
import com.zhy.spread.service.ConsumeService;
import com.zhy.spread.util.DateUtils;
import com.zhy.spread.util.RandomUtils;

@Service
public class ConsumeServiceImpl implements ConsumeService {

    @Autowired
    private ConsumeDAO consumeDAO;

    @Override
    public Consume add(Consume consume) {
        Date start = new Date();
        String startTime = DateUtils.date2Str(start);
        Date end = new Date();
        end.setDate(end.getDate() - 1);
        String endTime = DateUtils.date2Str(end);
        consume.setConsumeOrderId(DateUtils.date2Str("yyyyMMddHHmmss", new Date())
                + (consumeDAO.getMaxId(startTime, endTime) + 1) + RandomUtils.generateNumberString(6));
        consumeDAO.add(consume);
        return consume;
    }

    @Override
    public List<Consume> findDetailsByConsume(Consume consume) {
        return consumeDAO.getDetailsByConsume(consume);
    }

}
