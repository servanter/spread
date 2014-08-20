package com.zhy.spread.service;

import com.zhy.spread.common.ReturnCode;
import com.zhy.spread.entity.Consume;

public interface MoneyService {

    public ReturnCode consume(Consume consume);
    
    public ReturnCode recharge();
}
