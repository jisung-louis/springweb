package 종합.예제10.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import 종합.예제10.board.dto.BoardDto;
import 종합.예제10.board.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 1. C
    @PostMapping
    public boolean addPost(@RequestBody BoardDto boardDto){
        return boardService.addPost(boardDto);
    }

    // 2. R ALL
    @GetMapping
    public List<BoardDto> getPostAll(){
        return boardService.getPostAll();
    }

    // 3. R DETAIL
    @GetMapping("/detail")
    public BoardDto getPost(@RequestParam Long postId){
        return boardService.getPost(postId);
    }

    // 4. U
    @PutMapping
    public boolean updatePost(@RequestBody BoardDto boardDto){
        return boardService.updatePost(boardDto);
    }

    // 5. D
    @DeleteMapping
    public boolean deletePost(@RequestParam Long postId){
        return boardService.deletePost(postId);
    }
}
