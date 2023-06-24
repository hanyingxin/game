package per.will.game.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by will on 2020/6/19.
 */
@Data
public class BaseDTO implements Serializable {

    private Date created;
    private String creator;
    private Date updated;
    private String updater;
}
