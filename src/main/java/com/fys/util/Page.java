package com.fys.util;

/**
 *  分页
 */
public class Page {
    //总共的页数
    private int totalPage;

    //当前的页数
    private int currentPage;

    //每页显示的条数
    private int pageSize =10;

    //总记录数
    private int totalCount;

    //是否有上一页
    private boolean hasPrePage;

    //是否有下一页
    private boolean hasNextPage;

    //开始的页数
    private int beginPage = 1;

    public Page(int totalCount, int currentPage) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
    }

    /**
     * 初始化总页数
     */
    public void init() {
        totalPage = totalCount % pageSize != 0 ? totalCount / pageSize + 1 : totalCount/ pageSize;
        setTotalPage(totalPage);
        setHasPrePage(beginPage < currentPage);
        setHasNextPage(currentPage < totalPage);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }
}