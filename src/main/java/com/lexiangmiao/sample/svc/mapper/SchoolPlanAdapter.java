package com.lexiangmiao.sample.svc.mapper;

import com.lexiangmiao.sample.mybatis.domain.cee.SchoolPlan;
import com.lexiangmiao.sample.svc.dto.SchoolPlanDTO;
import org.springframework.stereotype.Component;

/**
 * Created by mzxiao on 2020/7/30 11:36
 */
@Component
public class SchoolPlanAdapter {
    public SchoolPlan schoolPlanDTOToSchoolPlan(SchoolPlanDTO dto) {
        if (dto == null) {
            return null;
        } else {
            SchoolPlan result = new SchoolPlan();
            result.setSchoolId( dto.getSchoolId());
            result.setSpecialId( dto.getSpecialId());
            result.setNum( dto.getNum());
            result.setType( dto.getType());
            result.setProvince( dto.getProvince());
            result.setBatch( dto.getBatch());
            result.setId( dto.getId());
            result.setSpid( dto.getSpid());
            result.setZslx( dto.getZslx());
            result.setInfo( dto.getInfo());
            result.setLevel1Name( dto.getLevel1Name());
            result.setLevel2Name( dto.getLevel2Name());
            result.setLevel3Name( dto.getLevel3Name());
            result.setLevel1( dto.getLevel1());
            result.setLevel2( dto.getLevel2());
            result.setSpname( dto.getSpname());
            result.setLevel3( dto.getLevel3());
            result.setLocalBatchName( dto.getLocalBatchName());
            result.setZslxName( dto.getZslxName());
            result.setYear( dto.getYear());
            return result;
        }
    }
}
