/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.test;

import com.web.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CollecitonTest {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        
        for (String s : list) {
            System.out.println(s);
        }
        
        List<Student> students = new ArrayList<Student>();
        
        //Student stu1 = new Student("9512101", "张一", "男", 20, "计算机系");
        //Student stu2 = new Student("9512102", "张二", "女", 20, "计算机系");
        //Student stu3 = new Student("9512103", "张三", "男", 20, "计算机系");
        //Student stu4 = new Student("9512104", "张四", "女", 20, "计算机系");
        
        //students.add(stu1);
        //students.add(stu2);
        //students.add(stu3);
        //students.add(stu4);
        
        for (Student stu : students) {
            System.out.println(stu.getSno() + " : " + stu.getSname());
        }
    }
    
}
