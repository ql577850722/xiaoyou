drop  table userinfo;
drop  table accountInfo;
drop  table adminInfo;
drop  table photo;
drop  table friend;
drop  table chat;
drop  table talk;
drop  table comments;
drop  table support;
drop  table active;
drop  table activity;

drop view talk_view;
drop view talk_comments_view;
drop view comments_view;

drop sequence seq_u_id;
drop sequence seq_aid;
drop sequence seq_admin_id;
drop sequence seq_photo_id;
drop sequence seq_f_id;
drop sequence chat_id;
drop sequence seq_talk_id;
drop sequence seq_c_id;
drop sequence seq_acid;
drop sequence seq_support_id;
--1.鐢ㄦ埛琛�---------------------------------------------------------------
create table userInfo(
       u_id  int primary key,-- 鐢ㄦ埛ID
       u_name  varchar2(100) not null unique,  --鐢ㄦ埛鍚�
       u_email   varchar2(100) not null unique,  --email
       u_pwd    varchar2(100),--瀵嗙爜
       u_sex    char(4) constraint u_sex check (u_sex in('鐢�,'濂�)),--鎬у埆
       u_birth   varchar2(100),--鍑虹敓鏃ユ湡
       u_province varchar2(50), --鐪佷唤
	   u_city varchar2(50), --鍩庡競
	   u_area varchar2(50), --鍦板尯
       u_school  varchar(100),--瀛︽牎
       u_academy  varchar2(100),--瀛﹂櫌
       u_grade  varchar2(100),--鍏ュ鏃堕棿 
       u_photo  varchar2(200)  ,    --澶村儚
       u_stature  varchar2(100),--韬珮
       u_weight   varchar2(40),--浣撻噸
       u_blood  varchar2(20),--琛�瀷
       u_qq      varchar2(100),--qq鍙�
       u_tel     varchar2(100),--鎵嬫満鍙风爜
       u_wechat  varchar(100),--寰俊鍙�
       u_text  varchar2(50),    --浜ゅ弸瀹ｈ█
       u_status  int ,    --鐘舵�
       u_temp varchar2(200),  --澶囩敤瀛楁
	   u_flag varchar2(1000)  --澶囩敤瀛楁     
);

create sequence seq_u_id start with 10001 increment by 1; --鐢ㄦ埛ID浠�0001寮�

--2.甯愬彿寮傚父璁板綍---------------------------------------------------------------
 create table accountInfo(
	aid int primary key, --缂栧彿
	u_sid int
		constraint FK_userInfo_accountInfo_usid references userInfo(u_id),
	adate date,  --寮傚父鏃堕棿
	edate date,  --缁撴潫鏃堕棿
	a_content varchar2(2000), --鎻愮ず淇℃伅
	a_status int, --鐘舵�
	a_temp varchar2(200),  --澶囩敤瀛楁
	a_flag varchar2(1000)  --澶囩敤瀛楁
);
create sequence seq_aid start with 1 increment by 1; --寮傚父璁板綍浠�寮�鐧昏


--3.绠＄悊鍛樹俊鎭〃-----------------------------------------------------------------
create table adminInfo(
	admin_id int primary key, --缂栧彿
	admin_name varchar2(100) not null unique, --鍚嶅瓧
	admin_pwd varchar2(20), --瀵嗙爜
	admin_status int,   --鐘舵�
  	admin_temp varchar2(200),  --澶囩敤瀛楁
	admin_flag varchar2(1000)  --澶囩敤瀛楁
);
create sequence seq_admin_id start with 1001 increment by 1;  --绠＄悊鍛業D鍙�浠�001寮�

