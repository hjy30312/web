<%@ page pageEncoding="UTF-8"%>
<div class="container padding-big-top padding-big-bottom">
	<div class="line bg-green">
		<div class="xl12 xs5 xm6 xb7">欢迎光临数据库系统实现课程教学演示系统</div>
		<div class="xl12 xs7 xm6 xb5 text-right ">
			<div class="button-group-little nav-navicon ">
				<div class="button-group text-left">
					<button type="button" class="button bg-blue dropdown-hover">
						学生登录<span class="float-right"></span>
					</button>
					<button type="button" class="button bg-red dropdown-hover">
						管理员登录<span class="float-right"></span>
					</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="line">
		<div class="xl12 xs5 xm6 xb7">
			<button class="button icon-navicon float-right"
				data-target="#header-demo1"></button>
			<a href="#">
				<h2>学生信息管理系统</h2>
			</a>
		</div>
		<div class="xl12 xs7 xm6 xb5 padding-small-top">
			<ul class="nav nav-menu nav-inline nav-navicon" id="header-demo1">
				<li><a href="index.jsp">首页</a></li>
				<li class="active"><a href="DisplayStudent">学生信息管理<span
						class="arrow"></span></a>
					<ul class="drop-menu">
						<li><a href="insertStudent.jsp">添加学生记录</a></li>
					</ul></li>
				<li class="active"><a href="DisplayCourse">课程信息管理<span
						class="arrow"></span></a>
						<ul class="drop-menu">
							<li><a href="insertCourse">添加课程管理</a></li>
						</ul>
				<li><a href="#">选课信息管理</a></li>
			</ul>
		</div>
	</div>
	<hr />
</div>