package com.lexiangmiao.sample.svc.mapper;

import com.lexiangmiao.sample.mybatis.domain.cee.SchoolInfo;
import com.lexiangmiao.sample.svc.dto.SchoolDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by mzxiao on 2020/7/29 9:30
 */
@Component
public class SchoolAdapter {
    public SchoolAdapter() {
    }

//    public List<School> usersToUserDTOs(List<SchoolInfo> users) {
//        return (List)users.stream().filter(Objects::nonNull).map(this::userToUserDTO).collect(Collectors.toList());
//    }
//
//    public School userToUserDTO(SchoolInfo user) {
//        return new School(user);
//    }


    public List<SchoolInfo> schoolDTOsToSchoolInfos(List<SchoolDTO> userDTOs) {
        return (List) userDTOs.stream().filter(Objects::nonNull).map(this::schoolDTOToSchoolInfo).collect(Collectors.toList());
    }

    public SchoolInfo schoolDTOToSchoolInfo(SchoolDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            SchoolInfo result = new SchoolInfo();
            result.setId(userDTO.getId());
            result.setAddress(userDTO.getAddress());
            result.setAdmissions(userDTO.getAdmissions());
            result.setAnswerurl(userDTO.getAnswerurl());
            result.setBelong(userDTO.getBelong());
            result.setCentral(userDTO.getCentral());
            result.setCityId(userDTO.getCityId());
            result.setCityName(userDTO.getCityName());
            result.setCodeEnroll(userDTO.getCodeEnroll());
            result.setCollegesLevel(userDTO.getCollegesLevel());
            result.setCountyId(userDTO.getCountyId());
            result.setCountyName(userDTO.getCountyName());
            result.setDepartment(userDTO.getDepartment());
            result.setDoublehigh(userDTO.getDoublehigh());
            result.setDualClass(userDTO.getDualClass());
            result.setDualClassName(userDTO.getDualClassName());
            result.setF211(userDTO.getF211());
            result.setF985(userDTO.getF985());
            result.setId(userDTO.getId());
            result.setIsRecruitment(userDTO.getIsRecruitment());
            result.setIsTop(userDTO.getIsTop());
            result.setLevel(userDTO.getLevel());
            result.setLevelName(userDTO.getLevelName());
            result.setName(userDTO.getName());
            result.setNature(userDTO.getNature());
            result.setNatureName(userDTO.getNatureName());
            result.setProvinceId(userDTO.getProvinceId());
            result.setProvinceName(userDTO.getProvinceName());
            result.setPublishId(userDTO.getPublishId());
            result.setRank(userDTO.getRank());
            result.setRankType(userDTO.getRankType());
            result.setSchoolId(userDTO.getSchoolId());
            result.setSchoolType(userDTO.getSchoolType());
            result.setSingleProvince(userDTO.getSingleProvince());
            result.setType(userDTO.getType());
            result.setTypeName(userDTO.getTypeName());
            result.setViewMonth(userDTO.getViewMonth());
            result.setViewTotal(userDTO.getViewTotal());
            result.setViewTotalNumber(userDTO.getViewTotalNumber());
            result.setViewWeek(userDTO.getViewWeek());
            return result;
        }
    }
}
