package com.yanld.module.common.dal.dataobject;

/**
 * Created by yanan on 16/8/2.
 */
public class YanldSequenceDO {
    private String tableName;
    private long seq;

    public YanldSequenceDO() {
    }

    public YanldSequenceDO(String tableName, long seq) {
        this.tableName = tableName;
        this.seq = seq;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
