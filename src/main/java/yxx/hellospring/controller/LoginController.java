package yxx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping("/login.html")
    public String home() {
        return "login";
    }

    @PostMapping("/admin/login")
    public String check(Model model, HttpServletRequest request) {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        if (user.equals("admin") && password.equals("spm08")) {
            return "admin/Homepage";
        } else {
            model.addAttribute("result", "身份认证失败");
            return "login";
        }
    }
}
