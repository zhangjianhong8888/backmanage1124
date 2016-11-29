package org.qydata.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by jonhn on 2016/11/8.
 */

public class CustomerApi implements Serializable {

    private Integer id;
    private Integer apiId;
    private Integer customerId;
    private Integer price;
    private Boolean enabled;
    private Timestamp createTime;
    private Timestamp timestamp;
    private Api api;
    public CustomerApi(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    @Override
    public String toString() {
        return "CustomerApi{" +
                "id=" + id +
                ", apiId=" + apiId +
                ", customerId=" + customerId +
                ", price=" + price +
                ", enabled=" + enabled +
                ", createTime=" + createTime +
                ", timestamp=" + timestamp +
                ", api=" + api +
                '}';
    }
}
