package 종합.예제10.comment.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import 종합.예제10.comment.dto.CommentDto;
import 종합.예제10.comment.entity.CommentEntity;
import 종합.예제10.comment.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;

    public boolean addComment(CommentDto commentDto){
        CommentEntity entity = commentDto.toEntity();
        CommentEntity save = commentRepository.save(entity);

        return save.getCno() >= 1;
    }

    public List<CommentDto> getCommentByBno(Long boardId){
        List<CommentDto> list = new ArrayList<>();
        List<CommentEntity> all = commentRepository.findAll();
        if(!all.isEmpty()) {
            all.forEach(comment -> {
                if (comment.getBno() != null && comment.getBno().equals(boardId)) {
                    CommentDto dto = comment.toDto();
                    list.add(dto);
                }
            });
        }
        return list;
    }

    public boolean updateComment(CommentDto commentDto){
        Long id = commentDto.getCno();
        Optional<CommentEntity> optional = commentRepository.findById(id);
        if(optional.isPresent()){
            CommentEntity comment = optional.get();

            comment.setCcontent(commentDto.getCcontent());
            comment.setCwriter(commentDto.getCwriter());
            return true;
        }
        return false;
    }

    public boolean deleteComment(Long commentId){
        boolean isExist = commentRepository.existsById(commentId);
        if(isExist) {
            commentRepository.deleteById(commentId);
            return true;
        }
        return false;
    }
}
