package com.zhy.spread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.common.Constant;
import com.zhy.spread.common.ReturnCode;
import com.zhy.spread.entity.Account;
import com.zhy.spread.entity.AccountStatusEnum;
import com.zhy.spread.entity.Consume;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.service.AccountService;
import com.zhy.spread.service.ConfigService;
import com.zhy.spread.service.ConsumeService;
import com.zhy.spread.service.MoneyService;
import com.zhy.spread.service.RechargeService;
import com.zhy.spread.service.RecommendService;

@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private ConsumeService consumeService;
    
    @Autowired
    private RechargeService rechargeService;
    
    @Autowired
    private ConfigService configService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private RecommendService recommendService;
    
    @Override
    public ReturnCode consume(Consume consume) {
        ReturnCode returnCode = ReturnCode.OK;
        Account account = null;
        if (consume.getAccount() == null) {

            // 如果注册是没有注册账户，则注册账户
            String value = configService.getValue(Constant.CONFIG_ACCOUNT_INIT_MONEY);
            Account acc = new Account();
            acc.setUser(consume.getUser());
            acc.setTotalMoney(Long.parseLong(value));
            acc.setStatus(AccountStatusEnum.AVALIABLE.getCode());
            acc = accountService.add(acc);
            if (acc.getId() != null) {

                // 设置当前账户余额，剩下操作有account操作
                account = acc;
            } else {
                returnCode = ReturnCode.SYSTEM_ERROR;
            }
        } else {
            account = accountService.findById(consume.getAccount().getId());
        }
        if (returnCode == ReturnCode.OK) {
            Recommend recommend = recommendService.findById(consume.getRecommend().getId());
            Integer price = recommend.getPrice();
            if (price > account.getTotalMoney()) {

                // 余额不足
                returnCode = ReturnCode.CONSUME_USER_HAS_NO_MONEY;
            }
            Long surplusMoney = account.getTotalMoney() - price;
            account.setTotalMoney(surplusMoney);
            accountService.modifyAccountMoney(account);
            consume.setAccount(account);
            consume.setPrice(price);
            consume.setCurTotalMoney(account.getTotalMoney());
            consumeService.add(consume);
        }
        return returnCode;
    }

    @Override
    public ReturnCode recharge() {
        return null;
    }

}
