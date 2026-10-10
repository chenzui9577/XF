package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.PartComparisonResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PartComparisonResultMapper {

    List<PartComparisonResult> getLatestComparisonResult();
}
