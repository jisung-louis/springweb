package 종합.예제9.controller;

import 종합.예제9.model.dao.BoardDao;
import 종합.예제9.model.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 빈 등록 + HTTP 기능 + HTTP 응답객체
public class BoardController {
    @Autowired
    private BoardDao boardDao;

    @GetMapping("/board")
    public List<BoardDto> findAll(){
        List<BoardDto> result = boardDao.findAll();
        return result;
    }

    @GetMapping("/board{bno}")
    public BoardDto findOne(@PathVariable int bno){
        BoardDto result = boardDao.findOne(bno);
        return result;
    }

    @PostMapping("/board")
    public boolean write(@RequestBody BoardDto boardDto){
        System.out.println("입력받은 boardDto = " + boardDto);
        boolean result = boardDao.write(boardDto);
        return result;
    }

    @PutMapping("/board")
    public boolean update(@RequestBody BoardDto boardDto){
        System.out.println("입력받은 boardDto = " + boardDto);
        boolean result = boardDao.update(boardDto);
        return result;
    }

    @DeleteMapping("/board")
    public boolean delete(@RequestParam int bno){
        boolean result = boardDao.delete(bno);
        return result;
    }
}
