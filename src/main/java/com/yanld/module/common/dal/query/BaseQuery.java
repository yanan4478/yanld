package com.yanld.module.common.dal.query;

/**
 * Created by yanan on 16/7/18.
 */
public class BaseQuery {
    protected long limit;
    protected long offset;

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }
}
