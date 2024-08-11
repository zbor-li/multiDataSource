package com.zbor.pgTest.mapper.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbor.pgTest.model.test.tUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface tUserMapper extends BaseMapper<tUser> {
    @Select("SELECT * FROM t_user")
    List<tUser> selectAll();
}
