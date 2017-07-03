package com.web.dao;

import java.util.List;

import com.web.model.Student;
import com.web.util.Pagination;

/**
 * @author 543363559@qq.com
 * @date 2017年6月26日 下午6:22:42
 */
public interface IStudentDao {
	public List<Student> getAllStudent();

	public Student getStudent(String sno);

	public void insertStudent(Student stu);

	public void deleteStudent(String sno);

	public void updateStudent(Student stu);

	public List<Student> getAllStudent(Pagination pagination);
}
