package org.qydata.vo;

import java.util.List;

/**
 * Created by jonhn on 2016/11/10.
 */
public class PageModel<T> {
    private Integer pageSize;//每页条数
    private Integer cpage;//当前页
    private Integer rows;//总条数
    private int totalpage;//总页数
    private int beginIndex;//起始页
    private int endIndex;//结束页
    private List<T> list;//集合

    public void setCpage(Integer cpage) {
        this.cpage = cpage;
    }

    /**
     * 获取当前页数
     *
     * @return
     */
    public int getCpage() {
        int _cpage = 1;
        if (cpage != null) {
            try {
                _cpage = cpage;
            } catch (Exception ex) {
            }

        }
        return _cpage;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 每页多少条
     *
     * @return
     */
    public int getPageSize() {
        int _pageSize = 20;
        if (pageSize != null) {
            try {
                _pageSize = pageSize;
            } catch (Exception ex) {
            }

        }
        return _pageSize;
    }

    /**
     * 获取第一条数据在表中的索引
     *
     * @return
     */
    public int getBeginIndex() {
        int _beginIndex = (getCpage() - 1) * getPageSize();
        return _beginIndex;
    }

    public int getEndIndex() {

        return getBeginIndex()+getPageSize();

    }

    public List<T> getList() {
        return list;
    }

    /**
     * 获取总条数
     *
     * @return
     */
    public int getRows() {
        int _rows = 0;
        if (rows != null) {
            try {
                _rows = rows;
            } catch (Exception ex) {
            }
        }
        return _rows;
    }

    /**
     * 共多少页
     *
     * @return
     */
    public int getTotalpage() {
        // 得到总条数
        int _totalpage = 0;
        int rows = getRows();
        int pagesize = getPageSize();
        if (rows % pagesize == 0) {
            _totalpage = rows / pagesize;
        } else {
            _totalpage = rows / pagesize + 1;
        }
        return _totalpage;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

}
