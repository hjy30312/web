<%-- 
    Document   : index
    Created on : 2017-6-5, 18:35:43
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="/WEB-INF/tlds/mytag" %>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <title>学生信息管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/pintuer.css">
        <script src="js/jquery.js"></script>
        <script src="js/pintuer.js"></script>
    </head>
    <body>
        <!--头部开始 ctrl+/-->

        <%@include file="WEB-INF/jspf/header.jsp" %>
        <!--头部结束-->

        <!--内容开始-->
        <div class="container padding-big-top padding-big-bottom">
            <div class="line">
                <div class="xl12 xs3 xm3 xb3">
                    <div class="panel">
                        <div class="panel-head">友情链接</div>
                        <div class="panel-body">
                            <ul class="list-group">
                                <li>电信学院</li>
                                <li>机械学院</li>
                                <li>汽车学院</li>
                                <li>经管学院</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="xl12 xs9 xm9 xb9 padding-small-top">
                    <div class="margin-big-left padding-big">
                        <form method="post" action="UpdateStudentDo">
                            <div class="form-group">
                                <div class="label">
                                    <label for="sno">学号</label>
                                </div>
                                <div class="field">
                                    <input type="text" value="${stu.sno}" readonly class="input" id="sno" name="sno" size="50" placeholder="学生学号" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="label">
                                    <label for="sname">姓名</label>
                                </div>
                                <div class="field">
                                    <input type="text" value="${stu.sname}" class="input" id="sname" name="sname" size="50" placeholder="学生姓名" data-validate="required:必填"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="label">
                                    <label for="ssex">性别</label>
                                </div>
                                <div class="field">
                                    <div class="button-group radio">
                                        <c:if test="${stu.ssex =='男'}">
                                            <label class="button active">
                                                <input name="ssex" value="男" checked="checked" type="radio"><span class="icon icon-male"></span> 男
                                            </label>
                                            <label class="button">
                                                <input name="ssex" value="女" type="radio"><span class="icon icon-female"></span> 女
                                            </label>
                                        </c:if>
                                        <c:if test="${stu.ssex =='女'}">
                                            <label class="button">
                                                <input name="ssex" value="男" type="radio"><span class="icon icon-male"></span> 男
                                            </label>
                                            <label class="button active">
                                                <input name="ssex" value="女" checked="checked" type="radio"><span class="icon icon-female"></span> 女
                                            </label>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="label">
                                    <label for="sage">年龄</label>
                                </div>
                                <div class="field">
                                    <input type="text" value="${stu.sage}" class="input" id="sage" name="sage" size="50" placeholder="学生年龄" data-validate="required:必填,plusinteger:必须是数字,compare#>15:年龄必须大于15岁,compare#<25:年龄必须小于25岁"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="label">
                                    <label for="sdept">系部</label>
                                </div>
                                <div class="field">
                                    <select class="input" name="sdept">
                                        <mytag:departtag sdept="${stu.sdept}" />
                                    </select>
                                </div>
                            </div>
                            <div class="form-button">
                                <button class="button" type="submit">提交</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <!--内容结束-->

        <!--尾部开始-->
        <%@include file="WEB-INF/jspf/footer.jsp" %>
        <!--尾部结束-->
    </body>
</html>
