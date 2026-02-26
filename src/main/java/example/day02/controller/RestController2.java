package example.day02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RestController2 {
    // 1. 100 반환하는 메소드
    @GetMapping("/day02/task") // WAS(톰캣)주소/ 내가정의한주소, localhost:8080/day02/task
    // java(객체지향) <--번역--> HTTP(문자), JAVA는 INT를 반환하겠다고 했지만 HTTP는 INT 모른다
    // 즉] JAVA 타입을 자동으로 HTTP contents type 변환해준다. int -> application/json
    @ResponseBody // Response
    public int method1(){
        System.out.println("RestController2.method1"); return 100;
    }
    // 2. 문자열 반환하는 메소드
    @GetMapping("/day02/task2")
    @ResponseBody // java String -> text/plain
    public String method2(){
        System.out.println("RestController2.method2");
        return "유재석";
    }
    // 3. Map 타입 반환하는 메소드
    @GetMapping("/day02/task3")
    @ResponseBody // java Map -> application/json
    public Map<String, Object> method3(){
        Map<String, Object> map = new HashMap<>();
        map.put("유재석",100); map.put("강호동",90);
        return map;
    }
    // 4. boolean 타입 반환 메소드
    @GetMapping("/day02/task4")
    @ResponseBody
    public boolean method4(){
        return true;
    }
    // 5. DTO 타입 반환 메소드
    @GetMapping("/day02/task5")
    @ResponseBody
    public TaskDTO method5(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.name = "유재석"; taskDTO.point = 100;
        return taskDTO;
    }
}
class TaskDTO{
    String name;
    int point;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
} // DTO