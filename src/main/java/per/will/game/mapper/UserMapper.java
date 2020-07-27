package per.will.game.mapper;


import per.will.game.dto.UserDTO;

import java.util.List;

/**
 * Created by 01467885 on 2020/6/19.
 */
public interface UserMapper {

    public UserDTO getUserById(Integer id);

    public UserDTO getUserByUserName(String userName);

    public List<UserDTO> getUserList(UserDTO userParam);

    public Integer insertUser(UserDTO userParam);

    public Integer updateUser(UserDTO userParam);

    public Integer deleteUser(Integer id);

}
