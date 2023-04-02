package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Return cái view. Mình đang dùng Thymeleaf view resolver, mặc định cái resolver này sẽ tìm file
        // trong resources/templates/ có đuôi là .html. Trong trưường hợp này nó sẽ return html trong file
        // resources/templates/home.html
        // Thymeleaf là 1 template engine (giống JSP)
        return "home";
    }


    // Các e có thể thêm Model model rồi pass các biến vào Model để truyền cho Thymleaf sử dụng
    @GetMapping("/demo")
    public String demo(Model model) {
        DemoClass demoObj = new DemoClass("Thao", 20);
        // Sau khi truyền vào thì có thể get đươc trong file html
        model.addAttribute("user", demoObj);
        return "demo";
    }

    public static class DemoClass {
        private String name;
        private int age;

        public DemoClass(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
