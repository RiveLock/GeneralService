CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	create_time DATETIME COMMENT '创建时间',
	update_time DATETIME COMMENT '更新时间',
	PRIMARY KEY (id)
);

INSERT INTO user (id, name, age, email, create_time) VALUES
(1, 'Jone', 18, 'test1@baomidou.com', now()),
(2, 'Jack', 20, 'test2@baomidou.com', now()),
(3, 'Tom', 28, 'test3@baomidou.com', now()),
(4, 'Sandy', 21, 'test4@baomidou.com', now()),
(5, 'Billie', 24, 'test5@baomidou.com', now());

