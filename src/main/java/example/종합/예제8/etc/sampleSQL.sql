# [1] 데이터베이스 생성
drop database if exists boardservice7;
create database boardservice7;
use boardservice7;
# [2] 테이블 생성
create table board(
	bno int unsigned auto_increment,	-- 게시물 번호(PK)
    constraint primary key(bno),
    bcontent longtext not null,			-- 게시물 본문
    bwriter varchar(30) not null,		-- 게시물 작성자
    bdate datetime default now()		-- 게시물 작성일자
);
# [3] 테이블 샘플 데이터 30개 만들기
INSERT INTO board (bcontent, bwriter) VALUES
('게시물 본문 1번입니다. 오늘은 날씨가 좋습니다.', '홍길동'),
('게시물 본문 2번입니다. MySQL 연습 중입니다.', '김철수'),
('게시물 본문 3번입니다. 게시판 기능을 구현하고 있습니다.', '이영희'),
('게시물 본문 4번입니다. 데이터베이스 공부가 재미있습니다.', '박민수'),
('게시물 본문 5번입니다. SQL 쿼리를 연습하고 있습니다.', '최지은'),
('게시물 본문 6번입니다. 웹 개발 프로젝트 진행 중입니다.', '정우성'),
('게시물 본문 7번입니다. 오늘은 코드 리뷰를 했습니다.', '한지민'),
('게시물 본문 8번입니다. 서버 성능 최적화를 공부합니다.', '오세훈'),
('게시물 본문 9번입니다. API 연동 테스트를 완료했습니다.', '윤아름'),
('게시물 본문 10번입니다. 게시판 기능이 거의 완성되었습니다.', '서하늘');

select * from board;