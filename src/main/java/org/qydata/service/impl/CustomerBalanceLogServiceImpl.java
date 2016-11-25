package org.qydata.service.impl;

import org.qydata.dao.CustomerBalanceLogMapper;
import org.qydata.dao.CustomerMapper;
import org.qydata.entity.Customer;
import org.qydata.entity.CustomerBalanceLog;
import org.qydata.service.CustomerBalanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jonhn on 2016/11/8.
 */
@Service
public class CustomerBalanceLogServiceImpl implements CustomerBalanceLogService{
    @Autowired
    private CustomerBalanceLogMapper customerBalanceLogMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public boolean insertcustomerBalanceLog(String authId, String amount,String reasonId) {
       Customer customer = customerMapper.findByAuthId(authId);
       CustomerBalanceLog customerBalanceLog = new CustomerBalanceLog();
        customerBalanceLog.setCustomerId(customer.getId());
        customerBalanceLog.setAmount(Long.getLong(amount));
        customerBalanceLog.setReasonId(Integer.parseInt(reasonId));
        return customerBalanceLogMapper.insertcustomerBalanceLog(customerBalanceLog);
    }
}
