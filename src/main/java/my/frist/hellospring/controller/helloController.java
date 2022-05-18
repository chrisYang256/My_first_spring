package my.frist.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    // GetMapping()으로 괄호 안의 문자열을 주소와 맵핑해줍니다.(예: localhost:500/hello)
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("greeting", "hello~!!");
        return "hello";
    }

    // mvc + template engin은 template engin을 Model, View, Controller방식으로 쪼개서
    // View를 template engin으로 html을 프로그래밍해서? 랜더링 된 html를 client에게 전달해줍니다.
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // @ResponseBody를 통해 http body에 문자 내용을 직접 반환합니다.
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    // api는 객체를 반환합니다.(MappingJackson2와 같은 내장 라이브러리가 json으로 변환)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // java bin 표준 양식
    // private를 외부에서 바로 접근할 수 없도록 하고 public get/set으로 접근토록 합니다.
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
} 