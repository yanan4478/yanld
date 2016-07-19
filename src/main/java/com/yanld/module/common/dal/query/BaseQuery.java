package com.yanld.module.common.dal.query;

/**
 * Created by yanan on 16/7/18.
 */
public class BaseQuery {
    protected int limit;
    protected int offset;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
