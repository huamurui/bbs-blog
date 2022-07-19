package com.example.service;

import com.example.entity.Artical;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ArticalMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service
public class ArticalService extends ServiceImpl<ArticalMapper, Artical> {
    @Resource
    private  ArticalMapper articalMapper;
    public  List<Artical> searchByWord(String keyword) {
        System.out.println(keyword);
        return articalMapper.searchByWord(keyword);
    }
}

