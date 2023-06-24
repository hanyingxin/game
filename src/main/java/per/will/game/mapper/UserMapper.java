package per.will.game.mapper;


import per.will.game.domain.dto.User;

import java.util.List;

/**
 * Created by will on 2020/6/19.
 */
public interface UserMapper {

    User getUserById(Integer id);

    User getUserByUserName(String userName);

    List<User> getUserList(User userParam);

    Integer insertUser(User userParam);

    Integer updateUser(User userParam);

    Integer deleteUser(Integer id);

}
