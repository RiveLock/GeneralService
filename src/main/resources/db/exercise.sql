create DATABASE exercise DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- auto-generated definition
create table examination
(
    id           int          not null
        primary key,
    question     varchar(900) null comment '问题',
    type         int          null comment '题目种类',
    created_time timestamp    null,
    updated_time timestamp    null
)
    comment '考题表';



-- auto-generated definition
create table examination_content
(
    id            int auto_increment
        primary key,
    examinationId int          null comment '考题id',
    content       varchar(900) null comment '内容',
    answer        varchar(600) null comment '答案',
    created_time  timestamp    null,
    updated_time  timestamp    null
)
    comment '考题内容表';



-- auto-generated definition
create table user_answer
(
    id            int auto_increment
        primary key,
    examinationId int       null comment '考题id',
    answer        int       null comment '用户回答',
    created_time  timestamp null,
    updated_time  timestamp null
)
    comment '用户回答表';



