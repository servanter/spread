package com.zhy.spread.service;

import java.util.List;

import com.zhy.spread.entity.Consume;

public interface ConsumeService {

    /**
     * 根据recommend消费
     * 
     * @author ZhangHongyan
     * @param cousume
     * @return
     */
    public Consume add(Consume consume);

    /**
     * 根据条件获取
     * 
     * @param consume
     * @return
     */
    public List<Consume> findDetailsByConsume(Consume consume);
}
