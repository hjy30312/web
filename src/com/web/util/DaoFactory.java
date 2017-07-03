package com.web.util;

import com.web.dao.ICourseDao;
import com.web.dao.IStudentDao;
import com.web.dao.impl.CourseDao;
import com.web.dao.impl.StudentDao;

/**
 * 数据访问工厂类
 * @author Administrator
 */
public class DaoFactory {
    
    public static IStudentDao getStudentDao() {
        return new StudentDao();
    }
    public static ICourseDao getCourseDao() {
        return new CourseDao();
    }
}
