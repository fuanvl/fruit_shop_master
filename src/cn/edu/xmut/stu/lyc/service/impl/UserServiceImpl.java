package cn.edu.xmut.stu.lyc.service.impl;

import cn.edu.xmut.stu.lyc.base.BaseDao;
import cn.edu.xmut.stu.lyc.base.BaseServiceImpl;
import cn.edu.xmut.stu.lyc.mapper.UserMapper;
import cn.edu.xmut.stu.lyc.po.User;
import cn.edu.xmut.stu.lyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseDao<User> getBaseDao() {
        return userMapper;
    }
}
