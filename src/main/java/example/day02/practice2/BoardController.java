package example.day02.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BoardController {
    @PostMapping("/board")
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        return true;
    }

    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint(){
        return new ArrayList<>();
    }

    @GetMapping("/board/detail")
    public BoardDto boardDetail(int bno){ // @RequestParam 생략, 쿼리스트링에는 /board/detail?bno=1 처럼 써야 함
        return null;
    }

    @DeleteMapping("/board")
    public boolean boardDelete(@RequestParam int bno){
        return true;
    }

    @PutMapping("/board")
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        return true;
    }
}
