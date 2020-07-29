package com.lexiangmiao.sample.svc.mapper;

import com.lexiangmiao.sample.mybatis.domain.cee.ProvincialScore;
import com.lexiangmiao.sample.svc.dto.ProvincialScoreDTO;
import org.springframework.stereotype.Component;

/**
 * Created by mzxiao on 2020/7/29 10:46
 */
@Component
public class ProvincialScoreAdapter {
    public ProvincialScore provincialScoreDTOToProvincialScore(ProvincialScoreDTO dto) {


        if (dto == null) {
            return null;
        } else {
            ProvincialScore result = new ProvincialScore();
            result.setSchoolId(dto.getSchoolId());
            result.setSchoolName(dto.getSchoolName());
            result.setProvinceId(dto.getProvinceId());
            result.setType(dto.getType());
            result.setBatch(dto.getBatch());
            result.setZslx(dto.getZslx());
            result.setXclevel(dto.getXclevel());
            result.setMax(dto.getMax());
            result.setMinSection(dto.getMinSection());
            result.setMin(dto.getMin());
            result.setAverage(dto.getAverage());
            result.setFiling(dto.getFiling());
            result.setTypeControl(dto.getTypeControl());
            result.setBatchControl(dto.getBatchControl());
            result.setLocalBatchName(dto.getLocalBatchName());
            result.setZslxName(dto.getZslxName());
            result.setXclevelName(dto.getXclevelName());
            result.setProscore(dto.getProscore());
            result.setYear(dto.getYear());
            return result;
        }
    }
}