---4.鐩稿唽---------------------------------------------------------------------
create  table  photo(
        photo_id int primary key,    --鐩稿唽缂栧彿
        u_id  int
            constraint FK_photo_u_id references userInfo(u_id),   --鐢ㄦ埛ID
        photo_path varchar2(100),     --鐩哥墖璺緞
        photo_send  int default 0 ,   --涓婁紶鐩哥墖鏄惁鎴愬姛
        photo_check   int default  0 ,    --鍒ゆ柇鏄惁缁忕鐞嗗憳瀹℃牳閫氳繃     0 琛ㄧず姝ｅ湪瀹℃牳涓� 1琛ㄧず瀹℃牳閫氳繃  2琛ㄧず瀹℃牳鏈�杩�
        photo_temp varchar2(200),  --澶囩敤瀛楁
	    photo_flag varchar2(1000)  --澶囩敤瀛楁       
);
create sequence seq_photo_id  start with  1  increment  by   1;


--5.濂藉弸琛�------------------------------------------------------------------------
create table friend(
       f_id  int primary key ,-- 缂栧彿
       u_id   int constraint FK_uid references userInfo(u_id),  --鐢ㄦ埛ID(鏉ヨ嚜浜庣敤鎴疯〃)
       friend_id  int ,  --濂藉弸ID
	   friend_name  varchar2(100),  --濂藉弸鍛㈢О
       friend_status  int default 0,--鐘舵�
       add_time date,  --娣诲姞濂藉弸鏃堕棿
       friend_flag varchar2(300),  --澶囩敤瀛楁  
       friend_temp varchar2(1000) --澶囩敤瀛楁
);
create sequence seq_f_id start with 1 increment by 1;   

----6.鑱婂ぉ-------------------------------------------------------------------------------
create table chat(
       chat_id  int ,  --鑱婂ぉ璁板綍缂栧彿
       chat_user_id  varchar2(20),  --鑷繁鐨刬d
       chat_friend_id   varchar2(20),    --濂藉弸鐨刬d
       chat_text   varchar2(200),     --鍐呭
       chat_time   date  default  sysdate,    --鏃堕棿
       chat_temp varchar2(200),  --澶囩敤瀛楁
	   chat_flag varchar2(1000)  --澶囩敤瀛楁 
);
create sequence chat_id start with 1 increment by 1;

--7銆佽璇�----------------------------------------------------------------------------

create table talk(
       talk_id  int primary key,  --璇磋缂栧彿
       u_id   int constraint FK_u_id references userInfo(u_id),   --鐢ㄦ埛ID
       talk_content  varchar2(900),   --鏂囨湰鍐呭
       talk_image_path  varchar2(100), --鐓х墖璺緞 
       talk_time  date,   --鍙戠殑鏃堕棿
       talk_address   varchar2(20),   --鍦板潃   
       talk_temp varchar2(200),  --澶囩敤瀛楁
       talk_flag varchar2(1000)  --澶囩敤瀛楁 
);

create sequence seq_talk_id  start with 1 increment by 1;

--8銆佽瘎璁鸿〃------------------------------------------------------------------------------
create table comments(
       c_id int primary key,--璇勮缂栧彿
       talk_id  int constraint  Fk_talk_id references  talk(talk_id),--璇磋缂栧彿 
       c_text  varchar2(500),--璇勮鍐呭
       talking_id  varchar2(50),--璇勮鑰�id
	   c_time date --鏃堕棿 
);
create sequence seq_c_id  start with 1 increment by 1;
  insert into comments values(seq_c_id.nextval,1,'afhlfhal','10002',sysdate);
  insert into comments values(seq_c_id.nextval,68,'2222222222222','10002',sysdate);

--说说与评论进行连接
1.select t.talk_id,t.u_id,t.talk_content,t.talk_image_path,t.talk_time,c.c_id,c.c_text,
c.talking_id,c.c_time
 from talk t inner join comments c on t.talk_id=c.talk_id where t.talk_id=1;
 --说说与评论与用户连接
2.select u.u_id,u.u_name,t.talk_id,t.talk_content,t.talk_image_path,t.talk_time,c.c_id,c.c_text,c.c_time,c.talking_id
from  talk t left join comments c on t.talk_id=c.talk_id 
 left join userInfo u on t.u_id=u.u_id
