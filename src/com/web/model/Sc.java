/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.model;

/**
 *
 * @author Administrator
 */
public class Sc {
    String sno;     //学生名
    String cno;     //课程编号
    Double grade;   //成绩
    
    Student student;
    Course course;
    
    public Sc(){
        
    }
    public Sc(String sno, String cno, Double grade) {
        this.sno = sno;
        this.cno = cno;
        this.grade = grade;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
