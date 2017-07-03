/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.test;

import com.web.model.Student;
import com.web.util.DaoFactory;
import com.web.util.Pagination;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class DaoTest {
    
    public static void main(String[] args) {
                
//        Student stu = new Student("9544444", "李四", "男", 20, "计算机系");
//        DaoFactory.getStudentDao().insertStudent(stu);
//        
//        List<Student> students = DaoFactory.getStudentDao().getAllStudent();
//        for (Student s : students) {
//            System.out.println(s.getSno() + " : " + s.getSname());
//        }
        
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        
        List<Student> students = DaoFactory.getStudentDao().getAllStudent(pagination);
        for (Student s : students) {
            System.out.println(s.getSno() + " : " + s.getSname() + ":" + s.getSage());
        }
        
    }
    
}
