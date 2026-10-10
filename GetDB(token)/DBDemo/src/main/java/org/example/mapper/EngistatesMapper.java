package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Engistates;
import org.example.entity.Sys_equideti;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface EngistatesMapper {
    List<Engistates> selectAll();

    //查询自定义条数，时间倒序
    @Select("SELECT * from engistates order by id desc LIMIT 0,#{count}")
    List<Engistates> selectcountAll(Integer count);

    void deleteBatchByIds(@Param("ids") List<Integer> ids);
    List<Engistates> selectByUsercode(@Param("Usercode") String Usercode);

    List<Engistates> selectByUsercodeAndCount(Map<String, Object> params);

    List<Engistates> selectByEngicode(@Param("Engicode") String Engicode);//通过控制器编码查询信息
    List<Engistates> findByUserCodeWithLimit(@Param("code") String code, @Param("count") Integer count);



}
