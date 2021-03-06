package com.web.dao.impl;

import com.web.dao.IStudentDao;
import com.web.model.Student;
import com.web.util.DatabaseBean;
import com.web.util.Pagination;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 数据访问对象
 *
 * @author Administrator
 */
public class StudentDao implements IStudentDao {

    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<Student>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from tb_student");
            rs = psmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                students.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    @Override
    public Student getStudent(String sno) {
        Student stu = null;
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from tb_student where sno=?");
            psmt.setString(1, sno);
            rs = psmt.executeQuery();
            if (rs.next()) {
                stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return stu;
    }

    @Override
    public void insertStudent(Student stu) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("insert into tb_student values(?,?,?,?,?,?,?,?)");
            psmt.setString(1, stu.getSno());
            psmt.setString(2, stu.getSname());
            psmt.setString(3, stu.getPassword());
            psmt.setString(4, stu.getSsex());
            psmt.setInt(5, stu.getSage());
            psmt.setString(6, stu.getSdept());
            psmt.setDouble(7, stu.getSavggrade());
            psmt.setString(8, stu.getPhoto_url());
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteStudent(String sno) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("delete from tb_student where sno=?");
            psmt.setString(1, sno);
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }

    @Override
    public void updateStudent(Student stu) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("update tb_student set sname=?,ssex=?,sage=?,sdept=? where sno=? ");
            psmt.setString(1, stu.getSname());
            psmt.setString(2, stu.getSsex());
            psmt.setInt(3, stu.getSage());
            psmt.setString(4, stu.getSdept());
            psmt.setString(5, stu.getSno());
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }

    @Override
    public List<Student> getAllStudent(Pagination pagination) {
        List<Student> students = new ArrayList<Student>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from tb_student");
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM tb_student ORDER BY sno ASC) s WHERE ROWNUM<=?) WHERE NO>=?");
            psmt.setInt(1, end);
            psmt.setInt(2, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                students.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return students;

    }

}
