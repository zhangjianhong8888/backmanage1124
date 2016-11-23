package org.qydata.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by jonhn on 2016/11/23.
 */
public class Role implements Serializable {

    private Integer rid;
    private String title;
    private String flag;
    private Timestamp createTime;
    private Timestamp timestamp;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", title='" + title + '\'' +
                ", flag='" + flag + '\'' +
                ", createTime=" + createTime +
                ", timestamp=" + timestamp +
                '}';
    }
}
