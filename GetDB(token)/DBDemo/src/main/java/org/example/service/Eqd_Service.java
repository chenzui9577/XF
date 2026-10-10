package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.common.ImportResult;
import org.example.entity.PartComparisonResult;
import org.example.entity.Sys_equideti;

import java.io.InputStream;
import java.util.List;

public interface Eqd_Service {

    List<Sys_equideti> selectByEngicode(String Engicode);
 /*   List<PartComparisonResult> getLatestComparisonResult();*/
    List<Sys_equideti> selectAll();
    int deleteSys_equideti(int id);//删除
    int updateSys_equideti(Sys_equideti eqdti);//修改

    int addSys_equideti(Sys_equideti eqd);//增加
    void deleteByEngicode(@Param("Engicode") String Engicode);
    void deleteBatch(List<Integer> ids);
    void processExcelFile(InputStream inputStream);
    List<Sys_equideti> queryByid(int id);//根据id查看详细信息
    List<String> getUsercodeByEngicode(String engicode);
    void savePartComparisonResult(PartComparisonResult result);
    PartComparisonResult getPartComparisonResult();
    List<Sys_equideti> getUsercodeByEngicode1(String engicode);
    //void compareParts(List<String> parts);



    //ImportResult importDataFromExcel(InputStream inputStream, String Engicode) throws Exception;
 /* Sys_equideti queryByEUcode(String Engicode,String Usercode);
    List<Sys_program> queryByEnginame(@Param("Enginame") String Enginame);//通过项目名称查询项目代码（控制器编码）

    List<Sys_program> queryByClient(@Param("Client") String Client);//通过隶属消防机构查项目名称*/
}
