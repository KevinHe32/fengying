package com.wshop.damain;

/**
 * Created by dell on 2017/7/20.
 */

public class Page <E> extends java.util.ArrayList<E> {
    private static final long serialVersionUID = 1L;
    private static final int NO_SQL_COUNT = -1;
    private static final int SQL_COUNT = 0;
    private int pageNum;
    private int pageSize;
    private int startRow;
    private int endRow;
    private long total;
    private int pages;
    private java.lang.Boolean reasonable;
    private java.lang.Boolean pageSizeZero;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static int getNoSqlCount() {
        return NO_SQL_COUNT;
    }

    public static int getSqlCount() {
        return SQL_COUNT;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Boolean getReasonable() {
        return reasonable;
    }

    public void setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
    }

    public Boolean getPageSizeZero() {
        return pageSizeZero;
    }

    public void setPageSizeZero(Boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }
}
