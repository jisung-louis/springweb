package example.day06.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 1] 엔티티의 상속 용도 클래스
@Getter // 2] 상속받은 엔티티가 멤버변수 사용 (private이기 때문에 get메서드로만 접근할 수 있음)
@EntityListeners(AuditingEntityListener.class) // 3] 해당 엔티티 자동 감사 적용
public class BaseTime { // 엔티티의 상속용도 클래스
    @CreatedDate // 4-1] 엔티티 생성 날짜/시간 주입
    private LocalDateTime createDate;
    @LastModifiedDate // 4-2] 엔티티 수정 날짜/시간 주입
    private LocalDateTime updateDate;
}
