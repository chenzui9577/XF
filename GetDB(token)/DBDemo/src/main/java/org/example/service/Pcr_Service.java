package org.example.service;

import org.example.entity.PartComparisonResult;
import org.example.entity.Sys_equideti;

import java.util.List;

public interface Pcr_Service {
    List<PartComparisonResult> getLatestComparisonResult();
}
