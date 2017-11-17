package com.mock.empapi.empapimock.controller;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

public class PageData<E> {

    private int offset = 0;
    private int limit = 10;
    private List<E> allValues;

    public PageData(Integer offset, Integer limit, Collection<E> allValues) {
        if (offset != null && offset >= 0) {
            this.offset = offset;
        }
        if (limit != null && limit > 0) {
            this.limit = limit;
        }
        this.allValues = Lists.newArrayList(allValues);
    }

    public List<E> getPageValues() {
        int fromIndex = Math.min(offset, allValues.size());
        int toIndex = Math.min(offset + limit, allValues.size());
        return allValues.subList(fromIndex, toIndex);
    }
}