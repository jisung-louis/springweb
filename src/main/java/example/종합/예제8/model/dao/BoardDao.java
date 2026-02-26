package example.종합.예제8.model.dao;

import example.종합.예제8.model.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {
    // 싱글톤
    // [1] 생성자를 잠근다.
    private BoardDao(){ connect(); }
    // [2] 상수 객체를 만든다.
    private static final BoardDao instance = new BoardDao();
    // [3] instance에 대한 getter를 만든다.
    public static BoardDao getInstance(){
        return instance;
    }

    // ====== 데이터베이스 연동 =======
    // 1) 연동할 DB서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice7";
    private String user = "root";
    private String password = "1234";
    // 2) 연동 인터페이스 선언
    private Connection conn;
    // 3) 연동 함수 선언 , dao에 생성자에서 함수 실행(dao 싱글톤이 생성되면서 db 연동 실행)
    private void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("**** 데이터베이스 연동 성공 ****");
        } catch (ClassNotFoundException e) {
            System.out.printf("[경고] MySQL 드라이버를 못 찾았어요.\n%s\n",e);
        } catch (SQLException e) {
            System.out.printf("[경고] DB랑 통신하다가 문제가 생겼어요.\n%s\n",e);
        }
    }
    public boolean write(String bcontent, String bwriter){
        try {
            // 1) SQL 작성한다. 저장 -> C -> INSERT, '?'는 와일드카드 기호로 변수값이 들어갈 자리를 뜻한다.
            String sql = "insert into board(bcontent, bwriter) values(?,?)";
            // 2) 연동된(conn) 인터페이스에 내가 작성한 SQL 작성한다. (일반 예외 SQLException)
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3) SQL이 기재된(ps) 인터페이스에 SQL 매개변수 대입, ps.set타입명(?순서번호, 값);
            ps.setString(1, bcontent); // 1번째 '?'에 bcontent 값을 대입한다.
            ps.setString(2, bwriter);
            // 4) 매개변수까지 대입하여 준비가 끝났으면 SQL 실행, ps.excuteUpdate(); (반환값은 반영된 레코드 수)
            int count = ps.executeUpdate();
            // 5) SQL 실행 후 반영된 레코드 수에 따른 결과 제어
            if( count == 1){ return true; }
            else { return false; }
        } catch(SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생 : " + e);
        }
        return false; // 실페
    }
    public boolean delete(int bno){
        try{
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            int count = ps.executeUpdate();
            if( count == 1) { return true; }
            else { return false; }
        } catch(SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생 : " + e);
        }
        return false;
    }

    public boolean update(int bno, String bcontent){
        try {
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bcontent);
            ps.setInt(2, bno);
            int count = ps.executeUpdate();
            if (count == 1) { return true; }
            else { return false; }
        } catch(SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생 : " + e);
        }
        return false;
    }
    public ArrayList<BoardDto> printAll(){
        ArrayList<BoardDto> boards = new ArrayList<>();
        try {
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int bno = rs.getInt("bno");
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                String bdate = rs.getDate("bdate").toString();
                BoardDto board = new BoardDto(bno, bcontent, bwriter, bdate);
                boards.add(board);
            }
        } catch(SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생 : " + e);
        }
        return boards;
    }

}
