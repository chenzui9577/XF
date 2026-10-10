package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Engistates;

import java.util.List;

public interface Eng_Service {

    List<Engistates> selectAll();
    void deleteBatch(List<Integer> ids);
    List<Engistates> selectcountAll(Integer count); //查询自定义条数，时间倒序
    List<Engistates> selectByUsercode(String Usercode);
    List<Engistates> selectByUsercodeAndCount(String Usercode, Integer count);
    List<Engistates> selectByEngicode(@Param("Engicode") String Engicode);//通过控制器编码查询信息
    List<Engistates> findByUserCodeWithLimit(String code, Integer count);
}
