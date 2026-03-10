package 종합.예제10;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 상속 가능하게
@Getter
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;
}
