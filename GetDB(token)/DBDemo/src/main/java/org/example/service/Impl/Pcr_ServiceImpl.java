package org.example.service.Impl;

import org.example.entity.PartComparisonResult;
import org.example.entity.Sys_equideti;
import org.example.mapper.PartComparisonResultMapper;
import org.example.mapper.Sys_equidetiMapper;
import org.example.service.Pcr_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class Pcr_ServiceImpl implements Pcr_Service {
    @Resource
    @Autowired
    private PartComparisonResultMapper pcrMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(Eqd_ServiceImpl.class);
    @Autowired
    public Pcr_ServiceImpl(PartComparisonResultMapper pcrMapper) {
        this.pcrMapper = pcrMapper;
    }
    @Override
    public List<PartComparisonResult> getLatestComparisonResult(){
        List<PartComparisonResult> eqd = pcrMapper.getLatestComparisonResult();
        return eqd;
    }
}
