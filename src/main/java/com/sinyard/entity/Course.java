package com.sinyard.entity;

import java.io.Serializable;

public class Course implements Serializable {
    private Integer courseid;

    private String coursetitle;

    private String coursecontent;

    private static final long serialVersionUID = 1L;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
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
        sb.append(", coursetitle=").append(coursetitle);
        sb.append(", coursecontent=").append(coursecontent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}