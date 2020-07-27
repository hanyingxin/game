package per.will.game.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 01467885 on 2020/6/19.
 */
public class BasicDTO implements Serializable {

    private Date createTime;
    private String creator;
    private Date updateTime;
    private String updater;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
