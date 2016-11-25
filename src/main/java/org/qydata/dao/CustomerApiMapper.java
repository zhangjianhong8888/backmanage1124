package org.qydata.dao;

import org.qydata.entity.Api;
import org.qydata.entity.CustomerApi;

import java.util.List;

/**
 * Created by jonhn on 2016/11/8.
 */
public interface CustomerApiMapper {
    /**
     * 查询供应商Api所有数据
     * @return
     */
    public List<Api> findAllApi();

    /**
     * 插入
     * @param customerApi
     * @return
     */
    public boolean insertCustomerApi(CustomerApi customerApi);
}