-- 用户id  用户 名 说说编号 说说图片路径    说说内容 发说说时间 评论编号 评论内容 评论时间  发说说的人
-- u_id  u_name talk_id  talk_content talk_image_path talk_time c_id c_text  c_time talking_id

--9銆佺偣璧�---------------------------------------------------------------------------------
create table support(
       support_id int primary key,  --缂栧彿
       u_id  int 
           constraint  FKK_uid references userInfo(u_id)  --鐢ㄦ埛ID
);

create sequence seq_support_id  start with 1 increment by 1;

--10銆佸彂甯冩椿鍔�-----------------------------------------------------------------------------
create table activity(
	acid int,	--娲诲姩缂栧彿
    u_id   int ,  --鐢ㄦ埛ID 
	u_name  varchar2(100), --鐢ㄦ埛鍛㈢О
    aname varchar2(100),  --娲诲姩鍚嶇О
    astarttime varchar2(50),  --寮�鏃堕棿
    aadd    varchar2(100),   --娲诲姩鍦扮偣
    atype   varchar2(100),  --娲诲姩绫诲埆
    aexpend   number(7,2),  --鑺遍攢
    acity   varchar2(100),  --娲诲姩鍩庡競
    aperson  int ,  --闇�浜烘暟
    adate   varchar2(100),  --鎶ュ悕鎴嚦鏃ユ湡
    acontent   clob ,  --娲诲姩鍐呭
	aphoto varchar2(100),	--娲诲姩鍥剧墖
	astatus int default 2	--鐢宠鐘舵�   2  琛ㄧず姝ｅ湪瀹℃牳涓� 1 琛ㄧず瀹℃牳鏈�杩� 0 琛ㄧず瀹℃牳閫氳繃
);
create sequence seq_acid start with 1 increment by 1;  --娲诲姩ID鍙�浠�寮�




-----------------------------------------------------------------------------------------
--鍒涘缓璇勮琛ㄤ笌璇磋琛ㄤ笌鐢ㄦ埛琛ㄧ殑瑙嗗浘

--鐢ㄦ埛缂栧彿 鐢ㄦ埛鏄电О 鐢ㄦ埛澶村儚  澶囩敤瀛楁锛堢敤鎴蜂俊鎭〃锛� 璇磋缂栧彿  璇磋鍐呭  鍙戣璇寸殑鍥惧儚璺緞 鍙戣璇寸殑鏃堕棿  澶囩敤瀛楁锛堣璇磋〃锛�
--璇勮缂栧彿  璇勮鍐呭  璇勮鑰呯殑id 澶囩敤瀛楁

 create view talk_comments_view as 
 select u.u_id,u.u_name,u.u_photo,u.u_temp,t.talk_id,t.talk_content,t.talk_image_path
 ,to_char(t.talk_time,'yyyy-MM-dd HH24:mi:ss') talk_time ,t.talk_flag,c.c_id,c.c_text
 ,c.talking_id,to_char(c.c_time,'yyyy-MM-dd HH24:mi:ss') c_time from talk t inner join userinfo u  on u.u_id=t.u_id inner join 
 comments c on c.talk_id=t.talk_id;

select * from talk_comments_view ;

--寤虹珛鐢ㄦ埛琛ㄥ拰璇磋琛ㄧ殑瑙嗗浘--------------------------------------------------------------------

create view talk_view as
select u.u_id,u.u_name,u.u_pwd,u.u_sex,u.u_birth,u.u_province,u.u_city,
	u.u_area,u.u_school,u.u_academy,u.u_grade,u.u_photo,u.u_stature,
	u.u_weight,u.u_blood,u.u_qq,u.u_tel,u.u_wechat,u.u_text,u.u_status,
	u.u_temp,u.u_flag,t.talk_id,t.talk_content,t.talk_image_path,
	to_char(t.talk_time,'yyyy-MM-dd HH24:mi:ss') talk_time ,
	t.talk_address,t.talk_temp,t.talk_flag
	 from userinfo u  inner join  talk   t on u.u_id =t.u_id;

