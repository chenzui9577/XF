package org.example.service.Impl;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Engistates;
import org.example.entity.Sys_equideti;
import org.example.mapper.EngistatesMapper;
import org.example.service.Eng_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Eng_ServiceImpl implements Eng_Service {
    @Resource
    @Autowired
    private EngistatesMapper engMapper;

    @Override
    public List<Engistates> selectAll() {
        List<Engistates> eng = engMapper.selectAll();
        return eng;
    }
    //查询自定义条数，时间倒序
    @Override
    public List<Engistates> selectcountAll(Integer count){
        List<Engistates> coun = engMapper.selectcountAll(count);
        return coun;
    }
    @Override
    public List<Engistates> selectByUsercode(String Usercode) {
        return engMapper.selectByUsercode(Usercode);
    }
    @Override

    public  List<Engistates>selectByEngicode(String Engicode) {
        return engMapper.selectByEngicode(Engicode);
    }

    @Override
    public List<Engistates> selectByUsercodeAndCount(String Usercode, Integer count) {
        Map<String, Object> params = new HashMap<>();
        params.put("Usercode", Usercode);
        params.put("count", count);
        return engMapper.selectByUsercodeAndCount(params);
    }
    @Override
    public void deleteBatch(List<Integer> ids) {
        engMapper.deleteBatchByIds(ids);
    }
    @Override
    public List<Engistates> findByUserCodeWithLimit(String code, Integer count) {
        return engMapper.findByUserCodeWithLimit(code, count);
    }
}
