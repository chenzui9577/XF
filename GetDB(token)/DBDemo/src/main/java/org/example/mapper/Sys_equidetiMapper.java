package org.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.PartComparisonResult;
import org.example.entity.Sys_equideti;
import org.example.entity.Sys_program;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Sys_equidetiMapper extends BaseMapper<Sys_equideti> {
    /**
     * List<Sys_equideti> queryList();//查询所有
     * <p>
     * void deleteSys_equideti(@Param("Id") int id);//删除
     * <p>
     * void updateSys_equideti(@Param("Id") int id);//修改
     * <p>
     * void addSys_equideti(Sys_equideti ed);//
     **/

    /**
     * 根据Usercode查找Sys_equideti记录
     * @param usercode 用户编码
     * @return 对应的Sys_equideti实体
     */
    Sys_equideti findByUsercode(@Param("usercode") String usercode);

    @Select("SELECT COUNT(1) FROM sys_equideti WHERE Engicode = #{Engicode}")
    boolean existsWithEngicode(String engicode);
    void saveOrUpdate(Sys_equideti sys_equideti);

    void deleteBatchByIds(@Param("ids") List<Integer> ids);
    int deleteSys_equideti(@Param("Id") Integer id);//删除
    int updateSys_equideti(Sys_equideti eqdti);//修改
    int addSys_equideti(Sys_equideti eqd);//增加
    void deleteByEngicode(@Param("Engicode") String Engicode);
    void addexcel(Sys_equideti sys_equideti);
    List<String> getUsercodeByEngicode(String engicode);

    List<Sys_equideti> queryByid(@Param("Id") int id);//根据id查看详细信息

    List<Sys_equideti> selectByEngicode(@Param("Engicode") String Engicode);//通过控制器编码查询信息

    List<Sys_equideti> selectAll();

    List<Sys_equideti> getUsercodeByEngicode1(String engicode);
    void savePartComparisonResult(PartComparisonResult result);
    PartComparisonResult getPartComparisonResult();
}