select * from talk_view;
select to_char(c_time,'yyyy-MM-dd HH24:mi:ss')c_time from comments where c_id=4

-----------------------------------------------------------------
--鍒涘缓璇勮琛ㄤ笌璇磋琛ㄤ笌鐢ㄦ埛琛ㄧ殑瑙嗗浘

 create view comments_view
  as select c.c_id,c.talk_id,c.c_text,c.talking_id,c.c_time
 ,t.u_id,u.u_name,u.u_photo from talk t inner join comments c on c.talk_id=t.talk_id
 inner join userinfo u on t.u_id=u.u_id;    
 

 

--鎻掑叆鏁版嵁

insert into userinfo values(seq_u_id.nextval,'zhangsan','577850722@qq.com','aaaaaa','鐢�,'1994-11-16','婀栧崡鐪�,'琛￠槼甯�,'鐝犳櫀鍖�,'婀栧崡宸ュ闄�,'璁′俊瀛﹂櫌','2013',null,null,null,null,null,null,null,null,null,null,null);
insert into userinfo values(seq_u_id.nextval,'lisi','2017150504@qq.com','aaaaaa','濂�,'1993-1-19','婀栧崡鐪�,'琛￠槼甯�,'鐝犳櫀鍖�,'婀栧崡宸ュ闄�,'璁′俊瀛﹂櫌','2013',null,null,null,null,null,null,null,null,null,null,null);
insert into userinfo values(seq_u_id.nextval,'dark','435841936@qq.com','aaaaaa','鐢�,'1995-12-16','婀栧崡鐪�,'琛￠槼甯�,'鐝犳櫀鍖�,'婀栧崡宸ュ闄�,'璁′俊瀛﹂櫌','2013',null,null,null,null,null,null,null,null,null,null,null);

insert into adminInfo values(seq_admin_id.nextval,'閭变附','aaaaaa',0,null,null);
insert into adminInfo values(seq_admin_id.nextval,'浣欐�鐞�,'aaaaaa',0,null,null);
insert into adminInfo values(seq_admin_id.nextval,'鑸掓ⅵ濠�,'aaaaaa',0,null,null);
insert into adminInfo values(seq_admin_id.nextval,'鏉庢棴褰�,'aaaaaa',0,null,null);

insert into talk values(seq_talk_id.nextval,10001,'涓嶅悓鐨勪汉,涓嶅悓鐨勭粡鍘�涓嶅悓鐨勯�鎷�涓嶅悓鐨勪汉鐢熻建杩�鍒�绔欎綘鐨勮搴﹀幓鐪嬪緟浠讳綍浜轰换浣曚簨','images/MM1.jpg',sysdate,'null','null','null');

insert into activity values(seq_acid.nextval,10001,'zhangsan','鑱氶','2016-6-30','瑗挎箹鍏洯','鑱氶',100,'婀栧崡鐪佽　闃冲競',10,'2016-7-2','蹇潵涓�捣鍘昏仛椁愬惂','',default);
insert into activity values(seq_acid.nextval,10002,'lisi','涓�捣鑸炲惂','2016-5-31','宸ュ闄㈠浘涔﹂','鑸炰細',0,'婀栧崡鐪佽　闃冲競',20,'2016-6-2','蹇潵涓�捣鑸炲姩鍚�,'',default);
insert into activity values(seq_acid.nextval,10002,'lisi','璇磋蛋灏辫蛋','2016-6-25','琛″北','鏃呮父',0,'婀栧崡鐪佽　闃冲競',5,'2016-7-10','璁╂垜浠潵涓�稛璇磋蛋灏辫蛋鐨勬梾琛�,'',default);


commit

delete from talk where talk_id=
delete from comments where c_id=73
select * from comments;
select * from talk;
select * from userInfo;
select * from userInfo where u_email='577850722@qq.com' and u_pwd='aaaaaa';
 			
