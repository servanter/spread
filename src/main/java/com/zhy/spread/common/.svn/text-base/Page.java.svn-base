package com.zhy.spread.common;

/**
 * 分页参数<br>
 * 如果pageSize为-1那么全部查询
 * 
 * @author ZhangHongyan
 * 
 */
public class Page {

    /**
     * 默认页大小
     */
    private int pageSize = 20;

    /**
     * 当前页
     */
    private int page = 1;

    /**
     * 从id
     */
    private int sinceCount = 0;

    public Page() {

    }

    public Page(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
        getSinceCountByPage();
    }

    public int getPageSize() {
        return pageSize;
    }

    public Page setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        if (page != 1) {
            sinceCount = (page - 1) * pageSize;
        }
    }

    public int getSinceCount() {
        return sinceCount;
    }

    public void setSinceCount(int sinceCount) {
        this.sinceCount = sinceCount;
    }

    public void getSinceCountByPage() {
        if (page > 1) {
            sinceCount = (page - 1) * pageSize;
        }
    }

}
