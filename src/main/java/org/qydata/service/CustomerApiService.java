package org.qydata.service;

import org.qydata.entity.Api;

import java.util.List;

/**
 * Created by jonhn on 2016/11/8.
 */
public interface CustomerApiService {

    /**
     * 查询供应商Api所有数据
     * @return
     */
    public List<Api> findAllApi();

    /**
     * 插入
     * @param price
     * @param customerId
     * @param apiId
     * @param enabled
     * @return
     */
    public boolean insertCustomerApi(String price, String customerId, String apiId, String enabled);
}
