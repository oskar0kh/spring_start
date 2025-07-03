package hello.hello_spring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }

    // MVC 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API 방식1
    @GetMapping("hello-string")
    @ResponseBody // HTTP의 body 파트에 데이터를 직접 넣겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    // API 방식2
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();

        hello.setName(name);

        return hello;
    }

    static class Hello{
        private String name;

        // name 꺼내기
        public String getName(){
            return name;
        }

        // name을 구조체에 집어넣기
        public void setName(String str){
            this.name = str;
        }
    }
}
