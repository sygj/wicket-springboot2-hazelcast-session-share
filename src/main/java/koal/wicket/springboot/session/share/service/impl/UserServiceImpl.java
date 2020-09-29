package koal.wicket.springboot.session.share.service.impl;

import org.springframework.stereotype.Service;

import koal.wicket.springboot.session.share.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public int hello() {
        return 2;
    }
}
