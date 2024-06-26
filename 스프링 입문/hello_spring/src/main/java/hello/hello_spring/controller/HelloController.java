package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ //외부에서 파라미터를 받아옴
        model.addAttribute("name",name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody //http 프로토콜의 body 부분에 직접 return 값을 넣어줌
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; //"hello spring"
        //요청한 클라이언트에 그대로 내려감
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){ //java bin 표준 방식
            //멤버 변수의 값을 반환하는 메서드
            return name;
        }
        public void setName(String name){
            // 멤버 변수의 값을 설정
            this.name = name;
        } //멤버 변수는 private으로 선언되어 외부에서 직접 접근할 수 없음
        // public으로 getter와 setter 메서드를 제공하여 멤버 변수에 간접적으로 접근
    }
}
