package org.qydata.dao;

import org.qydata.entity.CustomerBalanceLog;

/**
 * Created by jonhn on 2016/11/8.
 */
public interface CustomerBalanceLogMapper {
    /**
     * 余额变动日志
     * @param customerBalanceLog
     * @return
     */
    public boolean insertcustomerBalanceLog(CustomerBalanceLog customerBalanceLog);
}
