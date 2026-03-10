package 종합.예제10.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import 종합.예제10.comment.dto.CommentDto;
import 종합.예제10.comment.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public boolean addComment(@RequestBody CommentDto commentDto){
        return commentService.addComment(commentDto);
    }

    @GetMapping
    public List<CommentDto> getComments(@RequestParam Long boardId){
        return commentService.getCommentByBno(boardId);
    }

    @PutMapping
    public boolean updateComment(@RequestBody CommentDto commentDto){
        return commentService.updateComment(commentDto);
    }

    @DeleteMapping
    public boolean deleteComment(@RequestParam Long commentId){
        return commentService.deleteComment(commentId);
    }
}
