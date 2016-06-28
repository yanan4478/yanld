package com.yanld.module.service;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by yanan on 16/6/20.
 */
public class HomeService {

    public List<String> getDoudous(int perPage) {
        String[] dous = new String[perPage];
        for (int i = 1; i <= perPage; i++) {
            dous[i - 1] = "dou" + i;
        }
        return Lists.newArrayList(dous);
    }

    public void print() {
        System.out.println("调用一把");
    }
}
