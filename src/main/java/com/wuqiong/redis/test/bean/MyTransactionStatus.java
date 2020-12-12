package com.wuqiong.redis.test.bean;

import java.io.Serializable;

/**
 * @Description 事务状态
 * @Author Cain
 * @date 2020/11/5
 */
public class MyTransactionStatus implements Serializable {

    private static final long serialVersionUID = 2641859748951186847L;

    private String transactionID;
    private int status;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
