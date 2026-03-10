package 종합.예제10.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import 종합.예제10.board.dto.BoardDto;
import 종합.예제10.board.entity.BoardEntity;
import 종합.예제10.board.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 1. C
    public boolean addPost(BoardDto boardDto){
        BoardEntity entity = boardDto.toEntity();
        BoardEntity save = boardRepository.save(entity);
        return save.getBno() >= 1;
    }

    // 2. R ALL
    public List<BoardDto> getPostAll(){
        List<BoardEntity> postEntities = boardRepository.findAll();
        List<BoardDto> postDtos = new ArrayList<>();
        postEntities.forEach(post -> {
            BoardDto dto = post.toDto();
            postDtos.add(dto);
        });
        return postDtos;
    }

    // 3. R DETAIL
    public BoardDto getPost(Long postId){
        Optional<BoardEntity> post = boardRepository.findById(postId);
        if(post.isPresent()){
            return post.get().toDto();
        }
        return null;
    }

    // 4. U
    public boolean updatePost(BoardDto boardDto){
        Long id = boardDto.getBno();
        Optional<BoardEntity> entity = boardRepository.findById(id);
        if(entity.isPresent()){
            BoardEntity boardEntity = entity.get();

            boardEntity.setBtitle(boardDto.getBtitle());
            boardEntity.setBcontent(boardDto.getBcontent());
            boardEntity.setBwriter(boardDto.getBwriter());
            return true;
        }
        return false;
    }

    // 5. D
    public boolean deletePost(Long postId){
        boardRepository.deleteById(postId);
        return boardRepository.findById(postId).isEmpty();
    }
}
