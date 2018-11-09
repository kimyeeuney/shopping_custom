DROP TABLE MEMBER purge;
select*from MEMBER;


CREATE TABLE MEMBER(
	MEMBER_ID VARCHAR2(20),
	MEMBER_PW VARCHAR2(15),
	MEMBER_NAME VARCHAR2(20),
	MEMBER_JUMIN1 NUMBER,
	MEMBER_JUMIN2 NUMBER,
	MEMBER_EMAIL VARCHAR2(25),
	MEMBER_EMAIL_GET VARCHAR2(7),
	MEMBER_MOBILE VARCHAR2(13),
	MEMBER_PHONE VARCHAR2(13),
	MEMBER_ZIPCODE VARCHAR2(13),
	MEMBER_ADDR1 VARCHAR2(70),
	MEMBER_ADDR2 VARCHAR2(70),
	MEMBER_ADMIN NUMBER,
	MEMBER_JOIN_DATE DATE,
	PRIMARY KEY(MEMBER_ID)
);

CREATE TABLE ZIPCODE (
  ID NUMBER,
  ZIPCODE VARCHAR2(7),
  SIDO VARCHAR2(10),
  GUGUN VARCHAR2(30),
  DONG VARCHAR2(36),
  RI VARCHAR2(60),
  BUNJI VARCHAR2(50),
  PRIMARY KEY (ID)
);

create table admin_ad(
	pricename VARCHAR2(50),
	price1 number,
	adorder_date DATE
)

select*from admin_ad;
delete from admin_ad where price1=500;

DELETE basket;
COMMIT

SELECT * FROM GALLERY;
drop table GALLERY purge;

create table GALLERY(
	GALLERY_NUM number,
	GALLERY_CUSTOM_NUM number,
	GALLERY_CUSTOM_ID varchar2(50),
	GALLERY_CUSTOM1 number,
	GALLERY_CUSTOM2 number,
	GALLERY_CUSTOM3 varchar2(50),
	GALLERY_CUSTOM4 number,
	GALLERY_CUSTOM5 number,
	GALLERY_CUSTOM6 number,
	GALLERY_CUSTOM7 number,
	GALLERY_CUSTOM8 number,
	GALLERY_CUSTOM9 number,
	GALLERY_CUSTOM10 number,
	GALLERY_CUSTOM11 number,
	GALLERY_CUSTOM12 varchar2(50),
	GALLERY_CUSTOM13 varchar2(50),
	GALLERY_RE_REF	number,
	GALLERY_RE_LEV	number,
	GALLERY_RE_SEQ	number,
	GALLERY_READCOUNT  number,
	GALLERY_DATE DATE
)

create table BOARD(
	BOARD_NUM    number primary key,
	BOARD_NAME        varchar2(50),
	BOARD_PASS         varchar2(20),
	BOARD_SUBJECT	varchar2(20),
	BOARD_CONTENT	varchar2(2000),
	BOARD_FILE			varchar2(50),
	BOARD_RE_REF	varchar2(20),
	BOARD_RE_LEV	number,
	BOARD_RE_SEQ	number,
	BOARD_READCOUNT  number,
	BOARD_DATE	DATE
);







select * from BOARD;
delete from BOARD purge;


ALTER TABLE BOARD ADD BOARD_SECRET varchar2(10);




create table SEARCH( 
	SEARCH_TEXT   varchar2(200),
	SEARCH_DATE	DATE
)

SELECT * FROM GALLERY;
select * from CUSTOM_ORDER_2;

