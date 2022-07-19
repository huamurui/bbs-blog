package com.example.mapper;

import com.example.entity.Artical;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ArticalMapper extends BaseMapper<Artical> {

    List<Artical> searchByWord(String keyword);
}
