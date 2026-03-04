package example.종합.예제9.model.dao;

import example.종합.예제9.model.dto.BoardDto;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BoardDao {
    public BoardDao() { connect(); } // 스프링이 빈 등록을 할 때 (객체 생성을 하면서 생성자 내부 코드가 발동되므로) connect() 함수 실행됨.

    // ====== 데이터베이스 연동 =======
    // 1) 연동할 DB서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice9";
    private String user = "root";
    private String password = "1234";
    // 2) 연동 인터페이스 선언
    private Connection conn;

    // 3) 연동 함수 선언 , dao에 생성자에서 함수 실행(dao 싱글톤이 생성되면서 db 연동 실행)
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("**** 데이터베이스 연동 성공 ****");
        } catch (ClassNotFoundException e) {
            System.out.printf("[경고] MySQL 드라이버를 못 찾았어요.\n%s\n", e);
        } catch (SQLException e) {
            System.out.printf("[경고] DB랑 통신하다가 문제가 생겼어요.\n%s\n", e);
        }
    }

    // 1] 전체조회
    public List<BoardDto> findAll(){
        List<BoardDto> list = new ArrayList<>();
        try{
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int bno = rs.getInt("bno");
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                String bdate = rs.getDate("bdate").toString();
                BoardDto board = new BoardDto(bno, bcontent, bwriter, bdate);
                list.add(board);
            }
            return list;
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }

    // 2] 상세조회
    public BoardDto findOne(int bno){
        try{
            String sql = "select * from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                String bdate = rs.getDate("bdate").toString();
                return new BoardDto(bno, bcontent, bwriter, bdate);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    // 3] 등록
    public boolean write(BoardDto boardDto){
        try{
            String sql = "insert into board(bcontent, bwriter) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setString(2, boardDto.getBwriter());
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    // 4] 수정
    public boolean update(BoardDto boardDto){
        try{
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setInt(2, boardDto.getBno());
            int count = ps.executeUpdate();
            if ( count == 1 ) return true;
        } catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    // 5] 삭제
    public boolean delete(int bno){
        try{
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        } catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}