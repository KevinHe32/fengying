/*
 * Copyright(c) 2017 kashuo.net All rights reserved.
 */
package com.wshop.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wshop.damain.Page;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultList<T extends Object> extends AbstractResult {
    private List<T> dataList; //列表数据
    private Integer totalPage; //总页数
    private Integer totalNumber;//总条数
    private Integer pageIndex; //当前页
    private Integer pageSize;  //当前页条数

    @SuppressWarnings(value = "unchecked")
    public static <T> ResultList<T> ok() {
        return new ResultList(0, null);
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> ResultList<T> error() {
        return new ResultList(1, null);
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> ResultList<T> error(int code) {
        return new ResultList(code, null);
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> ResultList<T> error(int code, String message) {
        return new ResultList(code, message);
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> ResultList<T> list(Page<T> datas) {
        ResultList<T> res =  new ResultList(0, null);
        res.dataList = datas;
        res.totalPage = datas.getPages();
        res.totalNumber = (int)datas.getTotal();
        res.pageIndex = datas.getPageNum();
        res.pageSize = datas.getPageSize();
        return res;
    }

    @SuppressWarnings(value = "unchecked")
    @Deprecated
    public static <T> ResultList<T> list(List<T> datas) {
        ResultList<T> res =  new ResultList(0, null);
        res.dataList = datas;
        return res;
    }


    public ResultList() {
        this(0, null);
    }


    public ResultList(int code, String message) {
        super(code, message);
    }

    public ResultList<T> list(List<T> objs, int pageSize, int totalNumber, int pageIndex) {
        this.dataList = objs;
        totalPage = totalNumber % pageSize == 0 ? totalNumber / pageSize : totalNumber / pageSize + 1;
        this.totalNumber = totalNumber;
        this.pageIndex = pageIndex;
        return this;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    //总条数
    public Integer getObjectotalNumber() {
        return totalNumber;
    }

    public void setObjectotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public Integer getObjectotalPage() {
        return totalPage;
    }

    public void setObjectotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
