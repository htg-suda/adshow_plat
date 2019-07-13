create database sirui_ad_platform charset utf8;
use sirui_ad_platform;


alter table sr_agency modify create_user int  not null comment '创建人的id';
alter table sr_agency modify update_user int  not null comment '创建人的id';


alter table sr_device modify create_user int  not null comment '创建人的id';
alter table sr_device modify update_user int  not null comment '创建人的id';

alter table sr_scheduling modify create_user int  not null comment '创建人的id';
alter table sr_scheduling modify update_user int  not null comment '创建人的id';

alter table sr_scheduling_show_rel modify create_user int  not null comment '创建人的id';
alter table sr_scheduling_show_rel modify update_user int  not null comment '创建人的id';


alter table sr_scheduling_device_rel modify create_user int  not null comment '创建人的id';
alter table sr_scheduling_device_rel modify update_user int  not null comment '创建人的id';

alter table sr_show modify create_user int  not null comment '创建人的id';
alter table sr_show modify update_user int  not null comment '创建人的id';



/* todo 商户端要有机构字段 */
create table sr_agency(
    id int primary key auto_increment comment '机构id',
    parent_id int not null default 0 comment '父机构id,0为根节点',
    num varchar(50) not null unique key comment '机构编号',
    name varchar(100) unique key comment '机构名',
    contact varchar(50) not null comment '机构联系人',
    contact_num varchar(20) not null  comment '机构联系手机号码',
    province  int(11) not null null comment '省',
    city int(11) not null comment '市',
    county int(11) not null comment '县/区',
    address_detail varchar(100) not null  comment '地址详情',
    remark varchar(255) comment '机构备注',
    sort tinyint default 0 comment '分类排序字段 0~100,越小越靠前',
    /* 附带信息 */
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int  not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)charset utf8 comment '机构表';



drop table if exists sr_device;
/*todo 终端设备表,设备音量 ,关机时间是什么意思? 要存在表里面吗,还是要单个设备详情里,商户编号怎么获取*/
create table sr_device(
    id int primary key  auto_increment comment '设备id',
    name varchar(50) default null comment '设备名',
    num varchar(50) unique  not null comment  '设备编号',
    sn varchar(100) unique not null comment '终端序列号码',
    type int not null comment '设备类型, 1-投影仪,2-直立屏幕,3-86盒',
    seller_sn int not null comment '商户编号',
    seller_name varchar(50) not null  comment '商户名',
    height smallint not null default 0 comment '屏幕 高度 1920',
    width smallint not null default 0 comment '屏幕 宽度 1080',
    mac varchar(30) unique key not null comment '设备mac 地址',
    ip_address varchar(30) comment 'IP 地址',
    port varchar(10) comment '端口号',
    province  int(11) default null comment '省',
    city int(11) default null comment '市',
    county int(11) default null comment '县/区',
    address_detail varchar(100)  default null comment '地址详情',
    longitude varchar(20) comment '设备所在经度',
    latitude varchar(20) comment '设备所在纬度',

    spec varchar(255) comment '设备规格',
    remark varchar(255) comment '设备备注',
    volume smallint not null  default 0 comment '音量',

    system_version varchar(50) comment '系统版本',
    app_version varchar(50) comment '应用版本',

    status tinyint not null comment '设备认证状态,0-未认证,1-启用,2-停用',
    online_status tinyint comment '设备在线状态,0-离线,1-在线,2-未知',
    open_time varchar(20) default '10:00:00' comment  '每天的开机时间',
    close_time varchar(20) default '22:00:00' comment '每天的关机时间',

    /* 附带信息 */
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)charset utf8 comment '终端设备表';


alter table sr_scheduling add column   day_in_week varchar(20) not null comment '播放周次 1,2,3... '  after play_mode;
alter table sr_scheduling add column   download_time datetime not null comment '节目下载时间'  after day_in_week;
alter table sr_scheduling add column    remark varchar(255) default null comment '备注'  after download_time;

create table sr_scheduling(
   id int primary key  auto_increment comment '排期id',
   name varchar(20) not null comment '排期名称',
   release_type tinyint not null comment '发布类型 1-默认独播放,2-轮播,3-插播',
   play_mode tinyint not null comment '播放模式 1-在线播放,2-本地播放 ',
   day_in_week varchar(20) not null comment '播放周次 1,2,3... ',
   download_time datetime not null comment '节目下载时间',
   remark varchar(255) default null comment '备注',
   start_time datetime not null comment '节目开始时间',
   end_time datetime not null comment '节目结束时间',
    /* 附带信息 */
   del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
   create_user int not null comment '创建人的id',
   update_user int not null comment '更新人的id',
   create_time datetime not null comment '创建时间',
   update_time datetime not null comment '更新时间'
)charset utf8 comment '节目排期表';


