package example.day02.practice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/practice2")
public class PostController {

    /*
        메소드 이란? 상호작용(주고받는 쌍방향 행동)
            매개변수? ㅁ개(중개)변수(정해져있지않은값) : 메소드가 호출될 때 들어오는 값(인수)
            반환값? 메소드가 종료될 때 호출했던 곳으로 반환해주는 값 (리턴)
        HTTP 이란? 상호작용( request / response )
            request? 클라이언트가 서버로부터 요청
            response? 서버가 처리한 결과를 클라이언트에 반환/응답
    */

    @Autowired
    private BoardController boardController;

    @PostMapping("/post")
    public boolean doPost(){
        return true;
    }

    @GetMapping("/post")
    public List<Map<String, String>> getPostAll(){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        list.add( map1 );
        Map<String,String> map2 = new HashMap<>();
        map2.put("bno" , "2" );
        map2.put("btitle" , "제목2");
        list.add( map2 );
        return list;
    }

    @GetMapping("/post/view")
    public Map<String, String> getPost(){
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        return map1;
    }

    @PutMapping("/post")
    public boolean updatePost(){
        return true;
    }

    @DeleteMapping("/post")
    public int deletePost(){
        return 3;
    }

}

/*
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
 */