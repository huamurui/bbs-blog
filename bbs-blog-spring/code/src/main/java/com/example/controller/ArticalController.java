package com.example.controller;

import cn.hutool.core.date.DateUtil;
import com.example.common.Result;
import com.example.entity.Artical;
import com.example.entity.User;
import com.example.service.ArticalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/artical")
public class ArticalController {
    @Resource
    private ArticalService articalService;
    @Resource
    private HttpServletRequest request;

    public User getUser() {
        return (User) request.getSession().getAttribute("user");
    }

    @PostMapping
    public Result<?> save(@RequestBody Artical artical) {
        artical.setUsername(getUser().getUsername());
        artical.setTime(DateUtil.formatDateTime(new Date()));
        return Result.success(articalService.save(artical));
    }

    @PutMapping
    public Result<?> update(@RequestBody Artical artical) {
        artical.setUsername(getUser().getUsername());
        artical.setTime(DateUtil.formatDateTime(new Date()));
        return Result.success(articalService.updateById(artical));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        articalService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> findById(@PathVariable Long id) {
        return Result.success(articalService.getById(id));
    }

    @GetMapping
    public Result<?> findAll() {
        List<Artical> a = articalService.list();
        Collections.reverse(a);
        return Result.success(a);
    }
    @GetMapping("/search")
    public List<Artical> search(String keyword) {
        System.out.println(keyword);
        return articalService.searchByWord(keyword);
    }

}