insert into sr_scheduling values
                                 (1,'hello',1,1,now(),now(),0,0,0,now(),now()),
                                 (2,'java',1,1,now(),now(),0,0,0,now(),now()),
                                 (3,'001',1,1,now(),now(),0,0,0,now(),now()),
                                 (4,'main',1,1,now(),now(),0,0,0,now(),now()),
                                 (5,'idea',1,1,now(),now(),0,0,0,now(),now());

create table sr_scheduling_show_rel(
    id int primary key  auto_increment comment '关系id',
    show_id int not null comment '节目ID',
    scheduling_id int not null comment '排期ID',

    /* 附带信息 */
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
) charset utf8 comment '排期节目关系表';


insert into sr_scheduling_show_rel values
                                          (6,2,1,0,0,0,now(),now()),
                                          (7,3,1,0,0,0,now(),now()),
                                          (8,4,1,0,0,0,now(),now()),
                                          (9,5,1,0,0,0,now(),now());


create table sr_scheduling_device_rel(
    id int primary key  auto_increment comment '关系id',
    device_id int not null comment '设备ID',
    scheduling_id int not null comment '排期ID',
    /* 附带信息 */
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
) charset utf8 comment '排期设备关系表';

insert into sr_scheduling_device_rel values (1,1,1,0,0,0,now(),now());
insert into sr_scheduling_device_rel values (2,1,2,0,0,0,now(),now());


create table sr_show(
   id int primary key auto_increment comment '节目ID',
   name varchar(50) not null comment '节目名称',
   num varchar(50) not null unique key comment '节目编号',
   url varchar(255) not null comment '节目URL 地址',
   main_img_url varchar(255) not null comment '节目主图url',
   add_by tinyint not null default 1 comment '节目制作方 1-平台,2-商户',
   author_id int not null comment '作者id',
   del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
   create_user int not null comment '创建人的id',
   update_user int not null comment '更新人的id',
   create_time datetime not null comment '创建时间',
   update_time datetime not null comment '更新时间'
)charset utf8 comment '节目表';


/* 消息记录表 */
create table sr_msg_record(
   id int primary key auto_increment comment '消息ID',
   num varchar(50) not null unique key comment '消息编号',
   type smallint not null  comment '消息类型',
   tag varchar(50) not null comment '消息说明',
   sn varchar(50) not null comment '设备序列号',
   initiator varchar(50) not null comment '消息发起人',
   start_time datetime not null  comment '消息发起时间',
   end_time datetime default null comment '消息结束时间',
   status tinyint default 0 comment '0-待完成, 1-已完成,2-未知',
   del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
   create_user int not null comment '创建人的id',
   update_user int not null comment '更新人的id',
   create_time datetime not null comment '创建时间',
   update_time datetime not null comment '更新时间'
)charset utf8 comment '消息记录表';


/*播放记录表*/
create table sr_play_record(
   id int primary key auto_increment comment '播放记录ID',
   sn varchar(50) not null comment '设备序列号',
   show_id int not null comment '节目id',
   frequency int not null  comment '播放次数',
   day datetime not null comment '播放日期 如 2019-10-10',
   del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
   create_user int not null comment '创建人的id',
   update_user int not null comment '更新人的id',
   create_time datetime not null comment '创建时间',
   update_time datetime not null comment '更新时间'
)charset utf8 comment '播放记录表';




insert into sr_show values
                           (1,'tomcat','132433124321','/show/zip/001.zip','/show/zip/001.png',1,2,0,0,0,now(),now()),
                           (2,'星球大战','132433124322','/show/zip/002.zip','/show/zip/002.png',1,2,0,0,0,now(),now()),
                           (3,'007','132433124323','/show/zip/003.zip','/show/zip/003.png',1,2,0,0,0,now(),now()),
                           (4,'蜘蛛侠','132433124324','/show/zip/004.zip','/show/zip/004.png',1,2,0,0,0,now(),now()),
                           (5,'无间道','132433124325','/show/zip/005.zip','/show/zip/005.png',1,2,0,0,0,now(),now());







create table student(
    id int  primary key  comment 'id',
    name varchar(20) unique key  comment '姓名'
);

insert into student(id,name) values (1,'tom'),(2,'lin'),(3,'joy'),(4,'hanmei');

create table teacher(
    id int primary key comment 'id',
    name varchar(20) unique key comment '姓名'
);



insert into teacher(id,name) values (1,'张老师'),(2,'黄老师'),(3,'杨老师'),(4,'蒋老师');


create table tec_stu_rel(
    id int  primary key auto_increment,
    stu_id int,
    tec_id int
);
insert into tec_stu_rel(stu_id, tec_id) values
                                               (1,1),(1,2),(1,3),(1,4),
                                               (2,1),(2,3),
                                               (3,3),(3,4),
                                               (4,1),(4,2),(4,3);

select  ST.name,TSR.stu_id ,TE.name from student ST inner join tec_stu_rel TSR on ST.id=TSR.stu_id inner join teacher TE on TSR.tec_id=TE.id;




