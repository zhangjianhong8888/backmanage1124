package org.qydata.service;

import org.qydata.entity.Api;
import org.qydata.entity.CustomerApi;
import org.qydata.vo.PageModel;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据客户Id查找指定客户的所有CustomerApi
     * @param map
     * @return
     */
    public PageModel<CustomerApi> findAllByCustomerId(Map<String,Object> map);
    /**
     * 根据Id修改
     * @param api
     * @return
     */
    public boolean updateCustomerApiById(CustomerApi api);
    /**
     * 根据Id查找
     * @param id
     * @return
     */
    public CustomerApi findById(Integer id);
}
