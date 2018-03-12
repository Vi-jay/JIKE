package com.base.bean;

import com.base.dao.pojo.ReportWithBLOBs;

import java.util.ArrayList;
import java.util.List;

public class Datagrid<T> {
    private long total;
    private List<T> rows = new ArrayList<T>();

    public Datagrid() {
        super();
    }

    public Datagrid(long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return  rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

}
