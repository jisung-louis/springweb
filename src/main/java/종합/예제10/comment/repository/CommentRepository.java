package 종합.예제10.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import 종합.예제10.comment.entity.CommentEntity;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    // List<CommentEntity> findByBno(Long bno); // 이걸 하면 JPA에서 "select * from COMMENT where bno = ?" 쿼리를 실행한다.
}
