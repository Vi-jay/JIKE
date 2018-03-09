package com.base.dao.pojo;

public class Pages {
    private Integer id;

    private String pagename;

    private String pagedompath;

    private String page;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename == null ? null : pagename.trim();
    }

    public String getPagedompath() {
        return pagedompath;
    }

    public void setPagedompath(String pagedompath) {
        this.pagedompath = pagedompath == null ? null : pagedompath.trim();
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }
}