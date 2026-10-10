package org.example.controller;

import org.example.entity.PartComparisonResult;
import org.example.service.Eqd_Service;
import org.example.service.Pcr_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pcr")
public class Pcr_controller {

    @Autowired
    private Pcr_Service pcrService;

    @Autowired
    public void Pcr_Controller(Pcr_Service pcrService) {
        this.pcrService = pcrService;
    }

    @GetMapping("/getLatestComparisonResult")
    public List<Object> getLatestComparisonResult() {
        List<Object> response = new ArrayList<>();
        List<PartComparisonResult> results = pcrService.getLatestComparisonResult();
        if (!results.isEmpty()) {
            // 获取最新比对结果
            PartComparisonResult latestResult = results.get(0);

            // 将点位总数信息添加到返回结果中
            response.add(latestResult.getComparisonSummary());

            // 将点位差异信息添加到返回结果中
            response.add(latestResult.getComparisonDiff());
        }
        return response;
    }

}
