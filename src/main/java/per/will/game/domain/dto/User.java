package per.will.game.domain.dto;

import lombok.Data;

/**
 * 用户实体类
 * Created by will on 2020/3/6.
 */
@Data
public class User extends BaseDTO {

    private Long id;
    private String username;
    private String password;
    private String nickname;
}
