package example.day07.자바참조;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Exam1 {
    public static void main(String[] args) {

        // 자바는 객체지향 언어이다.
        // System : 클래스, System.out : 객체 , println() : 함수/메소드
        // 즉] 특정한 객체가 특정한 함수 실행한다.
        System.out.println("출력함수");

        // [1] 카테고리 객체 생성 == 클래스로 메모리 생성 뜻
        Category category = new Category();
        category.setCno( 1 ); category.setCname("공지사항");

        Category category2 = new Category();
        category2.setCno( 2 ); category2.setCname("자유게시판");

        // [2] 게시물 객체 생성
        // 즉] ORM(JPA) 기술은 객체참조로 데이터베이스의 PK-FK 구현
        // 단방향 : FK 통해 PK 참조하는것 처럼, 특정한 객체 통해 참조 객체를 참조한다.
        // 즉] 게시물객체 통해 카테고리객체를 참조한다. 카테고리객체를 통해 게시물객체는 참조 못한다.
        // 2-1 : 첫 번째 게시물은 공지사항 이다.
        Board board = new Board();
        board.setBcontent("첫번째 게시물입니다");
        board.setCategory(category);

        // 2-2 : 두 번째 게시물은 자유게시판이다.
        Board board2 = new Board();
        board2.setBcontent("두번째 게시물입니다.");
        board2.setCategory(category2);

        // [3] 카테고리가 게시물 참조
        // 양방향 : 두 객체간의 서로 참조하는 관계 , 데이터베이스 존재하지
        // 즉] ORM(JPA)는 단방향/양방향 모두 지원한다. 특징 : 조회가 빠르다. JOIN 안써도됨
        // 1. 순환참조문제점  2. 복잡한 JOIN  3. LAZY지연로딩 고려
        category.getBoardList().add(board);
        category2.getBoardList().add(board2);

        // 확인
        // FK에서 PK 양방향 참조/조회
        System.out.println( board2.getCategory() );
        // PK에서 FK 양방향 참조/조회
        // StackOverflowError : 양방향 참조하다가 메모리 오버플로우
        // 해결방안 : 두 객체 간의 한쪽 필드에 @ToString.Exclude 주입한다.
        System.out.println( category.getBoardList() );
    }
}

@Data
class Category{
    private int cno;
    private String cname;
    @ToString.Exclude // 순환참조 방지
    private List<Board> boardList = new ArrayList<>(); // (양방향참조) 게시물목록
}

@Data
class Board{
    private int bno;
    private String bcontent;
    private Category category;
}