create table CUSTOM_ORDER_2(
	ORDER_CUSTOM_NUM  number primary key,
	ORDER_CUSTOM1  number,  
	ORDER_CUSTOM2  number,
	ORDER_CUSTOM3  varchar2(50),
	ORDER_CUSTOM4  number,
	ORDER_CUSTOM5  number,
	ORDER_CUSTOM6  number,
	ORDER_CUSTOM7  number,
	ORDER_CUSTOM8  number,
	ORDER_CUSTOM9  number, 
	ORDER_CUSTOM10  number,
	ORDER_CUSTOM11  number,
	ORDER_CUSTOM12  varchar2(50),
	ORDER_CUSTOM13  varchar2(50),
	ORDER_CUSTOM_ID  varchar2(50),
	ORDER_CUSTOM_RECEIVE_NAME  varchar2(50),
	ORDER_CUSTOM_ZIPCODE1  number,
	ORDER_CUSTOM_ZIPCODE2  number,
	ORDER_CUSTOM_RECEIVE_ADDR1  varchar2(100),   
	ORDER_CUSTOM_RECEIVE_ADDR2  varchar2(100),
	ORDER_CUSTOM_RECEIVE_PHONE  number,
	ORDER_CUSTOM_RECEIVE_MOBILE  number,
	ORDER_CUSTOM_MEMO  varchar2(1000),
	ORDER_CUSTOM_TRADE_TYPE  varchar2(50),
	ORDER_CUSTOM_TRADE_DATE  DATE,
	ORDER_CUSTOM_TRADE_PAYER number, 
	ORDER_CUSTOM_GALLERY number  
)

--drop table POINT purge;  
select*from POINT;
create table POINT(
	POINT_ID varchar2(50),
	POINT_DATE DATE,
	POINT_TYPE number,
	POINT_PRICE number,
	POINT_PLUS number,
	POINT_DEDUCTION number,
	POINT_SUM number,
	POINT_GOODS_NUM number,
	POINT_MAXNUM number
)

insert into POINT values('gg',sysdate,1,9800,49,0,49,7,1);
select POINT_SUM from POINT where POINT_MAXNUM = 1;
--POINT_ID : 유저 ID, 
--POINT_TYPE: 1, 구매포인트 2, 판매포인트, 
--POINT_PRICE: 상품가격
--POINT_PLUS: 지금 지급 받은 포인트
--POINT_DEDUCTION: 지금 차감 된 포인트
--POINT_SUM:총 포인트
--POINT_GOODS_NUM : 해당상품
--시퀀스?

select*from POINT_SALE;
create table POINT_SALE(
	POINT_DE_ID varchar2(50),
	POINT_OR_ID varchar2(50),
	POINT_CUSTOM_NUM number,
	POINT_PLUS number,
	POINT_DATE DATE
)
--POINT_DE_ID : 디자이너 아이디
--POINT_OR_ID : 구매자 아이디
--POINT_CUSTOM_NUM : 디자인 번호
--POINT_PLUS : 추가 될 포인트 금액

drop table POINT_SALE purge;





create table ORDER_CADE(
	CADE_NUM varchar2(50)
)

INSERT INTO ORDER_CADE VALUES ('1234123412341234');

-- 댓글 테이블
CREATE TABLE BOARD_COMMENT 
(
  COMMENT_NUM NUMBER NOT NULL,
  COMMENT_BOARD NUMBER NOT NULL,
  COMMENT_ID VARCHAR2(15),
  COMMENT_DATE DATE,
  COMMENT_PARENT NUMBER,
  COMMENT_CONTENT VARCHAR2(1000) NOT NULL,
  CONSTRAINT PK_comment PRIMARY KEY(COMMENT_NUM),
  CONSTRAINT FK_comment FOREIGN KEY(COMMENT_BOARD) REFERENCES MEMBER_BOARD(BOARD_NUM)
);
 
-- MEMBER_BOARD는 게시판 테이블을, BOARD_NUM은 글번호를 나타낸다.
 
