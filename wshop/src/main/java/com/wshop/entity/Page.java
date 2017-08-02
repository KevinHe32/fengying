package com.wshop.entity;

import java.util.ArrayList;

public class Page<E> extends ArrayList<E> {
    private static final long serialVersionUID = 1L;
    private static final int NO_SQL_COUNT = -1;
    private static final int SQL_COUNT = 0;
    private int pageNum;
    private int pageSize;
    private int startRow;
    private int endRow;
    private long total;
    private int pages;
    private Boolean reasonable;
    private Boolean pageSizeZero;

    public Page() {
        this.pageSize = 10;
    }

    public Page(int pageNum, int pageSize) {
        this(pageNum, pageSize, 0, (Boolean)null);
    }

    public Page(int pageNum, int pageSize, boolean count) {
        this(pageNum, pageSize, count?0:-1, (Boolean)null);
    }

    private Page(int pageNum, int pageSize, int total, Boolean reasonable) {
        super(pageSize > -1?(pageSize > 100?100:pageSize):0);
        this.pageSize = 10;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = (long)total;
        this.calculateStartAndEndRow();
        this.setReasonable(reasonable);
    }

    public Page<E> getResult() {
        return this;
    }

    public boolean firstPage() {
        return this.pageNum <= 1;
    }

    public boolean lastPage() {
        return this.pageNum >= this.pages;
    }

    public int getPages() {
        return this.pages;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getEndRow() {
        return this.endRow;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = this.reasonable != null && this.reasonable.booleanValue() && pageNum <= 0?1:pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartRow() {
        return this.startRow;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
        if(this.pageSize > 0) {
            this.pages = (int)(total / (long)this.pageSize + (long)(total % (long)this.pageSize == 0L?0:1));
        } else {
            this.pages = 0;
        }

        if(this.reasonable != null && this.reasonable.booleanValue() && this.pageNum > this.pages) {
            this.pageNum = this.pages;
            this.calculateStartAndEndRow();
        }

    }

    public void setReasonable(Boolean reasonable) {
        if(reasonable != null) {
            this.reasonable = reasonable;
            if(this.reasonable.booleanValue() && this.pageNum <= 0) {
                this.pageNum = 1;
                this.calculateStartAndEndRow();
            }

        }
    }

    public Boolean getReasonable() {
        return this.reasonable;
    }

    public Boolean getPageSizeZero() {
        return this.pageSizeZero;
    }

    public void setPageSizeZero(Boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }

    private void calculateStartAndEndRow() {
        this.startRow = this.pageNum > 0?(this.pageNum - 1) * this.pageSize:0;
        this.endRow = this.startRow + this.pageSize * (this.pageNum > 0?1:0);
    }

    public boolean isCount() {
        return this.total > -1L;
    }

    public String toString() {
        return "PageList{pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ", startRow=" + this.startRow + ", endRow=" + this.endRow + ", total=" + this.total + ", pages=" + this.pages + '}';
    }
}
