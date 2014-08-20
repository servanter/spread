package com.zhy.spread;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.zhy.spread.service.impl.AreaServiceImplTest;
import com.zhy.spread.service.impl.InfoClassServiceImplTest;
import com.zhy.spread.service.impl.RecommendServiceImplTest;
import com.zhy.spread.service.impl.UserServiceImplTest;
import com.zhy.spread.service.impl.WeChatServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({
    AreaServiceImplTest.class,
    InfoClassServiceImplTest.class,
    RecommendServiceImplTest.class,
    UserServiceImplTest.class,
    WeChatServiceImplTest.class
})
public class AllServiceTest {

}
