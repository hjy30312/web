package com.web.dao;

import java.util.List;

import com.web.model.Course;
import com.web.util.Pagination;

/**
 * @author 543363559@qq.com
 * @date 2017年6月26日 下午6:20:03
 */
public interface ICourseDao {
	public List<Course> getAllCourse();

	public Course cnoGetCourse(String cno);
	
	public Course cnameGetCourse(String cname);
	
	public void insertCourse(Course course);

	public void deleteCourse(String cno);

	public void updateCourse(Course course);

	public List<Course> getAllCourse(Pagination pagination);
}
