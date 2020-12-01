package com.domain;

public class Emp {
    private Integer eid;
    private String ename;
    private String esex;
    private Integer edeptno;
    private Float esalary;

    public Emp() {}

    public Emp(Integer eid, String ename, String esex, Integer edeptno, Float esalary) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.edeptno = edeptno;
        this.esalary = esalary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", edeptno=" + edeptno +
                ", esalary=" + esalary +
                '}';
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public void setEdeptno(Integer edeptno) {
        this.edeptno = edeptno;
    }

    public void setEsalary(Float esalary) {
        this.esalary = esalary;
    }

    public Integer getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public String getEsex() {
        return esex;
    }

    public Integer getEdeptno() {
        return edeptno;
    }

    public Float getEsalary() {
        return esalary;
    }
}
