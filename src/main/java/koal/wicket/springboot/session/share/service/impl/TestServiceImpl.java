package koal.wicket.springboot.session.share.service.impl;


import org.springframework.stereotype.Service;

import koal.wicket.springboot.session.share.aop.anotation.TransactionalSelf;
import koal.wicket.springboot.session.share.service.TestService;
import koal.wicket.springboot.session.share.service.UserService;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements koal.wicket.springboot.session.share.service.TestService {
    @Resource
    private UserService userService;
    @Resource
    private TestService testService;
    @Override
    @TransactionalSelf
    public int test() {
        return 0+userService.hello();
    }
    @Override
    @TransactionalSelf
    public  int test2(){
        return testService.test();
    }
}
