package com.yanld.module.common.constant;

/**
 * Created by yanan on 16/8/15.
 */
public enum DaoOptEnum {
    INSERT("insert.*"),
    LOGIC_DELETE("logicDelete.*"),
    DELETE("delete.*"),
    UPDATE("update.*"),
    SELECT_IDS("select.*Ids"),
    SELECT_QUERY("select.*Query"),
    SELECT_COUNT("select.*Count"),
    SELECT("select.*");

    private String reg;

    DaoOptEnum(String reg) {
        this.reg = reg;
    }

    public String getReg() {
        return reg;
    }

}
