package com.zhy.spread.service;

import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.Recharge;

public interface RechargeService {

    public Recharge add(Recharge recharge);
    
    public Paging<Recharge> findDetailsByUserId(Recharge recharge);
}
