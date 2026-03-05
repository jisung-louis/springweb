package example.day06.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor // @Autowired 로 GoodsService를 주입하는 대신 RequiredArgsConstructor로 주입 (그 대신 변수에 final 붙여야 함)
public class GoodsController {
    private final GoodsService goodsService;

    // 저장
    @PostMapping
    public boolean 저장(@RequestBody GoodsDto goodsDto){
        boolean result = goodsService.저장(goodsDto);
        return result;
    }
    // 수정
    @PutMapping
    public boolean 수정(@RequestBody GoodsDto goodsDto){
        boolean result = goodsService.수정(goodsDto);
        return result;
    }
}
