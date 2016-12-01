package org.qydata.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jonhn on 2016/11/8.
 */
public interface CustomerBalanceLogService {
    /**
     * 余额变动日志
     * @param authId
     * @param amount
     * @param reasonId
     * @return
     */
    @Transactional
    public boolean changeCustomerBalanceLog(String authId, String amount,String reasonId)throws Exception;
}
