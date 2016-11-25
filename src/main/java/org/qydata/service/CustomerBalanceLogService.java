package org.qydata.service;

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
    public boolean insertcustomerBalanceLog(String authId, String amount,String reasonId);
}
