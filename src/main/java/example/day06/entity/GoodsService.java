package example.day06.entity;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class GoodsService {
    private final GoodsRepository goodsRepository;

    // 1. 저장
    public boolean 저장(GoodsDto goodsDto){
        // 1] dto --> entity 변환
        GoodsEntity goodsEntity = goodsDto.toEntity();
        // 2] JPA save 이용하여 엔티티 insert 하기
        GoodsEntity save = goodsRepository.save(goodsEntity);
        // 3] save 결과에 pk 여부 성공판단
        if(save.getGno() >= 1){
            return true;
        }
        return false;
    }

    // 2. 수정
    // ** Transactional 필수 **
    // 수정시 여러개 setter 사용하므로 단일 실행
    public boolean 수정(GoodsDto goodsDto){
        // 1] 수정할 엔티티의 pk번호 확인
        int updatePk = goodsDto.getGno();
        // 2] 수정할 엔티티 찾기 --> 영속성
        Optional<GoodsEntity> optional = goodsRepository.findById(updatePk);
        // 3] 만약에 찾은 엔티티가 존재하면
        if(optional.isPresent()){
            GoodsEntity updateEntity = optional.get();
            updateEntity.setGdesc(goodsDto.getGdesc());
            updateEntity.setGname(goodsDto.getGname());
            updateEntity.setGprice(goodsDto.getGprice());
            return true;
        }
        return false;
    }
}
