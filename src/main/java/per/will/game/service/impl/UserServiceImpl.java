package per.will.game.service.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import per.will.game.mapper.UserMapper;
import per.will.game.service.UserService;
import per.will.game.config.MybatisConfig;

/**
 * Created by will on 2020/6/19.
 */
public class UserServiceImpl implements UserService {

    SqlSessionFactory sqlSessionFactory = MybatisConfig.getSqlSessionFactory();
    UserMapper userMapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);

    @Override
    public boolean login(String userName, String password) {
        return null == userMapper.getUserByUserName(userName) ? false : true;
    }
}
