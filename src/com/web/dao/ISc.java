package com.web.dao;

/**
 * @author 543363559@qq.com
 * @date 2017年6月26日 下午6:20:47
 */
public interface ISc {
	public void getGrade(String sno, String cno);
	public void deleteGrade(String sno, String cno);
	public void updateGrade(String sno, String cno);
	public void getStudentGrade(String sno);
}