-- 댓글 시퀀스 
create sequence COMMENT_SEQ; 
select*from BASKET;
create table BASKET(
	BASKET_NUM number,
	BASKET_CUSTOM1  number,
	BASKET_CUSTOM2  number,
	BASKET_CUSTOM3  varchar2(50),
	BASKET_CUSTOM4  number,
	BASKET_CUSTOM5  number,
	BASKET_CUSTOM6  number,
	BASKET_CUSTOM7  number,
	BASKET_CUSTOM8  number,
	BASKET_CUSTOM9  number, 
	BASKET_CUSTOM10  number,
	BASKET_CUSTOM11  number,
	BASKET_CUSTOM12  varchar2(50),
	BASKET_CUSTOM13  varchar2(50),
	BASKET_CUSTOM_ID  varchar2(50)
);

select*from CHOICE;
create table CHOICE(
	CHOICE_NUM number primary key,
	CHOICE_GALLERY_NUM number,
	CHOICE_ID varchar2(50),
	CHOICE_READCOUNT number,
	CHOICE_DATE DATE
)


select*from GALLERY_ORDER;
create table GALLERY_ORDER(
	GALLERY_ORDER_NUM  number primary key,
	GALLERY_DESIGNER_ID varchar2(50),
	GALLERY_CUSTOM_NUM number,
	GALLERY_NUM number,
	GALLERY_ORDER_CUSTOM1  number,
	GALLERY_ORDER_CUSTOM2  number,
	GALLERY_ORDER_CUSTOM3  varchar2(50),
	GALLERY_ORDER_CUSTOM4  number,
	GALLERY_ORDER_CUSTOM5  number,
	GALLERY_ORDER_CUSTOM6  number,
	GALLERY_ORDER_CUSTOM7  number,
	GALLERY_ORDER_CUSTOM8  number,
	GALLERY_ORDER_CUSTOM9  number, 
	GALLERY_ORDER_CUSTOM10  number, 
	GALLERY_ORDER_CUSTOM11  number,
	GALLERY_ORDER_CUSTOM12  varchar2(50),
	GALLERY_ORDER_CUSTOM13  varchar2(50),
	GALLERY_ORDER_ID  varchar2(50),
	GALLERY_ORDER_NAME  varchar2(50),
	GALLERY_ORDER_ZIPCODE1  number,
	GALLERY_ORDER_ZIPCODE2  number,
	GALLERY_ORDER_ADDR1  varchar2(100),   
	GALLERY_ORDER_ADDR2  varchar2(100),
	GALLERY_ORDER_PHONE  number,
	GALLERY_ORDER_MOBILE  number,
	GALLERY_ORDER_MEMO  varchar2(1000),
	GALLERY_ORDER_TRADE_TYPE  varchar2(50),
	GALLERY_ORDER_TRADE_DATE  DATE,
	GALLERY_ORDER_TRADE_PAYER number
)



-- 쿠폰
-- 구매자 아이디/ 할인쿠폰 갯수
create table COUPON(
	COUPON_ID varchar2(50),
	COUPON_SUM number,
	COUPON_CH number,
	COUPON_DATE DATE
)

insert into COUPON values('aa', 100, 20, sysdate);
insert into COUPON values('aa', 200, 10, sysdate);

select*from COUPON;
drop table AD purge;
 
create table COUPON_USER(
	COUPON_USER_ID varchar2(50),
	COUPON_ADMIN_ID varchar2(50),
	COUPON_USER_SUM number,
	COUPON_NAME varchar2(50),
	COUPON_DATE DATE
)
 
select max(COUPON_DATE) from (select COUPON_ID, COUPON_SUM, COUPON_DATE from COUPON) where COUPON_ID = 'aa';

select sum(COUPON_SUM), sum(COUPON_CH) from COUPON where COUPON_ID = 'aa';

select*from AD;
create table AD(
	AD_NUM number,
	AD_ID varchar2(50),
	AD_NAME varchar2(50),
	AD_PRICE number CHECK(AD_PRICE>50),
	AD_DATE DATE
)

insert into AD values(1, 'aa', '첫 디자인', 100, sysdate);
select count(*) from AD;



