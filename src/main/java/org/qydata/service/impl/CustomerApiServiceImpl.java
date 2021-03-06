package org.qydata.service.impl;

import org.qydata.dao.CustomerApiMapper;
import org.qydata.entity.Api;
import org.qydata.entity.CustomerApi;
import org.qydata.service.CustomerApiService;
import org.qydata.vo.ChangeIp;
import org.qydata.vo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2016/11/8.
 */
@Service
public class CustomerApiServiceImpl implements CustomerApiService{
    @Autowired
    private CustomerApiMapper customerApiMapper;
    @Override
    public List<Api> findAllApi() {
        return customerApiMapper.findAllApi();
    }

    @Override
    public boolean insertCustomerApi(String price, String customerId, String apiId, String enabled)throws Exception {
        CustomerApi customerApi = new CustomerApi();
        boolean flag = false;
        List<String> listPrice = ChangeIp.spiltIp(price);
        List<String> listCustomerId = ChangeIp.spiltIp(customerId);
        List<String> listApiId = ChangeIp.spiltIp(apiId);
        List<String> listEnabled = ChangeIp.spiltIp(enabled);
        for (int i=0;i<listPrice.size();i++){
            customerApi.setPrice(Integer.parseInt(listPrice.get(i)));
            customerApi.setCustomerId(Integer.parseInt(listCustomerId.get(i)));
            customerApi.setApiId(Integer.parseInt(listApiId.get(i)));
            customerApi.setEnabled(Boolean.parseBoolean(listEnabled.get(i)));
            flag= customerApiMapper.insertCustomerApi(customerApi);
        }
        return flag;
    }

    @Override
    public PageModel<CustomerApi> findAllByCustomerId(Map<String, Object> map) {
        PageModel<CustomerApi> pageModel = new PageModel<CustomerApi>();
        pageModel.setList(customerApiMapper.findAllByCustomerId(map));
        pageModel.setRows(customerApiMapper.getAllCountByCustomerId(map));
        return pageModel;
    }

    @Override
    public boolean updateCustomerApiById(CustomerApi api)throws Exception {
        return customerApiMapper.updateCustomerApiById(api);
    }

    @Override
    public CustomerApi findById(Integer id) {
        return customerApiMapper.findById(id);
    }
}
