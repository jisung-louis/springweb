package 종합.예제8.controller;

import 종합.예제8.model.dao.BoardDao;
import 종합.예제8.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 해당 컨트롤러는 HTTP 기능을 갖게 된다. < 싱글톤(유사)이 포함되어 있다. >
public class BoardController {
//    // 싱글톤
//    private BoardController(){}
//    private static final BoardController instance = new BoardController();
//    public static BoardController getInstance(){ return instance; }

    // BoardDao의 객체 가져옴
    private BoardDao bd = BoardDao.getInstance();

    @PostMapping
    public boolean write(String bcontent, String bwriter){
        return bd.write(bcontent,bwriter);
    }
    @DeleteMapping
    public boolean delete(int bno){
        return bd.delete(bno);
    }
    @PutMapping
    public boolean update(int bno, String bcontent){
        return bd.update(bno, bcontent);
    }
    @GetMapping
    public ArrayList<BoardDto> printAll(){
        return bd.printAll();
    }
}
