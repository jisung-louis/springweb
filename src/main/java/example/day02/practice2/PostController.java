package example.day02.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/practice2")
public class PostController {
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