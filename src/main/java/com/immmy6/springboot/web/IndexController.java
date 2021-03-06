package com.immmy6.springboot.web;

import com.immmy6.springboot.config.auth.LoginUser;
import com.immmy6.springboot.config.auth.dto.SessionUser;
import com.immmy6.springboot.service.PostsService;
import com.immmy6.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("myName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("myName", user.getName());
        }
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        if (user != null) {
            model.addAttribute("myName", user.getName());
        }
        return "posts-update";
    }

    @GetMapping("/freeboard")
    public String freeboard(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("myName", user.getName());
        }
        return "freeboard";
    }

    @GetMapping("/prboard")
    public String prboard(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("myName", user.getName());
        }
        return "prboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("myName", user.getName());
        }
        return "dashboard";
    }
}