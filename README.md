1.搭建环境
	1.1 导开发包
		mysql驱动
		beanUtils
		log4j开发
		jstl开发包
	
	1.2 创建组织程序的包
		cn.itcast.domain
		cn.itcast.dao
		cn.itcast.dao.impl
		cn.itcast.service
		cn.itcast.service.impl
		cn.itcast.web.controller
		cn.itcast.web.UI
		cn.itcast.utils
		cn.itcast.exception
		junit.test
		
		WEB-INF/jsp
		
	1.3 为应用创建相应库和表
		create database day14_customer character set utf8 collate utf8_general_ci;
		use day14_customer;
		create table customer
		(
			id varchar(40) primary key,
			name varchar(40) not null,
			gender varchar(4) not null,
			birthday date,
			cellphone varchar(20),
			email varchar(40),
			preference varchar(255),
			type varchar(100) not null,
			description varchar(255)
		);
		
2.建实体

3.写dao

4.写service

5.写web
		
		
		