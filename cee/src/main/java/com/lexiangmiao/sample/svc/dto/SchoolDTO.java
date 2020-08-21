package com.lexiangmiao.sample.svc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mzxiao on 2020/7/27 9:55
 */
public class SchoolDTO {
    @JsonProperty("address")
    String address;
    @JsonProperty("admissions")
    int admissions;
    @JsonProperty("answerurl")
    String answerurl;
    @JsonProperty("belong")
    String belong;
    @JsonProperty("central")
    int central;
    @JsonProperty("city_id")
    int cityId;
    @JsonProperty("city_name")
    String cityName;
    @JsonProperty("code_enroll")
    int codeEnroll;
    @JsonProperty("colleges_level")
    String collegesLevel;
    @JsonProperty("county_id")
    int countyId;
    @JsonProperty("county_name")
    String countyName;
    @JsonProperty("department")
    int department;
    @JsonProperty("doublehigh")
    int doublehigh;
    @JsonProperty("dual_class")
    int dualClass;
    @JsonProperty("dual_class_name")
    String dualClassName;
    @JsonProperty("f211")
    int f211;
    @JsonProperty("f985")
    int f985;
    @JsonProperty("id")
    String id;
    @JsonProperty("is_recruitment")
    int isRecruitment;
    @JsonProperty("is_top")
    int isTop;
    @JsonProperty("level")
    int level;
    @JsonProperty("level_name")
    String levelName;
    @JsonProperty("name")
    String name;
    @JsonProperty("nature")
    int nature;
    @JsonProperty("nature_name")
    String natureName;
    @JsonProperty("province_id")
    int provinceId;
    @JsonProperty("province_name")
    String provinceName;
    @JsonProperty("publish_id")
    String publishId;
    @JsonProperty("rank")
    int rank;
    @JsonProperty("rank_type")
    int rankType;
    @JsonProperty("school_id")
    int schoolId;
    @JsonProperty("school_type")
    int schoolType;
    @JsonProperty("single_province")
    String singleProvince;
//    @JsonProperty("special")
    @JsonIgnore
    int special;
    @JsonProperty("type")
    int type;
    @JsonProperty("type_name")
    String typeName;
    @JsonProperty("view_month")
    int viewMonth;
    @JsonProperty("view_total")
    String viewTotal;
    @JsonProperty("view_total_number")
    int viewTotalNumber;
    @JsonProperty("view_week")
    int viewWeek;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdmissions() {
        return admissions;
    }

    public void setAdmissions(int admissions) {
        this.admissions = admissions;
    }

    public String getAnswerurl() {
        return answerurl;
    }

    public void setAnswerurl(String answerurl) {
        this.answerurl = answerurl;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public int getCentral() {
        return central;
    }

    public void setCentral(int central) {
        this.central = central;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCodeEnroll() {
        return codeEnroll;
    }

    public void setCodeEnroll(int codeEnroll) {
        this.codeEnroll = codeEnroll;
    }

    public String getCollegesLevel() {
        return collegesLevel;
    }

    public void setCollegesLevel(String collegesLevel) {
        this.collegesLevel = collegesLevel;
    }

    public int getCountyId() {
        return countyId;
    }

    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getDoublehigh() {
        return doublehigh;
    }

    public void setDoublehigh(int doublehigh) {
        this.doublehigh = doublehigh;
    }

    public int getDualClass() {
        return dualClass;
    }

    public void setDualClass(int dualClass) {
        this.dualClass = dualClass;
    }

    public String getDualClassName() {
        return dualClassName;
    }

    public void setDualClassName(String dualClassName) {
        this.dualClassName = dualClassName;
    }

    public int getF211() {
        return f211;
    }

    public void setF211(int f211) {
        this.f211 = f211;
    }

    public int getF985() {
        return f985;
    }

    public void setF985(int f985) {
        this.f985 = f985;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIsRecruitment() {
        return isRecruitment;
    }

    public void setIsRecruitment(int isRecruitment) {
        this.isRecruitment = isRecruitment;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public String getNatureName() {
        return natureName;
    }

    public void setNatureName(String natureName) {
        this.natureName = natureName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRankType() {
        return rankType;
    }

    public void setRankType(int rankType) {
        this.rankType = rankType;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(int schoolType) {
        this.schoolType = schoolType;
    }

    public String getSingleProvince() {
        return singleProvince;
    }

    public void setSingleProvince(String singleProvince) {
        this.singleProvince = singleProvince;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getViewMonth() {
        return viewMonth;
    }

    public void setViewMonth(int viewMonth) {
        this.viewMonth = viewMonth;
    }

    public String getViewTotal() {
        return viewTotal;
    }

    public void setViewTotal(String viewTotal) {
        this.viewTotal = viewTotal;
    }

    public int getViewTotalNumber() {
        return viewTotalNumber;
    }

    public void setViewTotalNumber(int viewTotalNumber) {
        this.viewTotalNumber = viewTotalNumber;
    }

    public int getViewWeek() {
        return viewWeek;
    }

    public void setViewWeek(int viewWeek) {
        this.viewWeek = viewWeek;
    }
}
