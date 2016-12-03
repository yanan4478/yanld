package com.yanld.module.common.dal.dataobject.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：无限级分类 tree信息
 * 作者：袁伟倩
 * 创建日期：2016-12-03/12/3.
 */

public class TreeBean {
    /**
     * String 树节点名称
     */
    private String text;
    /**
     * List 子节点信息
     */
    private List<TreeBean> children;
    /**
     * Boolean 是否是叶节点
     */
    private Boolean leaf = true;

    private String id;


    //-------------------------------set get
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeBean> getChildren() {
        return children;
    }

    public void setChildren(List<TreeBean> children) {
        this.children = children;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
