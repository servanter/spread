package com.zhy.spread.dao;

import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.Recharge;

public interface RechargeDAO {

    public Paging<Recharge> getDetailsByUserId(Recharge recharge);

    public Long getMaxId(String startTime, String endTime);
    
    public Recharge save(Recharge recharge);
}
