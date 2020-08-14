package com.sinyard.entity;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
    private Integer courseid;

    private Integer pid;

    private Integer leve;

    private String coursetitle;

    private String coursecontent;

    private List<Course> listCourse;

    public List<Course> getListCourse() {
        return listCourse;
    }

    public void setListCourse(List<Course> listCourse) {
        this.listCourse = listCourse;
    }

    private static final long serialVersionUID = 1L;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getLeve() {
        return leve;
    }

    public void setLeve(Integer leve) {
        this.leve = leve;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle == null ? null : coursetitle.trim();
    }

    public String getCoursecontent() {
        return coursecontent;
    }

    public void setCoursecontent(String coursecontent) {
        this.coursecontent = coursecontent == null ? null : coursecontent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseid=").append(courseid);
        sb.append(", pid=").append(pid);
        sb.append(", leve=").append(leve);
        sb.append(", coursetitle=").append(coursetitle);
        sb.append(", coursecontent=").append(coursecontent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}