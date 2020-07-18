package com.jtr.entriy;

/**
 * @author: lihuizhi
 * @date: 2020/7/17:21:08
 */
public class Dept {
    private  Integer deptno;
    private  String  dname;
    private  String dbsources;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", dbsources='" + dbsources + '\'' +
                '}';
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbsources() {
        return dbsources;
    }

    public void setDbsources(String dbsources) {
        this.dbsources = dbsources;
    }
}
